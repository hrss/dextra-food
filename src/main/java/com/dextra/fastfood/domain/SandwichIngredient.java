package com.dextra.fastfood.domain;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The type Sandwich ingredient.
 * It serves as a middle man in the many to many relationship
 * that exists between sandwiches and ingredients.
 * It also holds the quantity of a certain ingredient in a sandwich.
 */
@Entity
@Table(name = "sandwich_ingredient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SandwichIngredient
{
    @EmbeddedId
    private SandwichIngredientPK id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateUpdated;

    @ManyToOne
    @MapsId("sandwich_id")
    @JoinColumn(name = "SANDWICH_ID")
    private Sandwich sandwich;

    @ManyToOne
    @MapsId("ingredient_id")
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    @Column
    private Long quantity;
}
