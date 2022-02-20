package br.com.allangf.SnackBarStockAPI.rest.controller;


import br.com.allangf.SnackBarStockAPI.domain.entity.Ingredient;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.IngredientDTO;
import br.com.allangf.SnackBarStockAPI.rest.service.IngredientService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
@AllArgsConstructor
public class IngredientController {

    private IngredientService ingredientService;

    @ApiOperation("Create new ingredient")
    @PostMapping("/v1")
    public void registerNewIngredient(@Valid @RequestBody IngredientDTO ingredientDTO) {
        ingredientService.registerNewIngredient(ingredientDTO);
    }

    @ApiOperation("All ingredients")
    @GetMapping("/v1")
    public List<Ingredient> allIngredients() {
        return ingredientService.returnAllIngredients();
    }

}
