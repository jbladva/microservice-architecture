package com.jb.school.service;

import com.jb.school.model.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolService {

    School save(School school);
    List<School> getAllSchools();
    School getSchoolById(Long id);
    void deleteSchoolById(Long id);
}
