package com.example.resapp2023.service;

import com.example.resapp2023.domain.entity.ConditionEntity;
import com.example.resapp2023.domain.entity.enums.ConditionsEnums;
import com.example.resapp2023.domain.serviceModel.OfferServiceModel;

public interface OfferService {
    void addOffer(OfferServiceModel offerServiceModel);

}
