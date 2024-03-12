package com.scaler.midterms.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartModel {
    private Long id;
    private Long userId;
    private String date;
    private List<CartProduct> products;
}
