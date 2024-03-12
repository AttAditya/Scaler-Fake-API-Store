package com.scaler.midterms.controllers;

import com.scaler.midterms.models.ProductModel;
import com.scaler.midterms.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/products")
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public ProductModel getSpecificProduct(@PathVariable("productId") Long productId) {
        return productService.getSpecificProduct(productId);
    }

    @GetMapping("/products/categories")
    public List<String> getAllCategories() {
        return productService.getAllCategories();
    }

    @GetMapping("/products/category/{categoryName}")
    public List<ProductModel> getCategoryProducts(@PathVariable("categoryName") String categoryName) {
        return productService.getCategoryProducts(categoryName);
    }

    @PostMapping("/products")
    public ProductModel addNewProduct(@RequestBody ProductModel productModel) {
        return productService.addNewProduct(productModel);
    }

    @PutMapping("/products/{productId}")
    @PatchMapping("/products/{productId}")
    public ProductModel updateProduct(@RequestBody ProductModel productModel, @PathVariable("productId") Long productId) {
        return productService.updateProduct(productModel, productId);
    }

    @DeleteMapping("/products/{productId}")
    public ProductModel deleteProduct(@PathVariable("productId") Long productId) {
        return productService.deleteModel(productId);
    }
}
