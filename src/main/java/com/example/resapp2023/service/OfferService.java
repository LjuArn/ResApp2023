package com.example.resapp2023.service;

import com.example.resapp2023.domain.entity.ConditionEntity;
import com.example.resapp2023.domain.entity.enums.ConditionsEnums;
import com.example.resapp2023.domain.serviceModel.OfferServiceModel;
import com.example.resapp2023.domain.viewModel.ItemsViewMod;

import java.util.List;

public interface OfferService {
    void addOffer(OfferServiceModel offerServiceModel);

    List<ItemsViewMod> findAllMyOffer(Long id);
}
