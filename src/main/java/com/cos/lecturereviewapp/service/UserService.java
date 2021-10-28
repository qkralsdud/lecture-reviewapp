package com.cos.lecturereviewapp.service;

import org.springframework.stereotype.Service;

import com.cos.lecturereviewapp.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;

}
