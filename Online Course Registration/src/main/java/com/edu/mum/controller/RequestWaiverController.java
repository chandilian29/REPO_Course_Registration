/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.controller;
import com.edu.mum.service.ICustomerService;
import com.edu.mum.service.IWaiverService;
import com.edu.mum.service.SectionService;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Section;
import com.mum.edu.domain.Waiver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Uguudei
 */

@Controller
public class RequestWaiverController {
    @Autowired
    IWaiverService waiverService;
    
    @Autowired
    SectionService sectionService;
    
    @Autowired
    ICustomerService customerService;
    
    @RequestMapping(value = "/requestWaiver", method = RequestMethod.GET)
    public String requestWaiver(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("waiver") Waiver waiver, Model model) {
        Customer customer = (Customer)request.getSession().getAttribute("loggedCustomer");
        
        model.addAttribute("waivers", customerService.getCustomer(customer.getId()).getWaiverList());
        model.addAttribute("sections", sectionService.getAll());
        model.addAttribute("customer", customer);
        return "requestWaiver";
    }
    
    @RequestMapping(value = "/requestWaiver", method = RequestMethod.POST)
    public String requestWaiverPost(HttpServletRequest request, HttpServletResponse response, Waiver waiver){
        Customer customer = (Customer)request.getSession().getAttribute("loggedCustomer");
        Section section = waiverService.getSection(waiver.getStatus());
        waiverService.createRequestWaiver(customerService.getCustomer(customer.getId()), waiver, section);
        return "redirect:/requestWaiver";
    }
    
    @RequestMapping(value = "/deleteWaiver/{id}", method = RequestMethod.GET)
    public String deleteWaiver(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        Customer customer = (Customer)request.getSession().getAttribute("loggedCustomer");
        waiverService.deleteWaiver(sectionService.getSection(waiverService.getWaiverById(id).getStatus()), 
                waiverService.getWaiverById(id), sectionService.getSectionDao(), customerService.getCustomerDAO(), customer);
        waiverService.deleteWaiver(id);
        
        return "redirect:/requestWaiver";
    }
}
