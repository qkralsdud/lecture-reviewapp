package com.cos.lecturereviewapp.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.domain.user.UserRepository;
import com.cos.lecturereviewapp.handler.ex.MyAsyncNotFoundException;
import com.cos.lecturereviewapp.handler.ex.MyNotFoundException;
import com.cos.lecturereviewapp.util.MyAlgorithm;
import com.cos.lecturereviewapp.util.SHA;
import com.cos.lecturereviewapp.web.dto.JoinReqDto;
import com.cos.lecturereviewapp.web.dto.LoginReqDto;
import com.cos.lecturereviewapp.web.dto.UserDeleteDto;
import com.cos.lecturereviewapp.web.dto.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	@Transactional(rollbackFor = MyAsyncNotFoundException.class)
	public void userUpdate(User principal, UserUpdateDto dto) {
		User userEntity = userRepository.findById(principal.getId())
				.orElseThrow(()-> new MyAsyncNotFoundException("회원정보를 찾을 수 없습니다."));
		String encPassword = SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256);
		userEntity.setEmail(dto.getEmail());
		userEntity.setPhone(dto.getPhone());
		userEntity.setPassword(encPassword);
		
	}

	@Override
	@Transactional(rollbackFor = MyNotFoundException.class)
	public void userJoin(JoinReqDto dto) {
		String encPassword = SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256);
		dto.setPassword(encPassword);
		userRepository.save(dto.toEntity());
	
		
	}	

	@Transactional
	@Override
	public int userDelete(LoginReqDto dto) {
		

		/*
		 * String encPassword = SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256);
		 * System.out.println(dto.getUsername()); System.out.println(encPassword);
		 * return userRepository.uDelete(dto.getUsername(), encPassword);
		 */
		return userRepository.uDelete(dto.getUsername(), SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256));
		
	}

	@Override
	public User userLogin(LoginReqDto dto) {
		return userRepository.mLogin(dto.getUsername(), SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256));
	}

}
