package com.dextra.fastfood.service;

import com.dextra.fastfood.domain.Sandwich;
import com.dextra.fastfood.repository.SandwichRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Sandwich service.
 */
@Service
public class SandwichService
{
    private SandwichRepository sandwichRepository;


    /**
     * Instantiates a new Sandwich service.
     *
     * @param sandwichRepository the sandwich repository
     */
    @Autowired
    public SandwichService(final SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }


    /**
     * Gets a sandwich by it id.
     *
     * @param sandwichId the sandwich id
     * @return the by id
     */
    public Sandwich getById(Long sandwichId) {
        return this.sandwichRepository.getOne(sandwichId);
    }


    /**
     * Gets the list of all the sandwiches from the db.
     *
     * @return the list
     */
    public List<Sandwich> getAll(){
        return this.sandwichRepository.findAll();
    }
}
