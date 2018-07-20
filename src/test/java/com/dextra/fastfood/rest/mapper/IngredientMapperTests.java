package com.dextra.fastfood.rest.mapper;

import com.dextra.fastfood.domain.Ingredient;
import com.dextra.fastfood.utils.TestUtils;
import com.dextra.fastfood.web.rest.dto.IngredientDto;
import com.dextra.fastfood.web.rest.mapper.IngredientMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IngredientMapperTests.class)
public class IngredientMapperTests
{
    private IngredientMapper mapper = new IngredientMapper();


    @Test
    public void fromDtoTest()
    {
        IngredientDto dto = IngredientDto.builder()
            .id(1L)
            .name("Ingredient")
            .price(new BigDecimal(1))
            .build();

        Ingredient ingredient = mapper.fromDto(dto);

        assertEquals(1L, ingredient.getId().longValue());
        assertEquals("Ingredient", ingredient.getName());
        assertEquals(new BigDecimal(1), ingredient.getPrice());
    }


    @Test
    public void toDtoTest()
    {
        Ingredient ingredient =  new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Ingredient");
        ingredient.setPrice(new BigDecimal(1));

        IngredientDto dto = mapper.toDto(ingredient);

        assertEquals(1L, dto.getId().longValue());
        assertEquals("Ingredient", dto.getName());
        assertEquals(new BigDecimal(1), dto.getPrice());
    }


    @Test
    public void toDtoListTest()
    {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(TestUtils.getBacon());
        ingredients.add(TestUtils.getCheese());
        ingredients.add(TestUtils.getLettuce());

        List<IngredientDto> dtos = mapper.toDtoList(ingredients);

        assertEquals(TestUtils.Ingredients.BACON.getId(), dtos.get(0).getId());
        assertEquals(TestUtils.Ingredients.BACON.name(), dtos.get(0).getName());
        assertEquals(new BigDecimal(2), dtos.get(0).getPrice());

        assertEquals(TestUtils.Ingredients.CHEESE.getId(), dtos.get(1).getId());
        assertEquals(TestUtils.Ingredients.CHEESE.name(), dtos.get(1).getName());
        assertEquals(new BigDecimal(4), dtos.get(1).getPrice());

        assertEquals(TestUtils.Ingredients.LETTUCE.getId(), dtos.get(2).getId());
        assertEquals(TestUtils.Ingredients.LETTUCE.name(), dtos.get(2).getName());
        assertEquals(new BigDecimal(5), dtos.get(2).getPrice());
    }
}
