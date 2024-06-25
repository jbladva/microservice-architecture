package com.jb.user.dto;

import com.jb.user.model.School;
import com.jb.user.model.SchoolUser;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private SchoolUser schoolUser;
    private School school;
}
