package com.dextra.fastfood.repository;

import com.dextra.fastfood.domain.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Sandwich repository. We can use it to access the database and retrieve sandwiches.
 */
public interface SandwichRepository extends JpaRepository<Sandwich, Long> {

}
