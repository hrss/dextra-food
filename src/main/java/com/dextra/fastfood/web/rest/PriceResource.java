package com.dextra.fastfood.web.rest;

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

@RestController
@RequestMapping("/api")
@Service
public class PriceResource
{
    private final Logger log = LoggerFactory.getLogger(PriceResource.class);

    private final PriceService priceService;

    private final SandwichMapper sandwichMapper;

    @Autowired
    public PriceResource(final PriceService priceService, final SandwichMapper sandwichMapper) {
        this.priceService = priceService;
        this.sandwichMapper = sandwichMapper;
    }

    /**
     * POST  /images : Create a new image.
     *
     * @param image the image to create
     * @return the ResponseEntity with status 201 (Created) and with body the new image, or with status 400 (Bad Request) if the image has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/price",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> getPrice(@RequestBody SandwichDto sandwich) throws URISyntaxException {
        log.debug("REST request get a sandwich price : {}", sandwich);

        BigDecimal price = priceService.getSandwichPrice(sandwichMapper.fromDto(sandwich));
        return ResponseEntity.ok().body(price);
    }

}
