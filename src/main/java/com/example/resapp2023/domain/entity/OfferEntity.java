package com.example.resapp2023.domain.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private BigDecimal price;


    @ManyToOne
    @JoinColumn(name = "condition_id")
    private ConditionEntity condition;

    @ManyToOne
    private UserEntity userBy;

    @ManyToOne
    private UserEntity userBoughtBy;

    public OfferEntity() {
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionEntity getCondition() {
        return condition;
    }

    public OfferEntity setCondition(ConditionEntity condition) {
        this.condition = condition;
        return this;
    }

    public UserEntity getUserBy() {
        return userBy;
    }

    public OfferEntity setUserBy(UserEntity userBy) {
        this.userBy = userBy;
        return this;
    }

    public UserEntity getUserBoughtBy() {
        return userBoughtBy;
    }

    public OfferEntity setUserBoughtBy(UserEntity userBoughtBy) {
        this.userBoughtBy = userBoughtBy;
        return this;
    }
}

//•	Has a Description (not null)
//o	Description length must be between 2 and 50 characters (inclusive of 2 and 50).

//•	Has a Price (not null) - floating point number
//o	The price must be a positive number

//•	Has a Condition (not null)
//o	One offer has one contition and one condition can have many offers.
