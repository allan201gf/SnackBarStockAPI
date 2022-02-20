package br.com.allangf.SnackBarStockAPI.domain.repository;

import br.com.allangf.SnackBarStockAPI.domain.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    List<Ingredient> findByName(String name);


}
