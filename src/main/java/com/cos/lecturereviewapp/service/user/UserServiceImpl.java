package com.cos.lecturereviewapp.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.domain.user.UserRepository;
import com.cos.lecturereviewapp.handler.ex.MyNotFoundException;
import com.cos.lecturereviewapp.util.MyAlgorithm;
import com.cos.lecturereviewapp.util.SHA;
import com.cos.lecturereviewapp.web.dto.JoinReqDto;
import com.cos.lecturereviewapp.web.dto.LoginReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	public void userUpdate(User principal, UserUpdateDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(rollbackFor = MyNotFoundException.class)
	public void userJoin(JoinReqDto dto) {
		String encPassword = SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256);
		dto.setPassword(encPassword);
		userRepository.save(dto.toEntity());
	
		
	}

	@Override
	public void userDeleteById(int id, User principal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User userLogin(LoginReqDto dto) {
		return userRepository.mLogin(dto.getUsername(), SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256));
	}

}
