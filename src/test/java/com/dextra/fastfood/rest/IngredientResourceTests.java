package com.dextra.fastfood.rest;

import com.dextra.fastfood.domain.Ingredient;
import com.dextra.fastfood.service.IngredientService;
import com.dextra.fastfood.utils.TestUtils;
import com.dextra.fastfood.web.rest.IngredientResource;
import com.dextra.fastfood.web.rest.mapper.IngredientMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;

@WebAppConfiguration
public class IngredientResourceTests {

  private MockMvc mockMvc;

  private IngredientResource ingredientResource;

  @Mock
  private IngredientService ingredientService;

  private IngredientMapper ingredientMapper = new IngredientMapper();


  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);

    ingredientResource = new IngredientResource(ingredientService, ingredientMapper);

    mockMvc = MockMvcBuilders
        .standaloneSetup(ingredientResource)
        .build();
  }


  @Test
  public void getAllIngredients() throws Exception {
    List<Ingredient> ingredientList = new ArrayList<>();
    ingredientList.add(TestUtils.getCheese());
    ingredientList.add(TestUtils.getMeat());
    ingredientList.add(TestUtils.getBacon());

    when(ingredientService.getAll()).thenReturn(ingredientList);

    mockMvc.perform(get("/api/ingredient"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andDo(print())
        .andExpect(jsonPath("$", hasSize(3)))
        .andExpect(jsonPath("$[0].id", is(5)))
        .andExpect(jsonPath("$[0].name", is("CHEESE")))
        .andExpect(jsonPath("$[0].price", is(4)))
        .andExpect(jsonPath("$[1].id", is(3)))
        .andExpect(jsonPath("$[1].name", is("MEAT")))
        .andExpect(jsonPath("$[1].price", is(3)))
        .andExpect(jsonPath("$[2].id", is(2)))
        .andExpect(jsonPath("$[2].name", is("BACON")))
        .andExpect(jsonPath("$[2].price", is(2)));

    verify(ingredientService, times(1)).getAll();
  }

  @Test
  public void getOneIngredient() throws Exception {

    when(ingredientService.getById(2L)).thenReturn(TestUtils.getBacon());

    mockMvc.perform(get("/api/ingredient/2"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andDo(print())
        .andExpect(jsonPath("$.id", is(2)))
        .andExpect(jsonPath("$.name", is("BACON")))
        .andExpect(jsonPath("$.price", is(2)));

    verify(ingredientService, times(1)).getById(anyLong());
  }

  @Test
  public void getOneIngredientNotFound() throws Exception {

    mockMvc.perform(get("/api/ingredient/2"))
        .andExpect(status().isNotFound())
        .andDo(print());

    verify(ingredientService, times(1)).getById(anyLong());
  }
}
