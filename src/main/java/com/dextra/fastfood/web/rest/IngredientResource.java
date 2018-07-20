package com.dextra.fastfood.web.rest;

import com.dextra.fastfood.domain.Ingredient;
import com.dextra.fastfood.service.IngredientService;
import com.dextra.fastfood.web.rest.dto.IngredientDto;
import com.dextra.fastfood.web.rest.mapper.IngredientMapper;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Ingredient resource (controller).
 */
@RestController
@RequestMapping("/api/ingredient")
@Service
public class IngredientResource
{
    private IngredientService ingredientService;

    private IngredientMapper mapper;


    /**
     * Instantiates a new Ingredient resource.
     *
     * @param ingredientService the ingredient service
     * @param ingredientMapper  the ingredient mapper
     */
    @Autowired
    public IngredientResource(IngredientService ingredientService, IngredientMapper ingredientMapper)
    {
        this.ingredientService = ingredientService;
        this.mapper = ingredientMapper;
    }


    /**
     * Gets all ingredients.
     *
     * @return the all ingredients
     */
    @GetMapping("")
    public ResponseEntity<List<IngredientDto>> getAllIngredients()
    {
        List<Ingredient> ingredient = ingredientService.getAll();

        return Optional.ofNullable(ingredient)
            .map(result -> new ResponseEntity<List<IngredientDto>>(
                mapper.toDtoList(result),
                HttpStatus.OK))
            .orElse(new ResponseEntity<List<IngredientDto>>(HttpStatus.NOT_FOUND));
    }


    /**
     * Gets ingredient by id.
     *
     * @param ingredientId the ingredient id
     * @return the ingredient
     */
    @GetMapping("/{ingredientId}")
    public ResponseEntity<IngredientDto> getIngredient(@Valid @PathVariable long ingredientId)
    {
        Ingredient ingredient = ingredientService.getById(ingredientId);

        return Optional.ofNullable(ingredient)
            .map(result -> new ResponseEntity<IngredientDto>(
                mapper.toDto(result),
                HttpStatus.OK))
            .orElse(new ResponseEntity<IngredientDto>(HttpStatus.NOT_FOUND));
    }
}
