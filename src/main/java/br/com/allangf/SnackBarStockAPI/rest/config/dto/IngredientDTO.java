package br.com.allangf.SnackBarStockAPI.rest.config.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

    private String name;

    private String unit;

    private Integer quantity;

    private Double value;

}
