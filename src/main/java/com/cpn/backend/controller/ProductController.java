package com.cpn.backend.controller;

import com.cpn.backend.models.IdealWith;
import com.cpn.backend.models.MasalaProduct;
import com.cpn.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/masalas")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<MasalaProduct> fetchProducts(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Integer maxSweet,
            @RequestParam(required = false) Integer maxSour,
            @RequestParam(required = false) Integer maxTangy,
            @RequestParam(required = false) Integer maxSpice,
            @RequestParam(required = false) List<IdealWith> idealWith) {
            
        return productService.getFilteredProducts(
                search, maxSweet, maxSour, maxTangy, maxSpice, idealWith
        );
    }
    
    @PostMapping
    public MasalaProduct createProduct(@RequestBody MasalaProduct product) {
        return productService.saveProduct(product);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
