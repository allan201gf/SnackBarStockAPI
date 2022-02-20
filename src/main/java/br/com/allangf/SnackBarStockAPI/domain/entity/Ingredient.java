package br.com.allangf.SnackBarStockAPI.domain.entity;

import br.com.allangf.SnackBarStockAPI.domain.enums.Unit;
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
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ingredientId;

    @Column(name = "name")
    private String name;

    @Column(name = "unit")
    private Unit unit;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "value")
    private Double value;

}
