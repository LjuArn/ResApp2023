package com.example.resapp2023.service;

import com.example.resapp2023.domain.entity.OfferEntity;
import com.example.resapp2023.domain.entity.UserEntity;
import com.example.resapp2023.domain.serviceModel.OfferServiceModel;
import com.example.resapp2023.domain.viewModel.ItemsViewMod;
import com.example.resapp2023.repository.ConditionRepository;
import com.example.resapp2023.repository.OfferRepository;
import com.example.resapp2023.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

private final OfferRepository offerRepository;
private final ModelMapper modelMapper;
private final CurrentUser currentUser;
private final UserService userService;
private final ConditionService conditionService;


    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService,
                            ConditionService conditionService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.conditionService = conditionService;

    }


    @Override
    public void addOffer(OfferServiceModel offerServiceModel) {

        OfferEntity offerEntity = modelMapper.map(offerServiceModel, OfferEntity.class);
        offerEntity.setUserBy(userService.findUserById(currentUser.getId()));
        offerEntity.setCondition(conditionService.findByConditionNameEnum(offerServiceModel.getConditionName()));
        offerRepository.save(offerEntity);

    }

    @Override
    public List<ItemsViewMod> findAllMyOffer(Long id) {
        return offerRepository.findByUserBoughtBy_Id(id)
                .stream().map(offerEntity -> modelMapper.map(offerEntity, ItemsViewMod.class))
                .collect(Collectors.toList());
    }


}
//   route.setCategories(routeServiceModel
//                .getCategories()
//                .stream()
//                .map(categoryNameEnum -> categoryService.findCathegoryByName(categoryNameEnum))
//                .collect(Collectors.toSet()));