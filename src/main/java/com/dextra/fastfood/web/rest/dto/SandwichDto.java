package com.dextra.fastfood.web.rest.dto;

import java.util.HashMap;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Sandwich dto.
 */
@Getter
@Setter
@Builder
public class SandwichDto {

  private Long id;
  private String name;
  private HashMap<Long, Long> ingredients;


  /**
   * Instantiates a new Sandwich dto.
   */
  public SandwichDto() {
  }


  /**
   * Instantiates a new Sandwich dto.
   *
   * @param id the id
   * @param name the name
   * @param ingredients the ingredients
   */
  public SandwichDto(Long id, String name, HashMap<Long, Long> ingredients) {
    this.id = id;
    this.name = name;
    this.ingredients = ingredients;
  }
}
