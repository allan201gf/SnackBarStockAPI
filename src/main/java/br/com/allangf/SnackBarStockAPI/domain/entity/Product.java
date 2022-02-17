package br.com.allangf.SnackBarStockAPI.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Double value;

    @ManyToMany
    @JoinColumn(name = "quantity_ingredient_id")
    private List<QuantityIngredient> quantityIngredients;

}
