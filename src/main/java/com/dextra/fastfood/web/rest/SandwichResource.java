package com.dextra.fastfood.web.rest;

import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.service.SandwichService;
import com.dextra.fastfood.web.rest.dto.SandwichDto;
import com.dextra.fastfood.web.rest.mapper.SandwichMapper;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Sandwich resource.
 */
@RestController
@RequestMapping("/api/sandwich")
@Service
public class SandwichResource {

  private SandwichService sandwichService;
  private SandwichMapper mapper;


  /**
   * Instantiates a new Sandwich resource.
   *
   * @param sandwichService the sandwich service
   * @param sandwichMapper the sandwich mapper
   */
  public SandwichResource(final SandwichService sandwichService, SandwichMapper sandwichMapper) {
    this.sandwichService = sandwichService;
    this.mapper = sandwichMapper;
  }


  /**
   * Gets all sandwiches.
   *
   * @return the all sandwiches
   */
  @GetMapping("")
  public ResponseEntity<List<SandwichDto>> getAllSandwiches() {
    List<Sandwich> sandwich = sandwichService.getAll();

    return Optional.ofNullable(sandwich)
        .map(result -> new ResponseEntity<List<SandwichDto>>(
            mapper.toDtoList(result),
            HttpStatus.OK))
        .orElse(new ResponseEntity<List<SandwichDto>>(HttpStatus.NOT_FOUND));
  }


  /**
   * Gets sandwich by its id.
   *
   * @param sandwichId the sandwich id
   * @return the sandwich
   */
  @GetMapping("/{sandwichId}")
  public ResponseEntity<SandwichDto> getSandwich(@Valid @PathVariable long sandwichId) {
    Sandwich sandwich = sandwichService.getById(sandwichId);

    return Optional.ofNullable(sandwich)
        .map(result -> new ResponseEntity<SandwichDto>(
            mapper.toDto(result),
            HttpStatus.OK))
        .orElse(new ResponseEntity<SandwichDto>(HttpStatus.NOT_FOUND));
  }
}
