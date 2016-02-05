/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.test;
//import org.aspectj.weaver.ast.Test;
import com.edu.mum.dao.IYogaCourseDAO;
import com.mum.edu.domain.Course;
import com.mum.edu.domain.Section;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
//import org.junit.Test;

/**
 *
 * @author Yonas
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classPath:rootconfig.xml")
@Transactional
public class YogaClassDAOTest {

    @Autowired
    private IYogaCourseDAO YogaCourseDAO;

    @Test
    public void testGetAllSections() {
        Iterable<Section> sections = YogaCourseDAO.getAllSection();
        int size = 0;
        for (Section section : sections) {
            size++;
        }
       assertEquals(5, size);
    }

    @Test
    public void testSaveSite() {
        Iterable<Course> courses = YogaCourseDAO.getAllCourse();
        int size = 0;
        for (Course course : courses) {
            size++;
        }
        assertEquals(5, size);
    }
   
}
