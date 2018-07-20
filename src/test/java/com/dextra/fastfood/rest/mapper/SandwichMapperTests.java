package com.dextra.fastfood.rest.mapper;

import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.domain.SandwichIngredient;
import com.dextra.fastfood.repository.IngredientRepository;
import com.dextra.fastfood.utils.TestUtils;
import com.dextra.fastfood.web.rest.dto.SandwichDto;
import com.dextra.fastfood.web.rest.mapper.SandwichMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SandwichMapperTests.class)
public class SandwichMapperTests
{
    @Mock
    private IngredientRepository ingredientRepository;

    private SandwichMapper mapper;


    @Before
    public void initMocks()
    {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void fromDtoTest()
    {
        mapper = new SandwichMapper(ingredientRepository);

        HashMap<Long, Long> dtoMap = new HashMap<>();
        dtoMap.put(1L, 2L);

        SandwichDto dto = SandwichDto.builder()
            .id(1L)
            .name("Sandwich")
            .ingredients(dtoMap)
            .build();

        when(ingredientRepository.getOne(1L)).thenReturn(TestUtils.getLettuce());

        Sandwich sandwich = mapper.fromDto(dto);


        assertEquals(1L, sandwich.getId().longValue());
        assertEquals("Sandwich", sandwich.getName());

        sandwich.getSandwichIngredients().forEach(sI -> assertEquals(TestUtils.getLettuce(), sI.getIngredient()));
    }

    @Test
    public void fromDtoNullIngredientsTest()
    {
        mapper = new SandwichMapper(ingredientRepository);


        SandwichDto dto = SandwichDto.builder()
            .id(1L)
            .name("Sandwich")
            .ingredients(null)
            .build();


        Sandwich sandwich = mapper.fromDto(dto);


        assertEquals(1L, sandwich.getId().longValue());
        assertEquals("Sandwich", sandwich.getName());
        assertEquals(0, sandwich.getSandwichIngredients().size());
    }


    @Test
    public void toDtoTest()
    {
        mapper = new SandwichMapper(ingredientRepository);

        Sandwich sandwich = new Sandwich();
        sandwich.setId(1L);
        sandwich.setName("Sandwich");
        sandwich.setSandwichIngredients(new HashSet<>());
        SandwichIngredient sandwichIngredient = new SandwichIngredient();
        sandwichIngredient.setSandwich(sandwich);
        sandwichIngredient.setIngredient(TestUtils.getBacon());
        sandwichIngredient.setQuantity(3L);

        sandwich.getSandwichIngredients().add(sandwichIngredient);

        SandwichDto dto = mapper.toDto(sandwich);

        assertEquals(1L, dto.getId().longValue());
        assertEquals("Sandwich", dto.getName());

        dto.getIngredients().forEach((k, v) -> {
            assertEquals(TestUtils.getBacon().getId(), k);
            assertEquals(3L, v.longValue());
        });

    }


    @Test
    public void toDtoListTest()
    {
        mapper = new SandwichMapper(ingredientRepository);

        Sandwich sandwich = new Sandwich();
        sandwich.setId(1L);
        sandwich.setName("Sandwich");
        sandwich.setSandwichIngredients(new HashSet<>());
        SandwichIngredient sandwichIngredient = new SandwichIngredient();
        sandwichIngredient.setSandwich(sandwich);
        sandwichIngredient.setIngredient(TestUtils.getBacon());
        sandwichIngredient.setQuantity(3L);
        sandwich.getSandwichIngredients().add(sandwichIngredient);


        Sandwich sandwich2 = new Sandwich();
        sandwich2.setId(1L);
        sandwich2.setName("Sandwich");
        sandwich2.setSandwichIngredients(new HashSet<>());
        SandwichIngredient sandwichIngredient2 = new SandwichIngredient();
        sandwichIngredient2.setSandwich(sandwich2);
        sandwichIngredient2.setIngredient(TestUtils.getBacon());
        sandwichIngredient2.setQuantity(3L);
        sandwich2.getSandwichIngredients().add(sandwichIngredient2);

        List<Sandwich> sandwiches = new ArrayList<>();
        sandwiches.add(sandwich);
        sandwiches.add(sandwich2);


        List<SandwichDto> dtos = mapper.toDtoList(sandwiches);

        dtos.forEach(dto -> {
            assertEquals(1L, dto.getId().longValue());
            assertEquals("Sandwich", dto.getName());

            dto.getIngredients().forEach((k, v) -> {
                assertEquals(TestUtils.getBacon().getId(), k);
                assertEquals(3L, v.longValue());
            });
        });
    }
}
