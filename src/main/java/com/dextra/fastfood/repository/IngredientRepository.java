package com.dextra.fastfood.repository;

import com.dextra.fastfood.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Ingredient repository.
 * We can use it to access the database and retrieve ingredients.
 */
public interface IngredientRepository extends JpaRepository<Ingredient,Long>
{
}
