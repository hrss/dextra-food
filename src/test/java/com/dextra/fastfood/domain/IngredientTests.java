package com.dextra.fastfood.domain;

import java.math.BigDecimal;
import java.util.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IngredientTests.class)
public class IngredientTests
{
    @Test
    public void notEqualNull(){
        Ingredient ingredient = new Ingredient();
        assertFalse(ingredient.equals(null));
    }

    @Test
    public void notEqualDifferentClass(){
        Ingredient ingredient = new Ingredient();
        assertFalse(ingredient.equals(new BigDecimal(0)));
    }

    @Test
    public void notEqualDifferentName(){
        Ingredient ingredient1 = new Ingredient();
        Ingredient ingredient2 = new Ingredient();
        ingredient1.setName("Hello");
        ingredient2.setName("Not Hello");

        assertFalse(ingredient1.equals(ingredient2));
    }

    @Test
    public void notEqualDifferentId(){
        Ingredient ingredient1 = new Ingredient();
        Ingredient ingredient2 = new Ingredient();
        ingredient1.setName("Hello");
        ingredient2.setName("Hello");

        ingredient1.setId(1L);
        ingredient2.setId(2L);

        assertFalse(ingredient1.equals(ingredient2));
    }

    @Test
    public void equalIngredients(){
        Ingredient ingredient1 = new Ingredient();
        Ingredient ingredient2 = new Ingredient();
        ingredient1.setName("Hello");
        ingredient2.setName("Hello");

        ingredient1.setId(1L);
        ingredient2.setId(1L);

        assertTrue(ingredient1.equals(ingredient2));
    }

    @Test
    public void hashCodeTest(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        assertEquals(Objects.hashCode(1L), ingredient.hashCode());
    }

}
