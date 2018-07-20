package com.dextra.fastfood.service;

import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.repository.SandwichRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichService
{
    private SandwichRepository sandwichRepository;

    @Autowired
    public SandwichService(final SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    public Sandwich getById(Long sandwichId) {
        return this.sandwichRepository.getOne(sandwichId);
    }

    public List<Sandwich> getAll(){
        return this.sandwichRepository.findAll();
    }
}
