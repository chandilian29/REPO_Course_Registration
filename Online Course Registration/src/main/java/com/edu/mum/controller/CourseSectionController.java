/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.controller;

import com.edu.mum.service.CourseService;
import com.mum.edu.domain.Course;
import com.mum.edu.domain.Section;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Jevin
 */
@Controller
public class CourseSectionController {

    private int courseId;
    Course course;
    Course coursePre;

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/deleteCourse/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        courseService.delete(id);
        return "redirect:/viewCourse";
    }

    //Get the Course ID from database
    @RequestMapping(value = "/viewCourse/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("course", courseService.get(id));
        return "courseDetail";
    }

    //Update the course
    @RequestMapping(value = "/viewCourse/{id}", method = RequestMethod.POST)
    public String update(@Valid Course course, BindingResult result, @PathVariable int id) {
        if (!result.hasErrors()) {
            courseService.update(id, course);
            return "redirect:/viewCourse";
        } else {
            return "courseDetail";
        }
    }

    @RequestMapping(value = "/viewCourse", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("courses", courseService.getAll());
        return "courseDetailsList";
    }

    @RequestMapping(value = "/addCourse", method = RequestMethod.GET)
    public String addCourse(@ModelAttribute("course") Course course) {
        return "addCourse";
    }

    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public String addCourse(@Valid Course course, BindingResult result, RedirectAttributes re) {
        if (!result.hasErrors()) {
            courseService.addCourse(course);
            return "redirect:/viewCourse";
        }
        else{
        return "addCourse";
        }
    }

    //add Section
    @RequestMapping(value = "/addSection/{id}", method = RequestMethod.GET)
    public String addSectiontoCourse(@PathVariable int id, @ModelAttribute("mySection") Section section) {
        courseId = id;
        return "addSection";
    }

    @RequestMapping(value = "/addSection/{id}", method = RequestMethod.POST)
    public String addSection(@Valid Section section, BindingResult result, RedirectAttributes re) {
        if (!result.hasErrors()) {
            Course course = courseService.get(courseId);
            section.setCourse(course);
            course.getSectionList().add(section);
            courseService.addSection(section);
        }
        return "redirect:/viewCourse";
    }

    //View SectionList
    @RequestMapping(value = "/viewSections/{id}", method = RequestMethod.GET)
    public String viewSection(@PathVariable int id, Model model) {
        model.addAttribute("sections", courseService.getSectionsByCourseId(id));
        return "sectionList";
    }

    //Add Prerequisite courses
    //Get Other courses without current course
    @RequestMapping(value = "/viewCourseExcpetCurrent/{id}", method = RequestMethod.GET)
    public String getAllCoursesExceptCurrent(@PathVariable int id, Model model) {
        course = courseService.get(id);
        List<Course> courseList = new ArrayList<Course>();
        courseList = courseService.getAll();
        courseList.remove(course);
        model.addAttribute("courses", courseList);
        return "CoursePrerequisite";
    }

    //Add prerequisite to particular course 
    @RequestMapping(value = "viewCourseExcpetCurrent/addPrerequisiteToCourse/{id}", method = RequestMethod.GET)
    public String addPrerequisite(@PathVariable int id, Model model) {
        coursePre = courseService.get(id);
        course.getPrerequestic().add(coursePre);
        courseService.update(id, course);
        return "redirect:/viewCourse";
    }

    //View Prerequisite
    @RequestMapping(value = "/viewPrerequisiteCourses/{id}", method = RequestMethod.GET)
    public String viewPrerequisiteCourses(@PathVariable int id, Model model) {
        Course c = courseService.get(id);
        List<Course> viewPre = c.getPrerequestic();
        model.addAttribute("prereqisite", viewPre);
        return "prereqisticCourses";
    }

}
