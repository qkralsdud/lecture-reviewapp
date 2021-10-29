package com.cos.lecturereviewapp.service.user;

import org.springframework.stereotype.Service;

import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl {

	private final UserRepository userRepository;

}
