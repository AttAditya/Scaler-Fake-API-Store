package com.scaler.midterms.services;

import com.scaler.midterms.models.CartModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartService {

    private final RestTemplate restTemplate;
    private final String fsaURL;

    public CartService() {
        this.restTemplate = new RestTemplate();
        this.fsaURL = "https://fakestoreapi.com";
    }


    public List<CartModel> getAllCarts() {
        List<CartModel> response = restTemplate.getForObject(fsaURL + "/carts", List.class);
        return response;
    }

    public CartModel getSpecificCart(Long cartId) {
        CartModel response = restTemplate.getForObject(fsaURL + "/carts/" + cartId, CartModel.class);
        return response;
    }

    public List<CartModel> getUserCarts(Long userId) {
        List<CartModel> response = restTemplate.getForObject(fsaURL + "/carts/user/" + userId, List.class);
        return response;
    }

    public CartModel addNewCart(CartModel cartModel) {
        CartModel response = restTemplate.postForObject(fsaURL + "/carts/", cartModel, CartModel.class);
        return response;
    }

    public CartModel updateCart(CartModel cartModel, Long cartId) {
        CartModel response = restTemplate.patchForObject(fsaURL + "/carts/" + cartId, cartModel, CartModel.class);
        return response;
    }

    public CartModel deleteModel(Long cartId) {
        CartModel deletedItem = getSpecificCart(cartId);
        restTemplate.delete(fsaURL + "/carts/" + cartId);
        return deletedItem;
    }
}
