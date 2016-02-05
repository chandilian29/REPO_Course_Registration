/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.dao;

import com.mum.edu.domain.Customer;
import com.mum.edu.domain.MyUser;
import com.mum.edu.domain.Product;
import com.mum.edu.domain.ShoppingCart;
import java.util.List;

/**
 *
 * @author lule
 */
public interface CustomerProductDao {
    // public Customer searchCustomerByName(String firstName);

    public Customer getCustomerByName(String customerName);

    public Product searchProductByName(String productName);

    public Product getProductById(long id);
    // public ShoppingCart updateShoppingCart();

    public void updateShoppingCart(ShoppingCart shoppingCart);

    public List<Product> getAllProduct();

    public List<ShoppingCart> getAllProductsFromShoppingCart();
}
