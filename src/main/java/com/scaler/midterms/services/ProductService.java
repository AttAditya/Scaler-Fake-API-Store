package com.scaler.midterms.services;

import com.scaler.midterms.models.ProductModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {

    private final RestTemplate restTemplate;
    private final String fsaURL;

    public ProductService() {
        this.restTemplate = new RestTemplate();
        this.fsaURL = "https://fakestoreapi.com";
    }


    public List<ProductModel> getAllProducts() {
        List<ProductModel> response = restTemplate.getForObject(fsaURL + "/products", List.class);
        return response;
    }

    public ProductModel getSpecificProduct(Long productId) {
        ProductModel response = restTemplate.getForObject(fsaURL + "/products/" + productId, ProductModel.class);
        return response;
    }

    public List<String> getAllCategories() {
        List<String> response = restTemplate.getForObject(fsaURL + "/products/categories", List.class);
        return response;
    }

    public List<ProductModel> getCategoryProducts(String categoryName) {
        List<ProductModel> response = restTemplate.getForObject(fsaURL + "/products/category/" + categoryName, List.class);
        return response;
    }

    public ProductModel addNewProduct(ProductModel productModel) {
        ProductModel response = restTemplate.postForObject(fsaURL + "/products/", productModel, ProductModel.class);
        return response;
    }

    public ProductModel updateProduct(ProductModel productModel, Long productId) {
        ProductModel response = restTemplate.patchForObject(fsaURL + "/products/" + productId, productModel, ProductModel.class);
        return response;
    }

    public ProductModel deleteModel(Long productId) {
        ProductModel deletedItem = getSpecificProduct(productId);
        restTemplate.delete(fsaURL + "/products/" + productId);
        return deletedItem;
    }
}
