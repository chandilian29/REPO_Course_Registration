/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.dao;

import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Section;
import com.mum.edu.domain.Waiver;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Uguudei
 */
public interface IWaiverDAO {
    public void setSessionFactory(SessionFactory sessionFactory);
    public List<Waiver> getAll();
    public void add(Waiver waiver);
    public Waiver get(int id);
    public void update(int waiverId, Waiver waiver);
    public void delete(int waiverId);
    public Customer getCustomer(String username);
    public Section getSection(String name);
}
