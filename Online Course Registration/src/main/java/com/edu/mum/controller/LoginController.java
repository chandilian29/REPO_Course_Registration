/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.controller;

import com.edu.mum.service.LoginService;
import com.mum.edu.domain.Administrator;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Faculty;
import com.mum.edu.domain.MyUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sandy
 */
@Controller
public class LoginController {

  
    @Autowired
    private LoginService loginService;
    public String userName;
    public String userTypeLogin;
    public Customer loggedCustomer;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/manageCustomerAccount", method = RequestMethod.GET)
    public String getUserByName(Model model) {
        model.addAttribute("user", loginService.getCustomer(userName));
        return "manageCustomerAccount";
    }

    @RequestMapping(value = "/manageCustomerAccount/{id}", method = RequestMethod.POST)
    public String update(@Valid Customer customer, BindingResult result, @PathVariable int id) {
        if (!result.hasErrors()) {
            loginService.update(id, customer);
        }
        return "sucess";
    }

    @RequestMapping(value = "/customerHome", method = RequestMethod.GET)
    public String customerHome() {
        return "customerSucessLogin";
    }

    @RequestMapping(value = "/adminHome", method = RequestMethod.GET)
    public String adminHome() {
        return "adminSucessLogin";
    }

    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
    public String loginform() {
        return "myLogin";
    }

    @RequestMapping(value = "/myLogin", method = RequestMethod.POST)
    public String myLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam("uname") String uname, @RequestParam("pwd") String pwd, @RequestParam("usertype") String usertype) {
        userTypeLogin = usertype;
        if (uname.equals("") || pwd.equals("")) {
            return "failure";
        } else {

            if (usertype.equals("admin")) {
                if (loginService.isAdministratorExist(uname)) {
                    Administrator administrator = loginService.getAdministrator(uname);
                    String password = administrator.getPassword();
                    if (pwd.equals(password)) {
                        request.getSession().setAttribute("loggedAdmin", administrator);
                        return "adminSucessLogin";
                    } else {
                        return "failure";
                    }
                } else {
                    return "roleMismatch";
                }

            } else if (usertype.equals("faculty")) {
                if (loginService.isFacultyExist(uname)) {
                    Faculty faculty = loginService.getFaculty(uname);
                    String password = faculty.getPassword();
                    if (pwd.equals(password)) {
                        request.getSession().setAttribute("loggedFaculty", faculty);
                        return "facultySucessLogin";
                    } else {
                        return "failure";
                    }
                } else {
                    return "roleMismatch";
                }

            } else {
                if (loginService.isCustomerExist(uname)) {
                    Customer customer = loginService.getCustomer(uname);
                    userName = customer.getUsername();
                    String password = customer.getPassword();
                    if (pwd.equals(password)) {
                        request.getSession().setAttribute("loggedCustomer", customer);
                        return "customerSucessLogin";
                    } else {
                        return "failure";
                    }
                } else {
                    return "roleMismatch";
                }

            }


        }

    }

    @RequestMapping(value = "/addMyUser", method = RequestMethod.GET)
    public String addMyUser(@ModelAttribute("myuser") MyUser myuser) {
        return "addMyUser";
    }

    @RequestMapping(value = "/addMyUser", method = RequestMethod.POST)
    public String addMyUser(@Valid MyUser myuser, BindingResult result, RedirectAttributes re) {
        if (!result.hasErrors()) {
            loginService.addMyUser(myuser);
        }
        return "sucess";
    }
}
