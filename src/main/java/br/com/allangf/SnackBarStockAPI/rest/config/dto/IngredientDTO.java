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
public class IngredientDTO {

    @NotNull(message = Errors.NAME_IS_REQUIRED)
    private String name;

    @NotNull(message = Errors.UNIT_IS_REQUIRED)
    private String unit;

    @NotNull(message = Errors.QUANTITY_IS_REQUIRED)
    private Integer quantity;

    @NotNull(message = Errors.VALUE_IS_REQUIRED)
    private Double value;

}
