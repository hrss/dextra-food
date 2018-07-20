package com.dextra.fastfood.web.rest.dto;

import java.util.HashMap;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SandwichDto
{
    private Long id;
    private String name;
    private HashMap<Long, Long> ingredients;

    public SandwichDto(){}

    public SandwichDto(Long id, String name, HashMap<Long, Long> ingredients){
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }
}
