/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.edu.domain;

import java.util.ArrayList;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author cArunagirinathan
 */
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Product> productsInCart=new ArrayList<Product>();

    public ShoppingCart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }


   
    
}
