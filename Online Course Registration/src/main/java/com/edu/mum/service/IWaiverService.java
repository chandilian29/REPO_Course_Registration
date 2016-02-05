/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.service;

import com.edu.mum.dao.ICustomerDAO;
import com.edu.mum.dao.IWaiverDAO;
import com.edu.mum.dao.SectionDao;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Section;
import com.mum.edu.domain.Waiver;

/**
 *
 * @author Uguudei
 */
public interface IWaiverService {
    public Customer getCustomer(String username);
    public Section getSection(String name);
    public void setWaiverDAO(IWaiverDAO waiverDAO);
    public Waiver createRequestWaiver(Customer customer, Waiver waiver, Section section);
    public boolean isWaiverSelectedBefore(Customer customer, Waiver waiver);
    public void deleteWaiver(int id);
    public void deleteWaiver(Section section, Waiver waiver, SectionDao sectionDao, ICustomerDAO customerDAO, Customer customer);
    public Waiver getWaiverById(int id);
}
