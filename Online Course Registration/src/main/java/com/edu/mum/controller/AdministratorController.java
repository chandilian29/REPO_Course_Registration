/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.controller;

import com.edu.mum.service.IAdministratorService;
import com.mum.edu.domain.Administrator;
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
public class AdministratorController {
    
    @Autowired
    IAdministratorService adminService;
    
    /*@RequestMapping("/")
    public String index(){
        return "index";
    }*/
    
    @RequestMapping(value = "/createAdministrator", method = RequestMethod.GET)
    public String add(@ModelAttribute("administrator") Administrator admin) {
        return "createAdministrator";
    }
    
    @RequestMapping(value = "/createAdministrator", method = RequestMethod.POST)
    public String addPost(@Valid Administrator admin, BindingResult result) {
        String view = "redirect:/";
        if (!result.hasErrors()&&!adminService.isAdministratorExist(admin.getUsername())) {
            adminService.createAdministrator(admin);
        } else {
            view = "/createAdministrator";
        }
        return view;
    }
}
