package com.christinap.notesappbe.service;

import com.christinap.notesappbe.model.user.UserRequest;
import com.christinap.notesappbe.model.user.UserResponse;

public interface UserService {
    UserResponse getUsername(Integer id);
}
