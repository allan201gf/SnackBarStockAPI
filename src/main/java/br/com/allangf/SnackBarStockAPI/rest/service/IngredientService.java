package br.com.allangf.SnackBarStockAPI.rest.service;

import br.com.allangf.SnackBarStockAPI.domain.entity.Ingredient;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.IngredientDTO;

import java.util.List;

public interface IngredientService {

    void registerNewIngredient(IngredientDTO ingredientDTO);

    List<Ingredient> returnAllIngredients();

}
