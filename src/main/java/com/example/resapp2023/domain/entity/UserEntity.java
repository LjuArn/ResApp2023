package com.example.resapp2023.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "userBy")
    private Set<OfferEntity> offers;

    @OneToMany(mappedBy = "userBoughtBy")
    private Set<OfferEntity> boughtOffers;


    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<OfferEntity> getOffers() {
        return offers;
    }

    public UserEntity setOffers(Set<OfferEntity> offers) {
        this.offers = offers;
        return this;
    }

    public Set<OfferEntity> getBoughtOffers() {
        return boughtOffers;
    }

    public UserEntity setBoughtOffers(Set<OfferEntity> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }
}

//•	Has a Username (unique, not null)
//o	Username length must be between 3 and 20 characters (inclusive of 3 and 20).

//•	Has a Password (not null)
//o	Password length must be between 3 and 20 characters (inclusive of 3 and 20).

//•	Has an Email (unique, not null)
//o	Must contain '@'.

//•	Has Offers
//o	The offers contains users offers. One user may have many offers and one offer can be created by only one user.

//•	Has boughtOffers
//o	Collection with the offers that the user bought. One user may have many offers in boughtOffers.