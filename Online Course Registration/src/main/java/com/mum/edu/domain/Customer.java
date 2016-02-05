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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author cArunagirinathan
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String firstName;
    private String lastName;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private String address;
    private String phoneNo;
    private int age;
    ////////////Yonas Added this//////////////
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private List<Course> completedCourses = new ArrayList();
    /////////////end of yonas added///////////
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<Waiver> waiverList = new ArrayList<Waiver>();
    @OneToOne
    private ShoppingCart shoppingCart;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Faculty advisor;
    @ManyToMany
    @JoinTable(name = "Customer_Section",
            joinColumns = {
        @JoinColumn(name = "customer_id")},
            inverseJoinColumns = {
        @JoinColumn(name = "section_id")})
    private List<Section> sectionList = new ArrayList<Section>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, String username, String password, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public Customer(ShoppingCart shoppingCart, Faculty advisor, List<Waiver> waiverList) {
        this.shoppingCart = shoppingCart;
        this.advisor = advisor;
    }

    public Customer(String firstName, String lastName, String username, String password, String address, String phoneNo, int age, ShoppingCart shoppingCart, Faculty advisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNo = phoneNo;
        this.age = age;
        this.shoppingCart = shoppingCart;
        this.advisor = advisor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Faculty getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Faculty advisor) {
        this.advisor = advisor;
    }

    public List<Waiver> getWaiverList() {
        return waiverList;
    }

    public void setWaiverList(List<Waiver> waiverList) {
        this.waiverList = waiverList;
    }

    public List<Course> getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(List<Course> completedCourses) {
        this.completedCourses = completedCourses;
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

    public boolean addSection(Section section) {
        boolean success = false;
        if (sectionList.add(section)) {
            success = true;
        }
        return success;
    }

    public boolean removeSection(Section section) {
        boolean success = false;
        if (sectionList.remove(section)) {
            success = true;
        }
        return success;
    }
}
