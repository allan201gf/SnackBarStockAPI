package br.com.allangf.SnackBarStockAPI.rest.service;

import br.com.allangf.SnackBarStockAPI.domain.entity.Product;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void registerNewProduct(ProductDTO productDTO);

    List<Product> returnAllProduct();

}
