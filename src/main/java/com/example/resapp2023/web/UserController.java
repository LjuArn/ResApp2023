package com.example.resapp2023.web;


import com.example.resapp2023.domain.bindingModel.UserLoginBindingModel;
import com.example.resapp2023.domain.bindingModel.UserRegisterBindingModel;
import com.example.resapp2023.domain.serviceModel.UserServiceModel;
import com.example.resapp2023.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService,
                          ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/register")
    public String register(Model model) {

        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirmPost(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())
        ) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";

        }

        boolean isNameExist = userService.isNameExistMetod(userRegisterBindingModel.getUsername());

        if (isNameExist) {
            redirectAttributes.addFlashAttribute("isNameExist", true)
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBidingModel",
                            bindingResult);
            return "redirect:register";
        }


        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

//_________________________________________________________________________________________________________

    @GetMapping("/login")
    public String login(Model model) {

        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
        }

        if (!model.containsAttribute("isNotFound")) {
            model.addAttribute("isNotFound", false);
        }
        return "login";
    }
    

    @PostMapping("/login")
    public String loginConfirmPost(@Valid UserLoginBindingModel userLoginBindingModel,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);
            return "redirect:login";
        }

        UserServiceModel user = userService
                .findUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                        userLoginBindingModel.getPassword());


        if (user == null) {
            redirectAttributes
                    .addFlashAttribute("isNotFound", true)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult)
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            return "redirect:login";
        }

        userService.loginUser(user.getId(), user.getUsername());

        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logOut() {
        userService.logOut();
        return "redirect:/";
    }
}