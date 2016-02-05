/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.controller;

import com.edu.mum.service.IYogaCourseService;
import com.mum.edu.domain.Course;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Section;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Yonas
 */
@Controller
public class courseController {

    @Autowired
    private IYogaCourseService yogaCourseService;
    private Course currentCourse;
    //  private Customer currentCustomer = new Customer("Yonas", "Mulissa", "ymulissa", "1234", 28);
    private int currentCustomerId;
    // Customer cust = (Customer) request.getSession().getAttribute("customer");

    public IYogaCourseService getYogaCourseService() {
        return yogaCourseService;
    }

    public void setYogaCourseService(IYogaCourseService yogaCourseService) {
        this.yogaCourseService = yogaCourseService;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    @RequestMapping(value = "/courseList", method = RequestMethod.GET)
    public String viewProduct(org.springframework.ui.Model model) {
        model.addAttribute("courses", yogaCourseService.getAllCourse());
        
        
        return "courseList";
    }

    @RequestMapping(value = "/sectionListForRegistration", method = RequestMethod.GET)
    public String sectionList(org.springframework.ui.Model model) {
        model.addAttribute("sections", yogaCourseService.getAllSection());
        return "sectionListForRegistration";
    }

//    @RequestMapping(value = "/registeredSectionList", method = RequestMethod.GET)
//    public String registeredSectionList(org.springframework.ui.Model model) {
//        model.addAttribute("sections", yogaCourseService.getRegisteredSectionsByCusomerId(currentCustomer.getId()));
//        return "registeredSectionList";
//    }
    @RequestMapping(value = "/showSections/{courseId}", method = RequestMethod.GET)
    public String showSections(@PathVariable String courseId, org.springframework.ui.Model model) {
        currentCourse = yogaCourseService.getCourseById(courseId);
        model.addAttribute("sections", yogaCourseService.getSectionsByCourseId(courseId));
        return "sectionListForRegistration";
    }

    @RequestMapping(value = "/dropSection/{sectionId}", method = RequestMethod.GET)
    public String dropSection(HttpServletRequest request, HttpServletResponse response, @PathVariable String sectionId, org.springframework.ui.Model model) {
        // currentCourse = yogaCourseService.getCourseById(sectionId);
        // model.addAttribute("sections", yogaCourseService.getSectionsByCourseId(sectionId));
        Customer loggedCustomer = (Customer) request.getSession().getAttribute("loggedCustomer");
        this.currentCustomerId = loggedCustomer.getId();
        loggedCustomer = yogaCourseService.getCustomerById(currentCustomerId);
        Section section = yogaCourseService.getSectionById(sectionId);
        loggedCustomer.getSectionList().remove(section);
        section.getCustomerList().remove(loggedCustomer);
        loggedCustomer.getSectionList().remove(section);

        yogaCourseService.updateSection(section);
        yogaCourseService.updateCustomer(loggedCustomer);
        // yogaCourseService.dropSection(section.getId(), customer.getId());
        return "dropSectionSuccess";
    }

    @RequestMapping(value = "/dropSectionSuccess", method = RequestMethod.GET)
    public String dropSectionSuccess(org.springframework.ui.Model model) {

        return "dropSectionSuccess";
    }

    @RequestMapping(value = "/listRegisteredSections", method = RequestMethod.GET)
    public String listRegisteredSections(HttpServletRequest request, HttpServletResponse response, org.springframework.ui.Model model) {
        //currentCourse = yogaCourseService.getCourseById(courseId);
        Customer loggedCustomer = (Customer) request.getSession().getAttribute("loggedCustomer");
        this.currentCustomerId = loggedCustomer.getId();
        loggedCustomer = yogaCourseService.getCustomerById(currentCustomerId);

        //model.addAttribute("sections", yogaCourseService.getSectionsByCustomerId(currentCustomerId));
        model.addAttribute("sections", loggedCustomer.getSectionList());

        return "listRegisteredSections";
    }

//    @RequestMapping(value = "/temRequestWaiver", method = RequestMethod.GET)
//    public String requestWaiver(HttpServletRequest request, HttpServletResponse response, org.springframework.ui.Model model) {
//        Customer loggedCustomer = (Customer) request.getSession().getAttribute("loggedCustomer");
//        loggedCustomer = yogaCourseService.getCustomerById(loggedCustomer.getId());
//
//
//        model.addAttribute("waivers", loggedCustomer.getWaiverList());
//        model.addAttribute("sections", yogaCourseService.getAllSection());
//        model.addAttribute("customer", loggedCustomer);
//        return "requestWaiver";
//    }
    
    

    @RequestMapping(value = "/showSections/registerForSection/{sectionId}", method = RequestMethod.GET)
    public String showSectionRegister(HttpServletRequest request, HttpServletResponse response, @PathVariable String sectionId, org.springframework.ui.Model model) {
        // model.addAttribute("sections", yogaCourseService.getSectionByCourseId(CourseId));

        Section section = yogaCourseService.getSectionById(sectionId);
        Customer loggedCustomer = (Customer) request.getSession().getAttribute("loggedCustomer");
        loggedCustomer = yogaCourseService.getCustomerById(loggedCustomer.getId());
        this.currentCustomerId = loggedCustomer.getId();
        for (Customer customer : section.getCustomerList()) {
            if (customer.getId() == currentCustomerId) {
                model.addAttribute("waivers", loggedCustomer.getWaiverList());
                model.addAttribute("sections", yogaCourseService.getAllSection());
                model.addAttribute("customer", loggedCustomer);
                return "youWereRegistered";
            }
        }
        //if (yogaCourseService.getSectionById(sectionId).getCourse().getPrerequestic() == null) {
        if (this.fullFillPrerequisite(sectionId) == false) {
            return "temRequestWaiver";
        }
        //}

        if (section.getCustomerList().size() >= section.getSectionSize()) {
            section.getWaitingList().add(yogaCourseService.getCustomerById(currentCustomerId));
            return "placedInWaitingList";
        }
        //yogaCourseService.getCustomerById(currentCustomerId).getSectionList().add(section);
        //loggedCustomer = yogaCourseService.getCustomerById(loggedCustomer.getId());
        loggedCustomer.getSectionList().add(section);
        section.getCustomerList().add(loggedCustomer);
        // yogaCourseService.registerCustomer(section);
        yogaCourseService.updateSection(section);
        yogaCourseService.updateCustomer(loggedCustomer);

        // model.addAttribute("sections", yogaCourseService.getSectionsByCustomerId(currentCustomer.getId()));
        return "sectionRegistrationSucess";
    }

    @RequestMapping(value = "/registerForSection/{sectionId}", method = RequestMethod.GET)
    public String registerForSection(HttpServletRequest request, HttpServletResponse response, @PathVariable String sectionId, org.springframework.ui.Model model) {
        // model.addAttribute("sections", yogaCourseService.getSectionByCourseId(CourseId));

        Section section = yogaCourseService.getSectionById(sectionId);
        Customer loggedCustomer = (Customer) request.getSession().getAttribute("loggedCustomer");
        this.currentCustomerId = loggedCustomer.getId();
        for (Customer customer : section.getCustomerList()) {
            if (customer.getId() == currentCustomerId) {
                return "youWereRegistered";
            }
        }
       // if (yogaCourseService.getSectionById(sectionId).getCourse().getPrerequestic() == null) {
            if (this.fullFillPrerequisite(sectionId) == false) {
                return "temRequestWaiver";
            }
       // }

        if (section.getCustomerList().size() >= section.getSectionSize()) {
            section.getWaitingList().add(yogaCourseService.getCustomerById(currentCustomerId));
            return "placedInWaitingList";
        }
        //yogaCourseService.getCustomerById(currentCustomerId).getSectionList().add(section);
        loggedCustomer = yogaCourseService.getCustomerById(loggedCustomer.getId());
        loggedCustomer.getSectionList().add(section);
        section.getCustomerList().add(loggedCustomer);
        // yogaCourseService.registerCustomer(section);
        yogaCourseService.updateSection(section);
        yogaCourseService.updateCustomer(loggedCustomer);

        // model.addAttribute("sections", yogaCourseService.getSectionsByCustomerId(currentCustomer.getId()));
        return "sectionRegistrationSucess";
    }

    @RequestMapping(value = "/applyForWaiver", method = RequestMethod.GET)
    public String applyForWaiver(org.springframework.ui.Model model) {
        // model.addAttribute("sections", yogaCourseService.getAllSection());
        return "applyForWaiver";
    }

     @RequestMapping(value = "/temRequestWaiver", method = RequestMethod.GET)
    public String temRequestWaiver(org.springframework.ui.Model model) {
        // model.addAttribute("sections", yogaCourseService.getAllSection());
        return "temRequestWaiver";
    }
    
    @RequestMapping(value = "/youWereRegistered", method = RequestMethod.GET)
    public String youWereRegistered(org.springframework.ui.Model model) {
        // model.addAttribute("sections", yogaCourseService.getAllSection());
        return "youWereRegistered";
    }

//    @RequestMapping(value = "/dropSection/{sectionId}", method = RequestMethod.GET)
//    public String dropSection(@PathVariable String sectionId, org.springframework.ui.Model model) {
//        // model.addAttribute("sections", yogaCourseService.getSectionByCourseId(CourseId));
//        Section section = yogaCourseService.getSectionById(sectionId);
//        section.getCustomerList().remove(currentCustomer);
//        yogaCourseService.registerCustomer(section);
//        return "registeredSectionList";
//    }
    @RequestMapping(value = "/placedInWaitingList", method = RequestMethod.GET)
    public String placedInWaitingList(org.springframework.ui.Model model) {
        // model.addAttribute("sections", yogaCourseService.getAllSection());
        return "placedInWaitingList";
    }

    public boolean fullFillPrerequisite(String sectionId) {
        boolean hasPrerequsite = true;
        currentCourse = yogaCourseService.getSectionById(sectionId).getCourse();
        Customer customer = yogaCourseService.getCustomerById(currentCustomerId);
        for (Course prerequisite : currentCourse.getPrerequestic()) {
            hasPrerequsite = false;
            for (Course completedCourse : customer.getCompletedCourses()) {
                if (prerequisite.getCourseName().equalsIgnoreCase(completedCourse.getCourseName())) {
                    hasPrerequsite = true;
                }
            }

            if (hasPrerequsite == false) {
                return false;
            }
        }

        return hasPrerequsite;
    }
}
