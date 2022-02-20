package br.com.allangf.SnackBarStockAPI.rest.config.dto;

import br.com.allangf.SnackBarStockAPI.rest.Errors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuantityIngredientDTO {

    @NotNull(message = Errors.QUANTITY_IS_REQUIRED)
    private Double quantity;

    @NotNull(message = Errors.INGREDIENT_IS_REQUIRED)
    private String ingredient;

}
