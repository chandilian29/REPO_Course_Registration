/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.edu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author cArunagirinathan
 */

@Entity
public class Waiver {
    @Id@GeneratedValue
    private int id;
    private String status;
    @ManyToOne
    @JoinColumn(name="waiver_id")
    private Section section;
    
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    
    public Waiver() {
    }

    public Waiver(String status) {
        this.status = status;
    }

    public Waiver(String status, Section section, Customer customer) {
        this.status = status;
        this.section = section;
        this.customer = customer;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
