/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.edu.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author cArunagirinathan
 */
@Entity
public class Transcript {
    @Id@GeneratedValue
    private int id;
    private List<Customer> customerList;
    private List<Section> sectionList;

    public Transcript() {
    }

    public Transcript(List<Customer> customerList, List<Section> sectionList) {
        customerList = new ArrayList<Customer>();
        sectionList = new ArrayList<Section>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
    
    
}
