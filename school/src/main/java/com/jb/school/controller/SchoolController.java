package com.jb.school.controller;

import com.jb.school.model.School;
import com.jb.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("school")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<School> saveSchool(@RequestBody School school) {
        return ResponseEntity.ok(schoolService.save(school));
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @GetMapping("{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        return ResponseEntity.ok(schoolService.getSchoolById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteSchoolById(@RequestParam Long id) {
        schoolService.deleteSchoolById(id);
        return ResponseEntity.ok("School deleted successfully");
    }
}
