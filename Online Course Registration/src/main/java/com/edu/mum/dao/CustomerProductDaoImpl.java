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
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lule
 */
@Transactional
public class CustomerProductDaoImpl implements CustomerProductDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Customer getCustomerByName(String customerName) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select c from Customer c where c.firstName=:customerName");
        query.setParameter("customerName", customerName);
        if (!query.list().isEmpty()) {
            return (Customer) query.list().get(0);
        } else {
            return null;
        }
    }

    //feressa
    @Override
    public Product searchProductByName(String productName) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select p from Product p where p.productName=:productName");
        query.setParameter("productName", productName);
        return (Product) query.list().get(0);
    }
// need revision

    @Override
    public Product getProductById(long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select p from Product p where p.id=:id");
        query.setParameter("id", id);
        return (Product) query.list().get(0);
    }
// need revision
//    @Override
//    public ShoppingCart updateShoppingCart() {
//       Query query = sf.getCurrentSession().createQuery("Select sc from ShoppingCart sc where sc.shoppingCart=:shoppingCart");
//        query.setParameter("shoppingCart", id);        
//        return (ShoppingCart) query.list().get(0);
    //}

    @Override
    public void  updateShoppingCart(ShoppingCart shoppingCart) {
//        Query query = sessionFactory.getCurrentSession().createQuery("Select sc from ShoppingCart sc where sc.shoppingCartsc=:shoppingCartsc");
//        query.setParameter("shoppingCartsc", shoppingCart);
//        return (ShoppingCart) query.list().get(0);
        sessionFactory.getCurrentSession().saveOrUpdate(shoppingCart);// update(shoppingCart);
    }

    public List<Product> getAllProduct() {
        return (List<Product>) sessionFactory.getCurrentSession().createQuery("From Product").list();
    }

    public List<ShoppingCart> getAllProductsFromShoppingCart() {
        return sessionFactory.getCurrentSession().createQuery("From ShoppingCart").list();
    }
}
