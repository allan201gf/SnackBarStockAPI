package br.com.allangf.SnackBarStockAPI.rest.config.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;

    private Double value;

    private List<QuantityIngredientDTO> quantityIngredients;

}
