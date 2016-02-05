/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.edu.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author cArunagirinathan
 */
@Entity
public class Course {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty(message = "Course Name cannot be empty.")
    private String courseName;
    @NotEmpty(message = "Course ID cannot be empty.")
    private String courseId;
    @NotEmpty(message = "Course Description cannot be empty.")
    private String courseDescription;
    @Min(value = 1,message = "Must be atleast 1 or more")
    private int offeringsPerTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Course_Prerequisite")
    private List<Course> prerequestic = new ArrayList<Course>();

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Section> sectionList = new ArrayList<Section>();

    public Course() {
    }

    public Course(int id, String courseName, String courseId, String courseDescription, int offeringsPerTime) {
        this.id = id;
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseDescription = courseDescription;
        this.offeringsPerTime = offeringsPerTime;
    }

    public Course(String courseId, String courseName, String courseDescription, int offeringsPerTime) {

        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.offeringsPerTime = offeringsPerTime;
    }

    public Course(String courseName, String courseId, String courseDescription, List<Section> sectionList, List<Course> prerequestic) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseDescription = courseDescription;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<Course> getPrerequestic() {
        return prerequestic;
    }

    public void setPrerequestic(List<Course> prerequestic) {
        this.prerequestic = prerequestic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOfferingsPerTime() {
        return offeringsPerTime;
    }

    public void setOfferingsPerTime(int offeringsPerTime) {
        this.offeringsPerTime = offeringsPerTime;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public void addPrerequestic(Course course) {
        prerequestic.add(course);
    }

    public void removePrerequestic(Course course) {
        prerequestic.remove(course);
    }

    public void addsectiontoList(Section section) {
        sectionList.add(section);
    }

    public void removeSectionfromList(Section section) {
        sectionList.remove(section);
    }

}
