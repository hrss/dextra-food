package com.dextra.fastfood.utils;

import com.dextra.fastfood.domain.Ingredient;
import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.domain.SandwichIngredient;
import com.dextra.fastfood.domain.SandwichIngredientPK;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import javax.persistence.criteria.CriteriaBuilder;

public class TestUtils
{
    public enum Ingredients{
        MEAT(3L), BACON(2L), LETTUCE(1L), CHEESE(5L);

        private Long id;

        Ingredients(Long id){
            this.id = id;
        }


        public Long getId()
        {
            return id;
        }
    }


    public static Sandwich createSandwich(){
        Sandwich sandwich = new Sandwich();
        sandwich.setId(1L);
        sandwich.setName("Default-Burguer");
        sandwich.setSandwichIngredients(new HashSet<>());
        sandwich.setDateCreated(ZonedDateTime.now());
        sandwich.setDateUpdated(ZonedDateTime.now());


        SandwichIngredient sandwichIngredient1 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient2 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient3 = new SandwichIngredient();

        sandwichIngredient1.setId(new SandwichIngredientPK());
        sandwichIngredient2.setId(new SandwichIngredientPK());
        sandwichIngredient3.setId(new SandwichIngredientPK());

        sandwichIngredient1.setIngredient(getCheese());
        sandwichIngredient1.setSandwich(sandwich);
        sandwichIngredient1.setQuantity(1L);

        sandwichIngredient2.setIngredient(getMeat());
        sandwichIngredient2.setSandwich(sandwich);
        sandwichIngredient2.setQuantity(1L);

        sandwichIngredient3.setIngredient(getBacon());
        sandwichIngredient3.setSandwich(sandwich);
        sandwichIngredient3.setQuantity(1L);

        sandwich.getSandwichIngredients().add(sandwichIngredient1);
        sandwich.getSandwichIngredients().add(sandwichIngredient2);
        sandwich.getSandwichIngredients().add(sandwichIngredient3);

        return sandwich;
    }

    public static Sandwich createMeatSandwich(){
        Sandwich sandwich = new Sandwich();
        sandwich.setId(2L);
        sandwich.setName("Meat-Burguer");
        sandwich.setSandwichIngredients(new HashSet<>());
        sandwich.setDateCreated(ZonedDateTime.now());
        sandwich.setDateUpdated(ZonedDateTime.now());

        SandwichIngredient sandwichIngredient1 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient2 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient3 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient4 = new SandwichIngredient();


        sandwichIngredient1.setId(new SandwichIngredientPK());
        sandwichIngredient2.setId(new SandwichIngredientPK());
        sandwichIngredient3.setId(new SandwichIngredientPK());

        sandwichIngredient1.setIngredient(getCheese());
        sandwichIngredient1.setSandwich(sandwich);
        sandwichIngredient1.setQuantity(1L);

        sandwichIngredient2.setIngredient(getMeat());
        sandwichIngredient2.setSandwich(sandwich);
        sandwichIngredient2.setQuantity(3L);

        sandwichIngredient3.setIngredient(getLettuce());
        sandwichIngredient3.setSandwich(sandwich);
        sandwichIngredient3.setQuantity(1L);

        sandwichIngredient4.setIngredient(getBacon());
        sandwichIngredient4.setSandwich(sandwich);
        sandwichIngredient4.setQuantity(1L);

        sandwich.getSandwichIngredients().add(sandwichIngredient1);
        sandwich.getSandwichIngredients().add(sandwichIngredient2);
        sandwich.getSandwichIngredients().add(sandwichIngredient3);
        sandwich.getSandwichIngredients().add(sandwichIngredient4);


        return sandwich;
    }

    public static Sandwich createCheeseSandwich(){
        Sandwich sandwich = new Sandwich();
        sandwich.setId(3L);
        sandwich.setName("Cheese-Burguer");
        sandwich.setSandwichIngredients(new HashSet<>());
        sandwich.setDateCreated(ZonedDateTime.now());
        sandwich.setDateUpdated(ZonedDateTime.now());

        SandwichIngredient sandwichIngredient1 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient2 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient3 = new SandwichIngredient();

        sandwichIngredient1.setId(new SandwichIngredientPK());
        sandwichIngredient2.setId(new SandwichIngredientPK());
        sandwichIngredient3.setId(new SandwichIngredientPK());

        sandwichIngredient1.setIngredient(getCheese());
        sandwichIngredient1.setSandwich(sandwich);
        sandwichIngredient1.setQuantity(3L);

        sandwichIngredient2.setIngredient(getMeat());
        sandwichIngredient2.setSandwich(sandwich);
        sandwichIngredient2.setQuantity(1L);

        sandwichIngredient3.setIngredient(getBacon());
        sandwichIngredient3.setSandwich(sandwich);
        sandwichIngredient3.setQuantity(1L);

        sandwich.getSandwichIngredients().add(sandwichIngredient1);
        sandwich.getSandwichIngredients().add(sandwichIngredient2);
        sandwich.getSandwichIngredients().add(sandwichIngredient3);

        return sandwich;
    }

