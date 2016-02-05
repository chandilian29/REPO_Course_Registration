/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.controller;

import com.edu.mum.service.CustomerProductService;
import com.edu.mum.service.CustomerProductService;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Order;
import com.mum.edu.domain.Product;
import com.mum.edu.domain.ShoppingCart;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lule
 */
@Controller
public class CustomerProductController {

    public String userName;
    public ShoppingCart currentShoppingCart;
    public Product currentProduct;
    public Order currentOrder;
    //public 
//      @RequestMapping("/")
//    public String index() {
//        return "index";
//    }
    @Autowired
    private CustomerProductService customerProductServiceImpl;

    //search product
//    @RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
//    public String searchProduct() {
//        return "productSearchResult";
//    }
//
//    @RequestMapping(value = "/searchProductForm", method = RequestMethod.POST)
//    public String searchProduct(@RequestParam("productName") String productName, Model model) {
//        model.addAttribute("product", customerProductServiceImpl.searchProductByName(productName));
//        return "redirect:/searchProduct";
//    }
    //........................................
    // search customer
    @RequestMapping(value = "/searchCustomer", method = RequestMethod.GET)
    public String searchCustomer() {
        return "searchCustomer";
    }

    @RequestMapping(value = "/searchCustomerForm", method = RequestMethod.POST)
    public String searchCustomerForm(@RequestParam("customerName") String customerName, Model model) {
        Customer searchedCustomer = customerProductServiceImpl.getCustomerByName(customerName);

        if (searchedCustomer != null) {
            model.addAttribute("customer", searchedCustomer);// .addAttribute("customer", searchedCustomer);
            return "customerSearchResult";
        } else {
            return "customerDoesNotExist";
        }

    }

    @RequestMapping(value = "/customerDoesNotExist", method = RequestMethod.GET)
    public String customerDoesNotExist() {
        //  model.addAttribute("myuser", customerProductServiceImpl.getUser(customerName));
        return "customerDoesNotExist";        //why we need this?
    }

    @RequestMapping(value = "/customerSearchResult", method = RequestMethod.GET)
    public String customerSearchResult() {
        //  model.addAttribute("myuser", customerProductServiceImpl.getUser(customerName));
        return "customerSearchResult";        //why we need this?
    }

    //............................
    //yonas
    @RequestMapping(value = "/customerProductList", method = RequestMethod.GET)
    public String customerProductList(Model model) {
        model.addAttribute("products", customerProductServiceImpl.getAllProduct());
        return "customerProductList";        //why we need this?
    }

    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable long id, Model model) {
        //model.addAttribute("myuser", customerProductServiceImpl.getUser(customerName));
        this.currentProduct = customerProductServiceImpl.getProductById(id);
        //customerProductServiceImpl.getAllProductsFromShoppingCart();
        
      
        //currentOrder = new Order(currentProduct, 1);
        if (currentShoppingCart == null) {
            currentShoppingCart = new ShoppingCart();
        }
        currentShoppingCart.getProductsInCart().add(currentProduct);
        customerProductServiceImpl.updateShoppingCart(currentShoppingCart);
        return "addCartSuccess";
    }

    @RequestMapping(value = "/addCartSuccess", method = RequestMethod.GET)
    public String addCartSuccess() {
        //  model.addAttribute("myuser", customerProductServiceImpl.getUser(customerName));
        return "addCartSuccess";
    }

    @RequestMapping(value = "/customerViewProducts", method = RequestMethod.GET)
    public String customerViewProducts(Model model) {
        model.addAttribute("products", customerProductServiceImpl.getAllProduct());
        return "customerViewProducts";
    }

    @RequestMapping(value = "/checkOut", method = RequestMethod.GET)
    public String checkOut(Model model) {
        //model.addAttribute("products", customerProductServiceImpl.getAllProduct());

        return "checkOutSuccess";
    }

    @RequestMapping(value = "/submitBillingInfo", method = RequestMethod.GET)
    public String submitBillingInfo(Model model) {
        // model.addAttribute("products", customerProductServiceImpl.getAllProduct());

        return "submitBillingInfo";
    }

    @RequestMapping(value = "/submitSuccess", method = RequestMethod.GET)
    public String submitSuccess(Model model) {
        // model.addAttribute("products", customerProductServiceImpl.getAllProduct());

        return "submitSuccess";
    }

    @RequestMapping(value = "/productsInShoppingCart", method = RequestMethod.GET)
    public String productsInShoppingCart(Model model) {

//        List<ShoppingCart> shoppingCarts = customerProductServiceImpl.getAllProductsFromShoppingCart();
//        int counter = 0;
//        List<Product> productsInShoppingCart = new ArrayList();
//        if (!shoppingCarts.isEmpty()) {
//            for (Order order : shoppingCarts.get(0).getOrderList()) {
//                productsInShoppingCart.add(order.getProduct());
//            }
//        }
//        model.addAttribute("productsInShoppingCart", productsInShoppingCart);
        return "productsInShoppingCart";
    }
    //.......................................
}
