package com.dextra.fastfood.repository;

import com.dextra.fastfood.domain.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository extends JpaRepository<Sandwich,Long>
{
}
