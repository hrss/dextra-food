package com.dextra.fastfood.rest;

import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.repository.IngredientRepository;
import com.dextra.fastfood.service.SandwichService;
import com.dextra.fastfood.utils.TestUtils;
import com.dextra.fastfood.web.rest.SandwichResource;
import com.dextra.fastfood.web.rest.mapper.SandwichMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.collections.map.HashedMap;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SandwichResourceTests
{

    private MockMvc mockMvc;

    private SandwichResource sandwichResource;

    @Mock
    private SandwichService sandwichService;

    @Mock
    private IngredientRepository ingredientRepository;

    private SandwichMapper sandwichMapper;


    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);

        sandwichMapper = new SandwichMapper(ingredientRepository);
        sandwichResource = new SandwichResource(sandwichService, sandwichMapper);

        mockMvc = MockMvcBuilders
            .standaloneSetup(sandwichResource)
            .build();
    }


    @Test
    public void getAllSandwiches() throws Exception
    {
        List<Sandwich> sandwichList = new ArrayList<>();
        sandwichList.add(TestUtils.createMeatSandwich());
        sandwichList.add(TestUtils.createLightSandwich());
        sandwichList.add(TestUtils.createCheeseSandwich());

        when(sandwichService.getAll()).thenReturn(sandwichList);

        mockMvc.perform(get("/api/sandwich"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andDo(print())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[0].id", is(2)))
            .andExpect(jsonPath("$[0].name", is("Meat-Burguer")))
            .andExpect(jsonPath("$[0].ingredients.1", is(1)))
            .andExpect(jsonPath("$[0].ingredients.2", is(1)))
            .andExpect(jsonPath("$[0].ingredients.3", is(3)))
            .andExpect(jsonPath("$[0].ingredients.5", is(1)))
            .andExpect(jsonPath("$[1].id", is(4)))
            .andExpect(jsonPath("$[1].name", is("Light-Burguer")))
            .andExpect(jsonPath("$[1].ingredients.1", is(1)))
            .andExpect(jsonPath("$[1].ingredients.3", is(1)))
            .andExpect(jsonPath("$[1].ingredients.5", is(1)))
            .andExpect(jsonPath("$[2].id", is(3)))
            .andExpect(jsonPath("$[2].name", is("Cheese-Burguer")))
            .andExpect(jsonPath("$[2].ingredients.2", is(1)))
            .andExpect(jsonPath("$[2].ingredients.3", is(1)))
            .andExpect(jsonPath("$[2].ingredients.5", is(3)));

        verify(sandwichService, times(1)).getAll();
    }


    @Test
    public void getOneSandwich() throws Exception
    {

        when(sandwichService.getById(1L)).thenReturn(TestUtils.createSandwich());

        mockMvc.perform(get("/api/sandwich/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andDo(print())
            .andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.name", is("Default-Burguer")))
            .andExpect(jsonPath("$.ingredients.2", is(1)))
            .andExpect(jsonPath("$.ingredients.3", is(1)))
            .andExpect(jsonPath("$.ingredients.5", is(1)));

        verify(sandwichService, times(1)).getById(anyLong());
    }

    @Test
    public void getOneSandwichNotFound() throws Exception
    {

        mockMvc.perform(get("/api/sandwich/1"))
            .andExpect(status().isNotFound())
            .andDo(print());

        verify(sandwichService, times(1)).getById(anyLong());
    }
}
