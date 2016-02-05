/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mum.edu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Sandy
 */
@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    private String productName;
    @NotEmpty
    private String productPrice;
    @NotEmpty
    private String productDescription;

    public Product() {
    }

    public Product(String productName, String productPrice, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
