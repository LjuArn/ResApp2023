package com.example.resapp2023.service;

import com.example.resapp2023.domain.entity.ConditionEntity;
import com.example.resapp2023.domain.entity.enums.ConditionsEnums;

public interface ConditionService {
    void initCondition();

    ConditionEntity findByConditionNameEnum(ConditionsEnums name);
}
