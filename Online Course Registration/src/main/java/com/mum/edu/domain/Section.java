/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.edu.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author cArunagirinathan
 */
@Entity
public class Section {

    @Id
    @GeneratedValue
    private int id;

    private String sectionId;
    private String sectionName;
    private int noOfDays;
    private int sectionSize;

    @ManyToMany(mappedBy = "sectionList")
    private List<Customer> waitingList = new ArrayList<Customer>();

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToMany
    private List<Customer> customerList = new ArrayList<Customer>();
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Waiver> waiverList = new ArrayList();

    public Section() {
    }

    public Section(int id, String sectionId, String sectionName, int noOfDays, int sectionSize) {
        this.id = id;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.noOfDays = noOfDays;
        this.sectionSize = sectionSize;
    }

    public Section(String sectionId, String sectionName, Course course, int sectionSize, Faculty faculty, List<Customer> customerList) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.course = course;
        this.faculty = faculty;
        this.sectionSize = sectionSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setSectionSize(int sectionSize) {
        this.sectionSize = sectionSize;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public void setWaitingList(List<Customer> waitingList) {
        this.waitingList = waitingList;
    }

    public int getSectionSize() {
        return sectionSize;
    }

    public List<Customer> getWaitingList() {
        return waitingList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Waiver> getWaiverList() {
        return waiverList;
    }

    public void setWaiverList(List<Waiver> waiverList) {
        this.waiverList = waiverList;
    }

    public boolean addWaiver(Waiver waiver) {
        boolean success = false;
        if (waiverList.add(waiver)) {
            success = true;
        }
        return success;
    }

    public boolean removeWaiver(Waiver waiver) {
        boolean success = false;
        if (waiverList.remove(waiver)) {
            success = true;
        }
        return success;
    }
}
