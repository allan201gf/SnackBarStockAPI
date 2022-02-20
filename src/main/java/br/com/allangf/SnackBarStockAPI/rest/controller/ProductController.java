package br.com.allangf.SnackBarStockAPI.rest.controller;


import br.com.allangf.SnackBarStockAPI.domain.entity.Product;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.ProductDTO;
import br.com.allangf.SnackBarStockAPI.rest.service.impl.ProductServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private ProductServiceImpl productService;

    @ApiOperation("Create new product")
    @PostMapping("/v1")
    public void registerNewProduct(@Valid @RequestBody ProductDTO productDTO) {
        productService.registerNewProduct(productDTO);
    }

    @ApiOperation("All products")
    @GetMapping("/v1")
    public List<Product> allProducts() {
        return productService.returnAllProduct();
    }

}
