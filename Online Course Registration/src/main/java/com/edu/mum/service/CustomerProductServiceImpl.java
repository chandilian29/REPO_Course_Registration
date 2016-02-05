/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.edu.mum.dao.CustomerProductDao;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.MyUser;
import com.mum.edu.domain.Product;
import com.mum.edu.domain.ShoppingCart;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lule
 */
public class CustomerProductServiceImpl implements CustomerProductService {

    private CustomerProductDao customerProductDao;

    //public CustomerServiceImpl() {
    public CustomerProductServiceImpl() {
    }

    //}
    //public CustomCustomerProductDaopl(CustomerDao customerDao) {
    //  this.customerDao = customerDao;
    // }
    public CustomerProductServiceImpl(CustomerProductDao customerProductDao) {
        this.customerProductDao = customerProductDao;
    }

    @Override
     public Customer getCustomerByName(String customerName) {
        return customerProductDao.getCustomerByName(customerName);
    }
//feressa

    @Override
    public Product searchProductByName(String productName) {
        return customerProductDao.searchProductByName(productName);
    }

    // getProductById(long id);
    @Override
    public Product getProductById(long id) {
        return customerProductDao.getProductById(id);
    }

    @Override
    public void updateShoppingCart(ShoppingCart shoppingCart) {
        customerProductDao.updateShoppingCart(shoppingCart);
    }

    @Override
    public List<Product> getAllProduct() {
        return customerProductDao.getAllProduct();
    }

    public List<ShoppingCart> getAllProductsFromShoppingCart() {
        return customerProductDao.getAllProductsFromShoppingCart();
    }

}
