package com.example.resapp2023.domain.bindingModel;

import com.example.resapp2023.domain.entity.enums.ConditionsEnums;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class OfferBindingModel {

    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters")
    private String description;
    @Positive(message = "Price must be positive number!!!!!!!")
    private BigDecimal price;
    @NotNull(message = "You must select condition!!!!!!!!!!!!!!!!!!")
    private ConditionsEnums condition;

    public OfferBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public OfferBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionsEnums getCondition() {
        return condition;
    }

    public OfferBindingModel setCondition(ConditionsEnums condition) {
        this.condition = condition;
        return this;
    }
}
