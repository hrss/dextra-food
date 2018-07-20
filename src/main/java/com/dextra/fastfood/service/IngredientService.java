package com.dextra.fastfood.service;

import com.dextra.fastfood.domain.Ingredient;
import com.dextra.fastfood.repository.IngredientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Ingredient service.
 */
@Service
public class IngredientService {

  private IngredientRepository ingredientRepository;


  /**
   * Instantiates a new Ingredient service.
   *
   * @param ingredientRepository the ingredient repository
   */
  @Autowired
  public IngredientService(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }


  /**
   * Gets an ingredient by its id.
   *
   * @param id the id
   * @return the desired ingredient
   */
  public Ingredient getById(Long id) {
    return ingredientRepository.getOne(id);
  }


  /**
   * Get all the ingredients from the db.
   *
   * @return the ingredients list
   */
  public List<Ingredient> getAll() {
    return ingredientRepository.findAll();
  }
}
