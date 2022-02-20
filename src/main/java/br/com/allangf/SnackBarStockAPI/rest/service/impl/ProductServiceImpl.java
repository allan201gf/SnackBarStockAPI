package br.com.allangf.SnackBarStockAPI.rest.service.impl;

import br.com.allangf.SnackBarStockAPI.domain.entity.Ingredient;
import br.com.allangf.SnackBarStockAPI.domain.entity.Product;
import br.com.allangf.SnackBarStockAPI.domain.entity.QuantityIngredient;
import br.com.allangf.SnackBarStockAPI.domain.exception.RuleOfException;
import br.com.allangf.SnackBarStockAPI.domain.repository.IngredientRepository;
import br.com.allangf.SnackBarStockAPI.domain.repository.ProductRepository;
import br.com.allangf.SnackBarStockAPI.domain.repository.QuantityIngredientRepository;
import br.com.allangf.SnackBarStockAPI.rest.Errors;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.ProductDTO;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.ProductProductionCostDTO;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.QuantityIngredientDTO;
import br.com.allangf.SnackBarStockAPI.rest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final IngredientRepository ingredientRepository;
    private final QuantityIngredientRepository quantityIngredientRepository;


    @Override
    public void registerNewProduct(ProductDTO productDTO) {

        List<Product> existProduct = productRepository.findByName(productDTO.getName());
        if (!existProduct.isEmpty()) {
            throw new RuleOfException(Errors.PRODUCT_ALREADY_REGISTERED);
        }

        List<QuantityIngredient> quantityIngredientList = new ArrayList<>();
        for (QuantityIngredientDTO quantityIngredientDTO : productDTO.getQuantityIngredients()) {

            List<Ingredient> ingredient = ingredientRepository.findByName(quantityIngredientDTO.getIngredient());

            if (ingredient.isEmpty()) {
                throw new RuleOfException(Errors.INGREDIENT_NOT_FOUND);
            }

            QuantityIngredient quantityIngredient = new QuantityIngredient();
            quantityIngredient.setIngredient(ingredient.get(0));
            quantityIngredient.setQuantity(quantityIngredientDTO.getQuantity());
            quantityIngredientRepository.save(quantityIngredient);
            quantityIngredientList.add(quantityIngredient);
        }

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setValue(productDTO.getValue());
        product.setQuantityIngredients(quantityIngredientList);
        productRepository.save(product);
    }

    @Override
    public List<ProductProductionCostDTO> returnAllProductCost() {

        List<ProductProductionCostDTO> productProductionCostDTOList = new ArrayList<>();
        List<Product> allProducts = productRepository.findAll();
        for (Product product : allProducts) {

            ProductProductionCostDTO productProductionCostDTO = new ProductProductionCostDTO();
            double valueIngredients = 0;
            for (QuantityIngredient quantityIngredient : product.getQuantityIngredients()) {

                valueIngredients = valueIngredients + quantityIngredient.getQuantity() * quantityIngredient.getIngredient().getValue();
            }

            productProductionCostDTO.setName(product.getName());
            productProductionCostDTO.setValue(product.getValue());
            productProductionCostDTO.setProductionCost(valueIngredients);
            productProductionCostDTOList.add(productProductionCostDTO);
        }
        return productProductionCostDTOList;
    }

    @Override
    public List<Product> returnAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void verifyStockProduct(String productForVerify) {

        List<Product> product = productRepository.findByName(productForVerify);
        if (product.isEmpty()) {
            throw new RuleOfException(Errors.PRODUCT_NOT_FOUND);
        }

        for (QuantityIngredient quantityIngredient : product.get(0).getQuantityIngredients()) {

            if (quantityIngredient.getQuantity() > quantityIngredient.getIngredient().getQuantity()) {
                throw new RuleOfException(Errors.PRODUCT_NOT_STOCK);
            }
        }
    }
}
