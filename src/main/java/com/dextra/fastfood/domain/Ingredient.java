package com.dextra.fastfood.domain;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ingredient")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
public class Ingredient
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateUpdated;

    @NotNull
    @Size(min = 0, max = 50)
    @Column(length = 50)
    private String name;

    @NotNull
    @Column
    private BigDecimal price;

    @OneToMany(mappedBy = "ingredient")
    private Set<SandwichIngredient> sandwichIngredients = new HashSet<SandwichIngredient>();


    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }

        if (!Ingredient.class.isAssignableFrom(obj.getClass()))
        {
            return false;
        }

        final Ingredient other = (Ingredient) obj;

        if ((this.name == null) ? (other.getName() != null) : !this.name.equals(other.getName()))
        {
            return false;
        }

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        return true;
    }
}
