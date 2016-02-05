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
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Uguudei
 */
@Transactional
public class WaiverDAO implements IWaiverDAO{
    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Waiver> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Waiver");
        return q.list();
    }
    
    @Override
    public void add(Waiver waiver) {
        sessionFactory.getCurrentSession().persist(waiver);
    }
    
    @Override
    public Waiver get(int id) {
        return (Waiver) sessionFactory.getCurrentSession().load(Waiver.class, id);
    }
    
    @Override
    public void update(int waiverId, Waiver waiver) {
        waiver.setId(waiverId);
        sessionFactory.getCurrentSession().merge(waiver);
    }
    
    @Override
    public void delete(int waiverId) {
        /*Query qr = sessionFactory.getCurrentSession().createQuery("delete from section_waiver where waiverList_id = :waiverId");
        qr.setParameter("waiverId", waiverId);*/
        Waiver w = get(waiverId);
        sessionFactory.getCurrentSession().delete(w);
    }
    
    @Override
    public Customer getCustomer(String username){
        Query qr = sessionFactory.getCurrentSession().createQuery("from Customer where username = :username");
        qr.setParameter("username", username);
        return (Customer) qr.list().get(0);
    }

    @Override
    public Section getSection(String name) {
        Query qr = sessionFactory.getCurrentSession().createQuery("from Section where sectionName = :name");
        qr.setParameter("name", name);
        return (Section) qr.list().get(0);
    }
}
