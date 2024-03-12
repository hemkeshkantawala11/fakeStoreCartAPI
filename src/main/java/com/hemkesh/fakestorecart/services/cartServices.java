package com.hemkesh.fakestorecart.services;

import com.hemkesh.fakestorecart.models.Cart;
import com.hemkesh.fakestorecart.models.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
@Service
public class cartServices {
    RestTemplate restTemplate = new RestTemplate();
    public List<Cart> getAllCarts(){
        Cart[] carts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                Cart[].class
        );

        List<Cart> finalCart = new ArrayList<>();

        for(Cart cart: carts){
            Cart newCart = new Cart();
            newCart.setId(cart.getId());
            newCart.setUserId(cart.getUserId());
            newCart.setProducts(new ArrayList<>());

            for(Products product: cart.getProducts()){
                Products newProduct = new Products();
                newProduct.setProductId(product.getProductId());
                newProduct.setQuantity(product.getQuantity());
                newCart.getProducts().add(newProduct);
            }
            newCart.setDate(cart.getDate());
            newCart.set__v(cart.get__v());
            finalCart.add(newCart);
        }
        return finalCart;
    }

    public Cart getCartById(Long id){
        Cart cart = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/" + id,
                Cart.class
        );

        Cart newCart = new Cart();
        newCart.setId(cart.getId());
        newCart.setUserId(cart.getUserId());
        newCart.setProducts(new ArrayList<>());

        for(Products product: cart.getProducts()){
            Products newProduct = new Products();
            newProduct.setProductId(product.getProductId());
            newProduct.setQuantity(product.getQuantity());
            newCart.getProducts().add(newProduct);
        }

        newCart.setDate(cart.getDate());
        newCart.set__v(cart.get__v());
        return newCart;

    }

    public List<Cart> getCartsByDate(String sDate, String eDate){
        Cart[] carts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts?startdate=" + sDate + "&enddate=" + eDate,
                Cart[].class
        );

        List<Cart> finalCart = new ArrayList<>();

        for(Cart cart: carts){
            Cart newCart = new Cart();
            newCart.setId(cart.getId());
            newCart.setUserId(cart.getUserId());
            newCart.setProducts(new ArrayList<>());
            for(Products product: cart.getProducts()){
                Products newProduct = new Products();
                newProduct.setProductId(product.getProductId());
                newProduct.setQuantity(product.getQuantity());
                newCart.getProducts().add(newProduct);
            }
            newCart.setDate(cart.getDate());
            newCart.set__v(cart.get__v());
            finalCart.add(newCart);
        }
        return finalCart;
    }


    public List<Cart> getCartByUser(Long userID){
        List<Cart> finalCarts = new ArrayList<>();
        List<Cart> carts = this.getAllCarts();
        for(Cart cart: carts){
            if(cart.getUserId() == userID){
                finalCarts.add(cart);
            }
        }
        return finalCarts;
    }

    public Cart addCart(Cart cart){
        Cart newCart = new Cart();
        newCart.setId(cart.getId());
        newCart.setUserId(cart.getUserId());
        newCart.setProducts(new ArrayList<>());
        for(Products product: cart.getProducts()){
            Products newProduct = new Products();
            newProduct.setProductId(product.getProductId());
            newProduct.setQuantity(product.getQuantity());
            newCart.getProducts().add(newProduct);
        }
        newCart.setDate(cart.getDate());
        newCart.set__v(cart.get__v());

        restTemplate.postForObject(
                "https://fakestoreapi.com/carts",
                newCart,
                Cart.class
        );
        return newCart;
    }


    public Cart deleteCart(Long id){
        restTemplate.delete("https://fakestoreapi.com/carts/" + id);
        return null;
    }

    public Cart updateCart(Cart cart, Long id){
        Cart thisCart = this.getCartById(id);

        Cart updatedCart = new Cart();

        updatedCart.setId(thisCart.getId());
        updatedCart.setUserId(thisCart.getUserId());
        updatedCart.setProducts(new ArrayList<>());
        for(Products product: cart.getProducts()){
            Products newProduct = new Products();
            newProduct.setProductId(product.getProductId());
            newProduct.setQuantity(product.getQuantity());
            updatedCart.getProducts().add(newProduct);
        }
        updatedCart.setDate(thisCart.getDate());
        updatedCart.set__v(thisCart.get__v());

        restTemplate.put(
                "https://fakestoreapi.com/carts/" + id,
                updatedCart
        );
        return updatedCart;
    }
}
