package com.jb.user.controller;

import com.jb.user.dto.UserResponse;
import com.jb.user.model.SchoolUser;
import com.jb.user.service.SchoolUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final SchoolUserService userService;

    @Autowired
    public UserController(SchoolUserService schoolUserService) {
        this.userService = schoolUserService;
    }

    @PostMapping
    public ResponseEntity<SchoolUser> save(@RequestBody SchoolUser user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<SchoolUser>> findAll() {
        return ResponseEntity.ok(userService.getSchoolUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getSchoolUser(id));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam String id) {
        userService.deleteSchoolUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