    public static Sandwich createLightSandwich(){
        Sandwich sandwich = new Sandwich();
        sandwich.setId(4L);
        sandwich.setName("Light-Burguer");
        sandwich.setSandwichIngredients(new HashSet<>());
        sandwich.setDateCreated(ZonedDateTime.now());
        sandwich.setDateUpdated(ZonedDateTime.now());

        SandwichIngredient sandwichIngredient1 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient2 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient3 = new SandwichIngredient();

        sandwichIngredient1.setId(new SandwichIngredientPK());
        sandwichIngredient2.setId(new SandwichIngredientPK());
        sandwichIngredient3.setId(new SandwichIngredientPK());

        sandwichIngredient1.setIngredient(getCheese());
        sandwichIngredient1.setSandwich(sandwich);
        sandwichIngredient1.setQuantity(1L);

        sandwichIngredient2.setIngredient(getMeat());
        sandwichIngredient2.setSandwich(sandwich);
        sandwichIngredient2.setQuantity(1L);

        sandwichIngredient3.setIngredient(getLettuce());
        sandwichIngredient3.setSandwich(sandwich);
        sandwichIngredient3.setQuantity(1L);

        sandwich.getSandwichIngredients().add(sandwichIngredient1);
        sandwich.getSandwichIngredients().add(sandwichIngredient2);
        sandwich.getSandwichIngredients().add(sandwichIngredient3);

        return sandwich;
    }

    public static Sandwich createAllOffersSandwich(){
        Sandwich sandwich = new Sandwich();
        sandwich.setId(5L);
        sandwich.setName("Special-Burguer");
        sandwich.setSandwichIngredients(new HashSet<>());
        sandwich.setDateCreated(ZonedDateTime.now());
        sandwich.setDateUpdated(ZonedDateTime.now());

        SandwichIngredient sandwichIngredient1 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient2 = new SandwichIngredient();
        SandwichIngredient sandwichIngredient3 = new SandwichIngredient();

        sandwichIngredient1.setId(new SandwichIngredientPK());
        sandwichIngredient2.setId(new SandwichIngredientPK());
        sandwichIngredient3.setId(new SandwichIngredientPK());

        sandwichIngredient1.setIngredient(getCheese());
        sandwichIngredient1.setSandwich(sandwich);
        sandwichIngredient1.setQuantity(3L);

        sandwichIngredient2.setIngredient(getMeat());
        sandwichIngredient2.setSandwich(sandwich);
        sandwichIngredient2.setQuantity(3L);

        sandwichIngredient3.setIngredient(getLettuce());
        sandwichIngredient3.setSandwich(sandwich);
        sandwichIngredient3.setQuantity(1L);

        sandwich.getSandwichIngredients().add(sandwichIngredient1);
        sandwich.getSandwichIngredients().add(sandwichIngredient2);
        sandwich.getSandwichIngredients().add(sandwichIngredient3);

        return sandwich;
    }

    public static Ingredient getBacon(){
        Ingredient ingredient = new Ingredient();
        ingredient.setPrice(new BigDecimal(2));
        ingredient.setName(Ingredients.BACON.name());
        ingredient.setId(Ingredients.BACON.getId());
        ingredient.setDateCreated(ZonedDateTime.now());
        ingredient.setDateUpdated(ZonedDateTime.now());

        return ingredient;
    }

    public static Ingredient getMeat(){
        Ingredient ingredient = new Ingredient();
        ingredient.setPrice(new BigDecimal(3));
        ingredient.setName(Ingredients.MEAT.name());
        ingredient.setId(Ingredients.MEAT.getId());
        ingredient.setDateCreated(ZonedDateTime.now());
        ingredient.setDateUpdated(ZonedDateTime.now());

        return ingredient;
    }

    public static Ingredient getCheese(){
        Ingredient ingredient = new Ingredient();
        ingredient.setPrice(new BigDecimal(4));
        ingredient.setName(Ingredients.CHEESE.name());
        ingredient.setId(Ingredients.CHEESE.getId());
        return ingredient;
    }

    public static Ingredient getLettuce(){
        Ingredient ingredient = new Ingredient();
        ingredient.setPrice(new BigDecimal(5));
        ingredient.setName(Ingredients.LETTUCE.name());
        ingredient.setId(Ingredients.LETTUCE.getId());
        ingredient.setDateCreated(ZonedDateTime.now());
        ingredient.setDateUpdated(ZonedDateTime.now());

        return ingredient;
    }
}
