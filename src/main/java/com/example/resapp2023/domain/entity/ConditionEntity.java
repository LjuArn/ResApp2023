package com.example.resapp2023.domain.entity;

import com.example.resapp2023.domain.entity.enums.ConditionsEnums;
import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "conditions")
public class ConditionEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionsEnums name;

    @Column(nullable = false)
    private String description;


    public ConditionEntity() {
    }

    public ConditionsEnums getName() {
        return name;
    }

    public ConditionEntity setName(ConditionsEnums name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ConditionEntity setDescription(String description) {
        this.description = description;
        return this;
    }


}
//•	Has a Condition name (unique, not null)
//o	an option between (EXCELLENT, GOOD, ACCEPTABLE)

//•	Has a Description  (not null)
//o	For EXCELLENT - "In perfect condition"
//o	For GOOD – "Some signs of wear and tear or minor defects"
//o	For ACCEPTABLE – "The item is fairly worn but continues to function properly"
//
