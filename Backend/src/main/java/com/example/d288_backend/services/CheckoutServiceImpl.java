package com.example.d288_backend.services;

import com.example.d288_backend.dao.CartItemRepository;
import com.example.d288_backend.dao.CartRepository;
import com.example.d288_backend.dao.CustomerRepository;
import com.example.d288_backend.entities.Cart;
import com.example.d288_backend.entities.CartItem;
import com.example.d288_backend.entities.Customer;
import com.example.d288_backend.entities.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository,
                               CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();

        if (cart == null || cartItems == null || cartItems.isEmpty()) {
            return new PurchaseResponse("Error: Cart cannot be empty. Please add items to your cart.");
        }

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        cart.setStatus(StatusType.ordered);

        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);
        });

        customerRepository.save(customer);
        cartRepository.save(cart);
        cartItemRepository.saveAll(cartItems);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
