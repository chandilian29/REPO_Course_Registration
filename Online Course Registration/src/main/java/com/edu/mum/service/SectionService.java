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
public interface SectionService {

    public void addSection(Section section);

    public Section addSection(int id,String sectionId, String sectionName, int noOfDays, int sectionSize);

    public List<Section> getAll();

    public Section get(int id);

    public void update(int id, Section section);
    
    public void updateFaculty(int id, Section section);

    public void delete(int id);

    public Section getSection(String sectionName);
    
    public Faculty getFacultyId(int id);

    
    public SectionDao getSectionDao(); 

    
    public List<Faculty> getAllFaculty();
    
    public Faculty getFacultybyFirstName(String firstName);


}
