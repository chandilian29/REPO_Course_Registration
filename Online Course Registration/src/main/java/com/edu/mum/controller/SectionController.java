/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.controller;

import com.edu.mum.service.SectionService;
import com.mum.edu.domain.Faculty;
import com.mum.edu.domain.Section;
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
 * @author pAlahakoon
 */
@Controller
public class SectionController {

    private int sectionId;

    @Autowired
    private SectionService sectionService;

    @RequestMapping(value = "viewSections/deleteSection/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        sectionService.delete(id);
        return "redirect:/viewCourse";
    }

    @RequestMapping(value = "viewSections/viewSection/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("section", sectionService.get(id));
        return "sectionDetail";
    }

    @RequestMapping(value = "viewSections/viewSection/{id}", method = RequestMethod.POST)
    public String update(@Valid Section section, BindingResult result, @PathVariable int id) {
        if (!result.hasErrors()) {
            sectionService.update(id, section);
            return "redirect:/viewCourse";
        } else {
            return "sectionDetail";
        }
    }

    @RequestMapping(value = "/viewSection", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("sections", sectionService.getAll());
        return "sectionList";
    }

    @RequestMapping(value = "/addSection", method = RequestMethod.GET)
    public String addSection(@ModelAttribute("mySection") Section section) {
        return "addSection";
    }

    @RequestMapping(value = "/addSection", method = RequestMethod.POST)
    public String addSection(@Valid Section section, BindingResult result, RedirectAttributes re) {
        if (!result.hasErrors()) {
            sectionService.addSection(section);
            return "redirect:/viewSection";
        }
        else{
        return "addSection";
        }
    }

    //add Faculty to Section
    @RequestMapping(value = "viewSections/addFacultytoSection/{id}", method = RequestMethod.GET)
    public String addFacultytoSection(@PathVariable int id, Model model, @ModelAttribute("myFac") Faculty faculty) {
        sectionId = id;
        model.addAttribute("facList", sectionService.getAllFaculty());
        return "addFactoSection";
    }

    @RequestMapping(value = "viewSections/addFacultytoSection/addFacultytoSection", method = RequestMethod.GET)
    public String addFacultytoSections(@RequestParam String firstName) {
        Faculty newFaculty = sectionService.getFacultybyFirstName(firstName);
        Section section = sectionService.get(sectionId);
        section.setFaculty(newFaculty);
        newFaculty.getSectionList().add(section);
        sectionService.updateFaculty(sectionId, section);
        return "redirect:/viewCourse";
    }


}
