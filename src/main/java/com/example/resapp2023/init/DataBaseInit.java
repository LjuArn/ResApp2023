package com.example.resapp2023.init;


import com.example.resapp2023.service.ConditionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final ConditionService conditionService;

    public DataBaseInit(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @Override
    public void run(String... args) throws Exception {

        conditionService.initCondition();
    }
}
