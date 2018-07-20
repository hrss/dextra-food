package com.dextra.fastfood.web.rest;

import com.dextra.fastfood.exception.InvalidSandwichException;
import com.dextra.fastfood.service.PriceService;
import com.dextra.fastfood.web.rest.dto.SandwichDto;
import com.dextra.fastfood.web.rest.mapper.SandwichMapper;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Price resource (controller).
 */
@RestController
@RequestMapping("/api")
@Service
public class PriceResource {

  private final Logger log = LoggerFactory.getLogger(PriceResource.class);

  private final PriceService priceService;

  private final SandwichMapper sandwichMapper;


  /**
   * Instantiates a new Price resource.
   *
   * @param priceService the price service
   * @param sandwichMapper the sandwich mapper
   */
  @Autowired
  public PriceResource(final PriceService priceService, final SandwichMapper sandwichMapper) {
    this.priceService = priceService;
    this.sandwichMapper = sandwichMapper;
  }


  /**
   * Gets the price of a sandwich.
   *
   * @param sandwich the sandwich
   * @return the sandwich price
   * @throws InvalidSandwichException if the sandwich has no ingredients or id
   */
  @RequestMapping(value = "/price",
      method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BigDecimal> getPrice(@RequestBody SandwichDto sandwich)
      throws InvalidSandwichException {
    log.debug("REST request get a sandwich price : {}", sandwich);

    BigDecimal price = priceService.getSandwichPrice(sandwichMapper.fromDto(sandwich));
    return ResponseEntity.ok().body(price);
  }

}
