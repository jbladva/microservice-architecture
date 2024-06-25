package com.jb.user.service.impl;

import com.jb.user.dto.UserResponse;
import com.jb.user.model.School;
import com.jb.user.model.SchoolUser;
import com.jb.user.repository.SchoolUserRepository;
import com.jb.user.service.SchoolUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
@Slf4j
public class SchoolUserServiceImpl implements SchoolUserService {

    private final SchoolUserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    SchoolUserServiceImpl(SchoolUserRepository schoolUserRepository, RestTemplate restTemplate){
        this.userRepository = schoolUserRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public SchoolUser save(SchoolUser schoolUser) {
        return userRepository.save(schoolUser);
    }

    @Override
    public List<SchoolUser> getSchoolUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse getSchoolUser(String id) {
        SchoolUser schoolUser = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("School user with id %s not found", id)));
        return UserResponse.builder()
                .schoolUser(schoolUser)
                .school(getSchool(schoolUser.getSchoolId()))
                .build();
    }

    @Override
    public void deleteSchoolUser(String id) {
        userRepository.deleteById(id);
    }

    private School getSchool(Long id) {
        School school = null;
        try {
            school = restTemplate.getForObject("http://school-service/school/" + id, School.class);
        } catch (Exception e){
            log.error("School user with id {} not found", id);
            log.error(e.getMessage());
        }
        return school;
    }
}
