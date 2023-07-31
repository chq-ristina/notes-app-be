package com.christinap.notesappbe.service.impl;

import com.christinap.notesappbe.model.user.UserRequest;
import com.christinap.notesappbe.model.user.UserResponse;
import com.christinap.notesappbe.service.UserService;
import com.christinap.notesappbe.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserResponse getUsername(Integer id) {
        var user = userRepository.findById(id).orElseThrow();
        return UserResponse.builder()
                .username(user.getUserName())
                .build();
    }
}
