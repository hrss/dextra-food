package com.dextra.fastfood.service;

import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.repository.SandwichRepository;
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
@SpringBootTest(classes = SandwichServiceTests.class)
public class SandwichServiceTests
{
    @Mock
    private SandwichRepository sandwichRepository;

    private SandwichService sandwichService;

    @Test
    public void getSandwichById(){
        sandwichService = new SandwichService(sandwichRepository);

        when(sandwichRepository.getOne(1L)).thenReturn(TestUtils.createSandwich());

        Sandwich sandwich = sandwichService.getById(1L);

        assertEquals(TestUtils.createSandwich(), sandwich);
    }

    @Test
    public void getAllSandwiches(){
        sandwichService = new SandwichService(sandwichRepository);

        List<Sandwich> sandwichList = new ArrayList<>();
        sandwichList.add(TestUtils.createCheeseSandwich());
        sandwichList.add(TestUtils.createLightSandwich());
        sandwichList.add(TestUtils.createMeatSandwich());

        when(sandwichRepository.findAll()).thenReturn(sandwichList);

        List<Sandwich> sandwichs = sandwichService.getAll();

        assertEquals(TestUtils.createCheeseSandwich(), sandwichs.get(0));
        assertEquals(TestUtils.createLightSandwich(), sandwichs.get(1));
        assertEquals(TestUtils.createMeatSandwich(), sandwichs.get(2));

    }
}
