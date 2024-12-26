package com.example.d288_backend.services;

import com.example.d288_backend.entities.Cart;
import com.example.d288_backend.entities.CartItem;
import com.example.d288_backend.entities.Customer;
import com.example.d288_backend.entities.Excursion;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Set<CartItem> cartItems = new HashSet<>();
    private Cart cart;
    private Set<Excursion> excursions = new HashSet<>();

}
