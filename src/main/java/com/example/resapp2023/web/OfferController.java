package com.example.resapp2023.web;


import com.example.resapp2023.domain.bindingModel.OfferBindingModel;
import com.example.resapp2023.domain.serviceModel.OfferServiceModel;
import com.example.resapp2023.service.OfferService;
import com.example.resapp2023.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final CurrentUser currentUser;
    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OfferController(CurrentUser currentUser,
                           OfferService offerService,
                           ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String addOrder(Model model){

        if (currentUser.getId() == null) {
            return "redirect:users/login";
        }

        if (!model.containsAttribute("offerBindingModel")) {
            model.addAttribute("offerBindingModel", new OfferBindingModel());
        }

        return "offer-add";
    }

    @PostMapping("/add")
    public String AddConfirm(@Valid OfferBindingModel offerBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("offerBindingModel", offerBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerBindingModel",
                            bindingResult);
            return "redirect:add";
        }


       offerService.addOffer(modelMapper
                .map(offerBindingModel, OfferServiceModel.class));

        return "redirect:/";
    }

}
