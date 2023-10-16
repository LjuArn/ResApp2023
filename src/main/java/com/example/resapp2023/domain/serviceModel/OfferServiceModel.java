package com.example.resapp2023.domain.serviceModel;

import com.example.resapp2023.domain.entity.ConditionEntity;
import com.example.resapp2023.domain.entity.enums.ConditionsEnums;

import java.math.BigDecimal;

public class OfferServiceModel {

    private Long id;
    private String description;
    private BigDecimal price;
    private ConditionsEnums conditionName;

    public OfferServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public OfferServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionsEnums getConditionName() {
        return conditionName;
    }

    public OfferServiceModel setConditionName(ConditionsEnums conditionName) {
        this.conditionName = conditionName;
        return this;
    }
}
