package com.dextra.fastfood.service;

import com.dextra.fastfood.domain.Ingredient;
import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.repository.IngredientRepository;
import com.dextra.fastfood.repository.SandwichRepository;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService
{
    private SandwichRepository sandwichRepository;

    private IngredientRepository ingredientRepository;


    @Autowired
    public PriceService(final SandwichRepository sandwichRepository, IngredientRepository ingredientRepository)
    {
        this.sandwichRepository = sandwichRepository;
        this.ingredientRepository = ingredientRepository;
    }


    public BigDecimal getSandwichPrice(Sandwich sandwich)
    {
        BigDecimal price;

        if (sandwich.getId() != null && this.sandwichRepository.findById(sandwich.getId()).isPresent())
        {
            sandwich = this.sandwichRepository.findById(sandwich.getId()).get();
        }

        price = this.getPrice(sandwich.getIngredientMap());

        price = this.checkOffers(sandwich.getIngredientMap(), price);

        return price;

    }


    private BigDecimal checkOffers(Map<Ingredient, Long> ingredients, BigDecimal price)
    {
        Ingredient meat = ingredientRepository.getOne(3L);
        Ingredient bacon = ingredientRepository.getOne(2L);
        Ingredient cheese = ingredientRepository.getOne(5L);
        Ingredient lettuce = ingredientRepository.getOne(1L);

        if (ingredients.containsKey(meat))
        {
            if (ingredients.get(meat) > 2)
            {
                price = price.subtract(meat.getPrice().multiply(new BigDecimal(ingredients.get(meat) / 3)));
            }
        }

        if (ingredients.containsKey(cheese))
        {
            if (ingredients.get(cheese) > 2)
            {
                price = price.subtract(cheese.getPrice().multiply(new BigDecimal(ingredients.get(cheese) / 3)));
            }
        }

        if (ingredients.containsKey(lettuce) && !ingredients.containsKey(bacon))
        {

            price = price.multiply(new BigDecimal(0.9));

        }

        return price;
    }


    private BigDecimal getPrice(Map<Ingredient, Long> ingredients)
    {
        BigDecimal price = new BigDecimal(0);
        for (Ingredient ingredient : ingredients.keySet())
        {
            price = price.add(ingredient.getPrice().multiply(new BigDecimal(ingredients.get(ingredient))));
        }
        return price;
    }

}
