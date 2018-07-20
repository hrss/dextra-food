package com.dextra.fastfood.repository;

import com.dextra.fastfood.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long>
{
}
