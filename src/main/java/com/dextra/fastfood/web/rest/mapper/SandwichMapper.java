package com.dextra.fastfood.web.rest.mapper;

import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.domain.SandwichIngredient;
import com.dextra.fastfood.repository.IngredientRepository;
import com.dextra.fastfood.web.rest.dto.SandwichDto;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class SandwichMapper implements Mapper<Sandwich, SandwichDto> {

  private IngredientRepository ingredientRepository;

  public SandwichMapper(final IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  @Override
  public Sandwich fromDto(SandwichDto dto) {
    Sandwich sandwich = new Sandwich();
    sandwich.setId(dto.getId());
    sandwich.setName(dto.getName());

    if (dto.getIngredients() != null) {
      Set<SandwichIngredient> ingredientSet = new HashSet<>();
      sandwich.setSandwichIngredients(ingredientSet);
      dto.getIngredients().forEach((k, v) ->
          sandwich.getSandwichIngredients()
              .add(new SandwichIngredient(null, ZonedDateTime.now(), ZonedDateTime.now(), sandwich,
                  ingredientRepository.getOne(k), v)));

    }

    return sandwich;
  }


  @Override
  public SandwichDto toDto(Sandwich dataObject) {

    SandwichDto dto = SandwichDto.builder().id(dataObject.getId()).name(dataObject.getName())
        .build();
    dto.setIngredients(new HashMap<>());
    dataObject.getIngredientMap().forEach((k, v) -> {
      dto.getIngredients().put(k.getId(), v);
    });

    return dto;
  }


  @Override
  public List<SandwichDto> toDtoList(List<Sandwich> dataObjects) {
    List<SandwichDto> sandwichDtos = new ArrayList<>();
    dataObjects.forEach(data -> sandwichDtos.add(this.toDto(data)));
    return sandwichDtos;
  }
}
