/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.controller;

import com.edu.mum.service.IFacultyService;
import com.mum.edu.domain.Faculty;
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
public class FacultyController {
    
    @Autowired
    IFacultyService facultyService;
    
    /*@RequestMapping("/")
    public String index(){
        return "index";
    }*/
    
    @RequestMapping(value = "/createFaculty", method = RequestMethod.GET)
    public String add(@ModelAttribute("faculty") Faculty faculty) {
        return "createFaculty";
    }
    
    @RequestMapping(value = "/createFaculty", method = RequestMethod.POST)
    public String addPost(@Valid Faculty faculty, BindingResult result) {
        String view = "redirect:/";
        if (!result.hasErrors()&&!facultyService.isFacultyExist(faculty.getUsername())) {
            facultyService.createFaculty(faculty);
        } else {
            view = "/createFaculty";
        }
        return view;
    }
}
