/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.edu.mum.dao.ProductDao;
import com.mum.edu.domain.Product;
import com.mum.edu.domain.Product_Stock;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sandy
 */
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl() {
    }

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void delete(long productId) {
        productDao.delete(productId);
    }

    @Override
    public Product getproduct(String productName) {
        return productDao.getproduct(productName);
    }

    @Transactional
    @Override
    public void addStock(Product_Stock stock) {
        productDao.addStock(stock);
    }

    @Transactional
    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public Product addProduct(long id, String productName, String productPrice, String productDescription) {
        Product product = new Product(productName, productPrice, productDescription);
        productDao.addProduct(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product get(long productId) {
        return productDao.get(productId);
    }
    @Override
    public Product_Stock getProductStock(long productId){
        return productDao.getProductStock(productId);
    }
    @Override
    public void update(long productID, Product product) {
        productDao.update(productID, product);
    }
    @Override
    public boolean isProductExist(long id){
        return productDao.isProductExist(id);
    }
    @Override
    public void updateStcok(long id, Product_Stock product){
        productDao.updateStcok(id, product);
    }
     public boolean isProductExist(String productName){
          return productDao.getproductByName(productName);
     }
}
