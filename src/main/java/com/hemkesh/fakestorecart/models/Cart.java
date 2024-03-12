package com.hemkesh.fakestorecart.models;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Cart {
    private Long Id;
    private Long userId;
    private String Date;
    private List<Products> products;
    private String __v;


}
