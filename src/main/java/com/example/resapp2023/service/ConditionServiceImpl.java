package com.example.resapp2023.service;

import com.example.resapp2023.domain.entity.ConditionEntity;
import com.example.resapp2023.domain.entity.enums.ConditionsEnums;
import com.example.resapp2023.repository.ConditionRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionServiceImpl implements ConditionService {


    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void initCondition() {

        if (conditionRepository.count() != 0) {
            return;
        }

        Arrays.stream(ConditionsEnums.values())
                .forEach(conditionsEnums -> {
                    ConditionEntity condition = new ConditionEntity();
                    condition.setName(conditionsEnums);
                    switch (conditionsEnums) {
                        case GOOD -> condition.setDescription("Some signs of wear and tear or minor defects");
                        case EXCELLENT -> condition.setDescription("In perfect condition");
                        case ACCEPTABLE -> condition.setDescription("The item is fairly worn but continues to function properly");
                    }
                    conditionRepository.save(condition);
                });

    }

    @Override
    public ConditionEntity findByConditionNameEnum(ConditionsEnums conditionsEnums) {
        return conditionRepository.findByName(conditionsEnums).orElse(null);
    }

}

