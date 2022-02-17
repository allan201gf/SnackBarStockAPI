package br.com.allangf.SnackBarStockAPI.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuantityIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Double quantityIngredientId;

    @Column(name = "quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredients;

}
