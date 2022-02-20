package br.com.allangf.SnackBarStockAPI.rest.service.impl;

import br.com.allangf.SnackBarStockAPI.domain.entity.Ingredient;
import br.com.allangf.SnackBarStockAPI.domain.enums.Unit;
import br.com.allangf.SnackBarStockAPI.domain.exception.RuleOfException;
import br.com.allangf.SnackBarStockAPI.domain.repository.IngredientRepository;
import br.com.allangf.SnackBarStockAPI.rest.Errors;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.IngredientDTO;
import br.com.allangf.SnackBarStockAPI.rest.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public void registerNewIngredient(IngredientDTO ingredientDTO) {

        List<Ingredient> existIngredient = ingredientRepository.findByName(ingredientDTO.getName());

        if (!existIngredient.isEmpty()) {
            throw new RuleOfException(Errors.INGREDIENT_ALREADY_REGISTERED);
        }

        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDTO.getName());
        ingredient.setValue(ingredientDTO.getValue());
        ingredient.setQuantity(ingredientDTO.getQuantity());

        if (Objects.equals(ingredientDTO.getUnit(), "UNI")) {
            ingredient.setUnit(Unit.UNI);
        } else if (Objects.equals(ingredientDTO.getUnit(), "KG")) {
            ingredient.setUnit(Unit.KG);
        } else {
            throw new RuleOfException(Errors.UNIT_NOT_FOUND);
        }

        ingredientRepository.save(ingredient);

    }

    @Override
    public List<Ingredient> returnAllIngredients() {
        return ingredientRepository.findAll();
    }
}
