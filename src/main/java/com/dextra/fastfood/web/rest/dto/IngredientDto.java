package com.dextra.fastfood.web.rest.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IngredientDto
{
    private Long id;
    private String name;
    private BigDecimal price;

    public IngredientDto(){}

    public IngredientDto(Long id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
