package br.com.allangf.SnackBarStockAPI.rest.config.dto;

import br.com.allangf.SnackBarStockAPI.rest.Errors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotNull(message = Errors.NAME_IS_REQUIRED)
    private String name;

    @NotNull(message = Errors.VALUE_IS_REQUIRED)
    private Double value;

    @NotNull(message = Errors.QUANTITY_INGREDIENT_IS_REQUIRED)
    private List<QuantityIngredientDTO> quantityIngredients;

}
