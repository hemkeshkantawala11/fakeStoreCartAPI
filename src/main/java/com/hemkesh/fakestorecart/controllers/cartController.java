package com.hemkesh.fakestorecart.controllers;

import com.hemkesh.fakestorecart.models.Cart;
import com.hemkesh.fakestorecart.services.cartServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.*;

@RestController
public class cartController {
    private cartServices cartService;

    public cartController(cartServices cartService){
        this.cartService = cartService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping("/carts/{id}")
    public Cart getCartById(@PathVariable Long id){
        return cartService.getCartById(id);
    }

    @GetMapping("/carts?startdate={sDate}&enddate={eDate}")
    public List<Cart> getCartsByDate(@PathVariable String sDate, @PathVariable String eDate){
        return cartService.getCartsByDate(sDate, eDate);
    }

    @GetMapping("/carts/user/{userID}")
    public List<Cart> getCartByUser(@PathVariable Long userID){
        return cartService.getCartByUser(userID);
    }

    @PostMapping("/carts")
    public Cart addCart(@RequestBody Cart cart){
        return cartService.addCart(cart);
    }

    @PutMapping("/carts/{id}")
    public Cart updateCart(@RequestBody Cart cart, @PathVariable Long id){
        return cartService.updateCart(cart, id);
    }

    @DeleteMapping("/carts/{id}")
    public Cart deleteCart(@PathVariable Long id){
        return cartService.deleteCart(id);
    }

}
