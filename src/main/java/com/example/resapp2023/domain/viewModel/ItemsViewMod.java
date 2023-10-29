package com.example.resapp2023.domain.viewModel;

import com.example.resapp2023.domain.entity.ConditionEntity;
import com.example.resapp2023.domain.entity.enums.ConditionsEnums;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class ItemsViewMod {

    private Long id;
    private String description;
    private BigDecimal price;
    private ConditionsEnums condition;

    public ItemsViewMod() {
    }

    public Long getId() {
        return id;
    }

    public ItemsViewMod setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemsViewMod setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemsViewMod setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionsEnums getCondition() {
        return condition;
    }

    public ItemsViewMod setCondition(ConditionsEnums condition) {
        this.condition = condition;
        return this;
    }
}
