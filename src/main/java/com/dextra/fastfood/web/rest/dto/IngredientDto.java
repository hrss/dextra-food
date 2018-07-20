package com.dextra.fastfood.web.rest.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Ingredient dto.
 */
@Getter
@Setter
@Builder
public class IngredientDto
{
    private Long id;
    private String name;
    private BigDecimal price;


    /**
     * Instantiates a new Ingredient dto.
     */
    public IngredientDto(){}


    /**
     * Instantiates a new Ingredient dto.
     *
     * @param id    the id
     * @param name  the name
     * @param price the price
     */
    public IngredientDto(Long id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
