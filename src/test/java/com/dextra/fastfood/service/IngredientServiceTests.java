package com.dextra.fastfood.service;

import com.dextra.fastfood.domain.Ingredient;
import com.dextra.fastfood.repository.IngredientRepository;
import com.dextra.fastfood.utils.TestUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IngredientServiceTests.class)
public class IngredientServiceTests {

  @Mock
  private IngredientRepository ingredientRepository;

  private IngredientService ingredientService;

  @Test
  public void getIngredientById() {
    ingredientService = new IngredientService(ingredientRepository);

    when(ingredientRepository.getOne(1L)).thenReturn(TestUtils.getLettuce());

    Ingredient ingredient = ingredientService.getById(1L);

    assertEquals(TestUtils.getLettuce(), ingredient);
  }

  @Test
  public void getAllIngredients() {
    ingredientService = new IngredientService(ingredientRepository);

    List<Ingredient> ingredientList = new ArrayList<>();
    ingredientList.add(TestUtils.getCheese());
    ingredientList.add(TestUtils.getMeat());
    ingredientList.add(TestUtils.getBacon());

    when(ingredientRepository.findAll()).thenReturn(ingredientList);

    List<Ingredient> ingredients = ingredientService.getAll();

    assertEquals(TestUtils.getCheese(), ingredients.get(0));
    assertEquals(TestUtils.getMeat(), ingredients.get(1));
    assertEquals(TestUtils.getBacon(), ingredients.get(2));

  }
}
