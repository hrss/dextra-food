package com.dextra.fastfood.rest;

import com.dextra.fastfood.domain.Ingredient;
import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.repository.IngredientRepository;
import com.dextra.fastfood.service.IngredientService;
import com.dextra.fastfood.service.PriceService;
import com.dextra.fastfood.utils.TestUtils;
import com.dextra.fastfood.web.rest.IngredientResource;
import com.dextra.fastfood.web.rest.PriceResource;
import com.dextra.fastfood.web.rest.dto.SandwichDto;
import com.dextra.fastfood.web.rest.mapper.IngredientMapper;
import com.dextra.fastfood.web.rest.mapper.SandwichMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
public class PriceResourceTests {

  private MockMvc mockMvc;

  private PriceResource priceResource;

  @Mock
  private PriceService priceService;

  @Mock
  private IngredientRepository ingredientRepository;

  @Mock
  private SandwichMapper mapper;


  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);

    priceResource = new PriceResource(priceService, mapper);

    mockMvc = MockMvcBuilders
        .standaloneSetup(priceResource)
        .build();
  }


  @Test
  public void getPriceTest() throws Exception {
    when(priceService.getSandwichPrice(any(Sandwich.class))).thenReturn(new BigDecimal(12.0));
    when(mapper.fromDto(any(SandwichDto.class))).thenReturn(new Sandwich());

    mockMvc.perform(
        post("/api/price")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(new SandwichDto())))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", is(12)));

  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
