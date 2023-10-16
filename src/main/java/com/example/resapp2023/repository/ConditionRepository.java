package com.example.resapp2023.repository;

import com.example.resapp2023.domain.entity.ConditionEntity;
import com.example.resapp2023.domain.entity.enums.ConditionsEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConditionRepository extends JpaRepository<ConditionEntity, Long> {

    Optional<ConditionEntity>findByName(ConditionsEnums name);
}
