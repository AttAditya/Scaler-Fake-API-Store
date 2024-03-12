package com.scaler.midterms.controllers;

import com.scaler.midterms.models.CartModel;
import com.scaler.midterms.services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public List<CartModel> getAllCarts(@RequestParam(value = "startdate", required = false, defaultValue = "") String startdate, @RequestParam(value = "enddate", required = false, defaultValue = "") String enddate) {
        if (startdate.isEmpty() || enddate.isEmpty()) {
            return cartService.getAllCarts();
        }

        return cartService.getAllCartsByDates(startdate, enddate);
    }

    @GetMapping("/carts/{cartId}")
    public CartModel getSpecificCart(@PathVariable("cartId") Long cartId) {
        return cartService.getSpecificCart(cartId);
    }

    @GetMapping("/carts/user/{userId}")
    public List<CartModel> getUserCarts(@PathVariable("userId") Long userId) {
        return cartService.getUserCarts(userId);
    }

    @PostMapping("/carts")
    public CartModel addNewCart(@RequestBody CartModel cartModel) {
        return cartService.addNewCart(cartModel);
    }

    @PutMapping("/carts/{cartId}")
    @PatchMapping("/carts/{cartId}")
    public CartModel updateCart(@RequestBody CartModel cartModel, @PathVariable("cartId") Long cartId) {
        return cartService.updateCart(cartModel, cartId);
    }

    @DeleteMapping("/carts/{cartId}")
    public CartModel deleteCart(@PathVariable("cartId") Long cartId) {
        return cartService.deleteModel(cartId);
    }
}
