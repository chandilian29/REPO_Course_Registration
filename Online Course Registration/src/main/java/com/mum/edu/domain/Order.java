/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.edu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author cArunagirinathan
 */
@Entity
public class Order {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Product product;
    private int quantity;

    public Order() {
    }

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
