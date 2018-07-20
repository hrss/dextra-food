package com.dextra.fastfood.domain;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "sandwich")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
public class Sandwich
{
    private static final long serialVersionUID = 3L;

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

    @OneToMany(mappedBy = "sandwich")
    private Set<SandwichIngredient> sandwichIngredients = new HashSet<SandwichIngredient>();


    public Map<Ingredient, Long> getIngredientMap()
    {
        Map<Ingredient, Long> ingredients = new HashMap<>();
        sandwichIngredients.forEach(sI -> {
            ingredients.put(sI.getIngredient(), sI.getQuantity());
        });
        return ingredients;
    }


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

        if (!Sandwich.class.isAssignableFrom(obj.getClass()))
        {
            return false;
        }

        final Sandwich other = (Sandwich) obj;

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
