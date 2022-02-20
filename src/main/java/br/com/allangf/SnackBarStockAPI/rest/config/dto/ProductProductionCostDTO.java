package br.com.allangf.SnackBarStockAPI.rest.config.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductProductionCostDTO {

    private String name;

    private Double value;

    private Double productionCost;

}
