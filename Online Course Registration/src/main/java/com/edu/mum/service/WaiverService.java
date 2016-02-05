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
import java.util.List;

/**
 *
 * @author Uguudei
 */
public class WaiverService implements IWaiverService{
    private IWaiverDAO waiverDAO;

    @Override
    public void setWaiverDAO(IWaiverDAO waiverDAO) {
        this.waiverDAO = waiverDAO;
    }
    
    @Override
    public Waiver createRequestWaiver(Customer customer, Waiver waiver, Section section){
        if(!isWaiverSelectedBefore(customer, waiver)){
            customer.addWaiver(waiver);
            waiver.setCustomer(customer);
            waiver.setSection(section);
            section.addWaiver(waiver);
            waiverDAO.add(waiver);
        }
        return waiver;
    }
    
    @Override
    public boolean isWaiverSelectedBefore(Customer customer, Waiver waiver){
        List<Waiver> waiverList = customer.getWaiverList();
        for (Waiver w : waiverList) {
            if (w.getStatus().equals(waiver.getStatus())) {
                return true;
            }         
        }
        return false;
    }
    
    @Override
    public Customer getCustomer(String username){
        return waiverDAO.getCustomer(username);
    }

    @Override
    public void deleteWaiver(int id) {        
       waiverDAO.delete(id);
    }

    @Override
    public Section getSection(String name) {
        return waiverDAO.getSection(name);
    }

    @Override
    public void deleteWaiver(Section section, Waiver waiver, SectionDao sectionDao, ICustomerDAO customerDAO, Customer customer) {
        section.removeWaiver(waiver);
        customer.removeWaiver(waiver);
        customerDAO.update(customer.getId(), customer);
        sectionDao.update(section.getId(), section);
    }
    
    @Override
    public Waiver getWaiverById(int id){
        return waiverDAO.get(id);
    }
    
}
