package com.example.resapp2023.repository;

import com.example.resapp2023.domain.entity.OfferEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long>{
}
