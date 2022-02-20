package br.com.allangf.SnackBarStockAPI.domain.repository;

import br.com.allangf.SnackBarStockAPI.domain.entity.QuantityIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityIngredientRepository extends JpaRepository<QuantityIngredient, Integer> {

}