package com.dextra.fastfood.service;

import com.dextra.fastfood.domain.Ingredient;
import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.exception.InvalidSandwichException;
import com.dextra.fastfood.repository.IngredientRepository;
import com.dextra.fastfood.repository.SandwichRepository;
import com.dextra.fastfood.utils.TestUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PriceServiceTests.class)
public class PriceServiceTests {

  @Mock
  private IngredientRepository ingredientRepository;

  @Mock
  private SandwichRepository sandwichRepository;

  private PriceService priceService;


  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
  }


  @Test
  public void getSandwichPriceWithSandwichIdNoOfferTest() throws InvalidSandwichException {
    priceService = new PriceService(sandwichRepository, ingredientRepository);
    Sandwich sandwich = new Sandwich();
    sandwich.setId(1L);
    Sandwich returnSandwich = TestUtils.createSandwich();
    when(sandwichRepository.findById(1L)).thenReturn(Optional.of(returnSandwich));
    BigDecimal price = priceService.getSandwichPrice(sandwich);
    price = price.setScale(2, RoundingMode.HALF_UP);
    assertEquals(new BigDecimal(9).setScale(2, RoundingMode.HALF_UP), price);
  }


  @Test
  public void getSandwichPriceWithSandwichIdMeatOfferTest() throws InvalidSandwichException {
    priceService = new PriceService(sandwichRepository, ingredientRepository);
    Sandwich sandwich = new Sandwich();
    sandwich.setId(1L);
    Sandwich returnSandwich = TestUtils.createMeatSandwich();

    when(sandwichRepository.findById(1L)).thenReturn(Optional.of(returnSandwich));

    when(ingredientRepository.getOne(TestUtils.Ingredients.BACON.getId()))
        .thenReturn(TestUtils.getBacon());
    when(ingredientRepository.getOne(TestUtils.Ingredients.LETTUCE.getId()))
        .thenReturn(TestUtils.getLettuce());
    when(ingredientRepository.getOne(TestUtils.Ingredients.MEAT.getId()))
        .thenReturn(TestUtils.getMeat());
    when(ingredientRepository.getOne(TestUtils.Ingredients.CHEESE.getId()))
        .thenReturn(TestUtils.getCheese());

    BigDecimal price = priceService.getSandwichPrice(sandwich);
    price = price.setScale(2, RoundingMode.HALF_UP);

    assertEquals(new BigDecimal(17).setScale(2, RoundingMode.HALF_UP), price);
  }


  @Test
  public void getSandwichPriceWithSandwichIdCheeseOfferTest() throws InvalidSandwichException {
    priceService = new PriceService(sandwichRepository, ingredientRepository);
    Sandwich sandwich = new Sandwich();
    sandwich.setId(1L);

    when(sandwichRepository.findById(1L)).thenReturn(Optional.of(TestUtils.createCheeseSandwich()));

    when(ingredientRepository.getOne(TestUtils.Ingredients.BACON.getId()))
        .thenReturn(TestUtils.getBacon());
    when(ingredientRepository.getOne(TestUtils.Ingredients.LETTUCE.getId()))
        .thenReturn(TestUtils.getLettuce());
    when(ingredientRepository.getOne(TestUtils.Ingredients.MEAT.getId()))
        .thenReturn(TestUtils.getMeat());
    when(ingredientRepository.getOne(TestUtils.Ingredients.CHEESE.getId()))
        .thenReturn(TestUtils.getCheese());

    BigDecimal price = priceService.getSandwichPrice(sandwich);
    price = price.setScale(2, RoundingMode.HALF_UP);
    assertEquals(new BigDecimal(13).setScale(2, RoundingMode.HALF_UP), price);
  }


  @Test
  public void getSandwichPriceWithSandwichIdLightOfferNullBaconTest() throws InvalidSandwichException {
    priceService = new PriceService(sandwichRepository, ingredientRepository);
    Sandwich sandwich = new Sandwich();
    sandwich.setId(1L);

    when(sandwichRepository.findById(1L)).thenReturn(Optional.of(TestUtils.createLightSandwich()));

    when(ingredientRepository.getOne(TestUtils.Ingredients.BACON.getId()))
        .thenReturn(TestUtils.getBacon());
    when(ingredientRepository.getOne(TestUtils.Ingredients.LETTUCE.getId()))
        .thenReturn(TestUtils.getLettuce());
    when(ingredientRepository.getOne(TestUtils.Ingredients.MEAT.getId()))
        .thenReturn(TestUtils.getMeat());
    when(ingredientRepository.getOne(TestUtils.Ingredients.CHEESE.getId()))
        .thenReturn(TestUtils.getCheese());

    BigDecimal price = priceService.getSandwichPrice(sandwich);
    price = price.setScale(2, RoundingMode.HALF_UP);
    assertEquals(new BigDecimal(10.80).setScale(2, RoundingMode.HALF_UP), price);
  }

  @Test
  public void getSandwichPriceWithSandwichIdLightOfferZeroBaconTest() throws InvalidSandwichException {
    priceService = new PriceService(sandwichRepository, ingredientRepository);
    Sandwich sandwich = new Sandwich();
    sandwich.setId(1L);

    when(sandwichRepository.findById(1L)).thenReturn(Optional.of(TestUtils.createLightSandwichZeroBacon()));

    when(ingredientRepository.getOne(TestUtils.Ingredients.BACON.getId()))
            .thenReturn(TestUtils.getBacon());
    when(ingredientRepository.getOne(TestUtils.Ingredients.LETTUCE.getId()))
            .thenReturn(TestUtils.getLettuce());
    when(ingredientRepository.getOne(TestUtils.Ingredients.MEAT.getId()))
            .thenReturn(TestUtils.getMeat());
    when(ingredientRepository.getOne(TestUtils.Ingredients.CHEESE.getId()))
            .thenReturn(TestUtils.getCheese());

    BigDecimal price = priceService.getSandwichPrice(sandwich);
    price = price.setScale(2, RoundingMode.HALF_UP);
    assertEquals(new BigDecimal(10.80).setScale(2, RoundingMode.HALF_UP), price);
  }


  @Test
  public void getSandwichPriceWithSandwichIdAllOffersTest() throws InvalidSandwichException {
    priceService = new PriceService(sandwichRepository, ingredientRepository);
    Sandwich sandwich = new Sandwich();
    sandwich.setId(1L);

    when(sandwichRepository.findById(1L))
        .thenReturn(Optional.of(TestUtils.createAllOffersSandwich()));

    when(ingredientRepository.getOne(TestUtils.Ingredients.BACON.getId()))
        .thenReturn(TestUtils.getBacon());
    when(ingredientRepository.getOne(TestUtils.Ingredients.LETTUCE.getId()))
        .thenReturn(TestUtils.getLettuce());
    when(ingredientRepository.getOne(TestUtils.Ingredients.MEAT.getId()))
        .thenReturn(TestUtils.getMeat());
    when(ingredientRepository.getOne(TestUtils.Ingredients.CHEESE.getId()))
        .thenReturn(TestUtils.getCheese());

    BigDecimal price = priceService.getSandwichPrice(sandwich);
    price = price.setScale(2, RoundingMode.HALF_UP);
    assertEquals(new BigDecimal(17.1).setScale(2, RoundingMode.HALF_UP), price);
  }


  @Test
  public void getSandwichPriceWithIngredientsSandwichNullIdTest() throws InvalidSandwichException {
    priceService = new PriceService(sandwichRepository, ingredientRepository);
    Sandwich sandwich = TestUtils.createSandwich();
    sandwich.setId(null);

    BigDecimal price = priceService.getSandwichPrice(sandwich);
    price = price.setScale(2, RoundingMode.HALF_UP);
    assertEquals(new BigDecimal(9).setScale(2, RoundingMode.HALF_UP), price);
  }


  @Test
  public void getSandwichPriceWithIngredientsSandwichNotFound() throws InvalidSandwichException {
    priceService = new PriceService(sandwichRepository, ingredientRepository);
    Sandwich sandwich = TestUtils.createSandwich();
    sandwich.setId(1L);

    when(sandwichRepository.findById(1L)).thenReturn(Optional.empty());
    BigDecimal price = priceService.getSandwichPrice(sandwich);
    price = price.setScale(2, RoundingMode.HALF_UP);
    assertEquals(new BigDecimal(9).setScale(2, RoundingMode.HALF_UP), price);
  }


  @Test(expected = InvalidSandwichException.class)
  public void getInvalidSandwichExceptionNullIdAndNullIngredients()
      throws InvalidSandwichException {
    priceService = new PriceService(sandwichRepository, ingredientRepository);
    Sandwich sandwich = new Sandwich();
    sandwich.setId(null);

    when(sandwichRepository.findById(1L)).thenReturn(Optional.empty());
    BigDecimal price = priceService.getSandwichPrice(sandwich);
    price.setScale(2, RoundingMode.HALF_UP);
  }

}
