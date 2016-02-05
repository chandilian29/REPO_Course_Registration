/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.edu.mum.dao.SectionDao;
import com.mum.edu.domain.Faculty;
import com.mum.edu.domain.Section;
import java.util.List;

/**
 *
 * @author pAlahakoon
 */
public class SectionServiceImpl implements SectionService {

    private SectionDao sectionDao;

    public SectionServiceImpl() {
    }

    public SectionServiceImpl(SectionDao sectionDao) {
        this.sectionDao = sectionDao;
    }

    @Override
    public void addSection(Section section) { 
        sectionDao.addSection(section);
    }

    @Override
    public Section addSection(int id,String sectionId, String sectionName, int noOfDays, int sectionSize) {  
        Section section = new Section(id,sectionId, sectionName, noOfDays, sectionSize);
        sectionDao.addSection(section);
        return section;
    }

    @Override
    public List<Section> getAll() {    
        return sectionDao.getAll();
    }

    @Override
    public Section get(int id) { 
        return sectionDao.get(id);
    }

    @Override
    public void update(int id, Section section) {  
        sectionDao.update(id, section);
    }

    @Override
    public void delete(int id) {   
        sectionDao.delete(id);
    }

    @Override
    public Section getSection(String sectionName) { 
        return sectionDao.getSection(sectionName);
    }

    @Override
    public Faculty getFacultyId(int id) { 
        return sectionDao.getFacultyId(id);
    }


    @Override
    public SectionDao getSectionDao() {
        return sectionDao;
    }

    

    @Override
    public List<Faculty> getAllFaculty() {
        return sectionDao.getAllFaculty();
    }

    @Override
    public Faculty getFacultybyFirstName(String firstName) {
        return sectionDao.getFacultybyFirstName(firstName);
    }

    @Override
    public void updateFaculty(int id, Section section) {
        sectionDao.updateFaculty(id, section);
    }


}
