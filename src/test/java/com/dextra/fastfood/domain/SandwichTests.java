package com.dextra.fastfood.domain;

import java.math.BigDecimal;
import java.util.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SandwichTests.class)
public class SandwichTests {

  @Test
  public void notEqualNull() {
    Sandwich sandwich = new Sandwich();
    assertFalse(sandwich.equals(null));
  }

  @Test
  public void notEqualDifferentClass() {
    Sandwich sandwich = new Sandwich();
    assertFalse(sandwich.equals(new BigDecimal(0)));
  }

  @Test
  public void notEqualDifferentName() {
    Sandwich sandwich1 = new Sandwich();
    Sandwich sandwich2 = new Sandwich();
    sandwich1.setName("Hello");
    sandwich2.setName("Not Hello");

    assertFalse(sandwich1.equals(sandwich2));
  }

  @Test
  public void notEqualDifferentId() {
    Sandwich sandwich1 = new Sandwich();
    Sandwich sandwich2 = new Sandwich();
    sandwich1.setName("Hello");
    sandwich2.setName("Hello");

    sandwich1.setId(1L);
    sandwich2.setId(2L);

    assertFalse(sandwich1.equals(sandwich2));
  }

  @Test
  public void equalSandwiches() {
    Sandwich sandwich1 = new Sandwich();
    Sandwich sandwich2 = new Sandwich();
    sandwich1.setName("Hello");
    sandwich2.setName("Hello");

    sandwich1.setId(1L);
    sandwich2.setId(1L);

    assertTrue(sandwich1.equals(sandwich2));
  }

  @Test
  public void hashCodeTest() {
    Sandwich sandwich = new Sandwich();
    sandwich.setId(1L);
    assertEquals(Objects.hashCode(1L), sandwich.hashCode());
  }

}
