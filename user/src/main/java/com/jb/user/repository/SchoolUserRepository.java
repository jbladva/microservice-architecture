package com.jb.user.repository;

import com.jb.user.model.SchoolUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolUserRepository extends MongoRepository<SchoolUser, String> {
}
