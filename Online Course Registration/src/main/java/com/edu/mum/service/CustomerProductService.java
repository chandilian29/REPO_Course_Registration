/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.mum.edu.domain.Customer;
import com.mum.edu.domain.MyUser;
import com.mum.edu.domain.Product;
import com.mum.edu.domain.ShoppingCart;
import java.util.List;

/**
 *
 * @author lule
 */
public interface CustomerProductService {

    public Customer getCustomerByName(String customerName);

    public Product searchProductByName(String productName);

    public Product getProductById(long id);

    //updateShoppingCart(shoppingCart);
    public void updateShoppingCart(ShoppingCart shoppingCart);

    public List<Product> getAllProduct();

    public List<ShoppingCart> getAllProductsFromShoppingCart();
}
