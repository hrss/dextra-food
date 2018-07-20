package com.dextra.fastfood.web.rest.mapper;

import com.dextra.fastfood.domain.Ingredient;
import com.dextra.fastfood.web.rest.dto.IngredientDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IngredientMapper implements Mapper<Ingredient, IngredientDto> {

  @Override
  public Ingredient fromDto(IngredientDto dto) {
    Ingredient ingredient = new Ingredient();
    ingredient.setId(dto.getId());
    ingredient.setName(dto.getName());
    ingredient.setPrice(dto.getPrice());
    return ingredient;
  }


  @Override
  public IngredientDto toDto(Ingredient dataObject) {
    IngredientDto ingredientDto =
        IngredientDto.builder().id(dataObject.getId()).name(dataObject.getName())
            .price(dataObject.getPrice()).build();

    return ingredientDto;
  }


  @Override
  public List<IngredientDto> toDtoList(List<Ingredient> dataObjects) {
    List<IngredientDto> ingredientDtoList = new ArrayList<>();
    dataObjects.forEach(data -> ingredientDtoList.add(this.toDto(data)));
    return ingredientDtoList;
  }
}
