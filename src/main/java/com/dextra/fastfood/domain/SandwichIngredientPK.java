package com.dextra.fastfood.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class SandwichIngredientPK implements Serializable
{
    @Column(name = "sandwich_id")
    private Long sandwichId;

    @Column(name = "ingredient_id")
    private Long ingredientId;
}
