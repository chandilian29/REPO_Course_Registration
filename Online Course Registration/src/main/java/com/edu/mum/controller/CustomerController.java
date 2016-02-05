/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.controller;

import com.edu.mum.service.ICustomerService;
import com.mum.edu.domain.Customer;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Uguudei
 */
@Controller
public class CustomerController {
    
    @Autowired
    ICustomerService customerService;
    
    /*@RequestMapping("/")
    public String index(){
        return "index";
    }*/
    
    @RequestMapping(value = "/createCustomer", method = RequestMethod.GET)
    public String add(@ModelAttribute("customer") Customer customer) {
        return "createCustomer";
    }
    
    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public String addPost(@Valid Customer customer, BindingResult result) {
        String view = "redirect:/";
        if (!result.hasErrors()&&!customerService.isCustomerExist(customer.getUsername())) {
            customerService.createCustomer(customer);
        } else {
            view = "createCustomer";
        }
        return view;
    }
}
