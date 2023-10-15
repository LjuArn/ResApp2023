package com.example.resapp2023.repository;

import com.example.resapp2023.domain.entity.ConditionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<ConditionEntity, Long> {
}
