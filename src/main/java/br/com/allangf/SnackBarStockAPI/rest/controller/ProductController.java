package br.com.allangf.SnackBarStockAPI.rest.controller;


import br.com.allangf.SnackBarStockAPI.domain.entity.Product;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.ProductDTO;
import br.com.allangf.SnackBarStockAPI.rest.config.dto.ProductProductionCostDTO;
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

    @ApiOperation("All products cost")
    @GetMapping("/v1/all-costs")
    public List<ProductProductionCostDTO> allProductsCost() {
        return productService.returnAllProductCost();
    }

    @ApiOperation("All products")
    @GetMapping("/v1/all-products")
    public List<Product> allProducts() {
        return productService.returnAllProduct();
    }

    @ApiOperation("Verify stock product")
    @GetMapping("/v1/verify-stock-product")
    public void verifyStockProduct(@RequestParam String productForVerify) {
        productService.verifyStockProduct(productForVerify);
    }

}
