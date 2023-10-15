package com.example.resapp2023.service;

import com.example.resapp2023.domain.entity.OfferEntity;
import com.example.resapp2023.domain.serviceModel.OfferServiceModel;
import com.example.resapp2023.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

private final OfferRepository offerRepository;
private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addOffer(OfferServiceModel offerServiceModel) {

        OfferEntity offerEntity = modelMapper.map(offerServiceModel, OfferEntity.class);
        offerRepository.save(offerEntity);
    }
}
