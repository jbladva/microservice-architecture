package com.jb.user.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "school-user")
public class SchoolUser {

    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String age;
    private String gender;
    private Long schoolId;
}
