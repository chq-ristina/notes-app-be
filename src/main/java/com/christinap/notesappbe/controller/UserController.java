package com.christinap.notesappbe.controller;

import com.christinap.notesappbe.model.user.UserRequest;
import com.christinap.notesappbe.model.user.UserResponse;
import com.christinap.notesappbe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;

    @GetMapping("/get-username")
    public ResponseEntity<UserResponse> getUsername(
            @RequestParam("id")Integer id
            ){
        return ResponseEntity.ok(userService.getUsername(id));
    }
}
