package com.jb.user.service;

import com.jb.user.dto.UserResponse;
import com.jb.user.model.SchoolUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolUserService {

    SchoolUser save(SchoolUser schoolUser);
    List<SchoolUser> getSchoolUsers();
    UserResponse getSchoolUser(String id);
    void deleteSchoolUser(String id);
}
