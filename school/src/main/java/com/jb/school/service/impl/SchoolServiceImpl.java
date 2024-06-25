package com.jb.school.service.impl;

import com.jb.school.exception.SchoolNotFoundException;
import com.jb.school.model.School;
import com.jb.school.repository.SchoolRepository;
import com.jb.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElseThrow(() ->
                new SchoolNotFoundException(String.format("School not found for id %s", id)));
    }

    @Override
    public void deleteSchoolById(Long id) {
        schoolRepository.deleteById(id);
    }
}
