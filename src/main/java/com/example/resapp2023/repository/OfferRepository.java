package com.example.resapp2023.repository;

import com.example.resapp2023.domain.entity.OfferEntity;
import com.example.resapp2023.domain.entity.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long>{

    List<OfferEntity>findByUserBoughtBy_Id(Long userBoughtBy_id);
}
