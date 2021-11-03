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

	
	@Override
	@Transactional(rollbackFor = MyAsyncNotFoundException.class)
	public void userDelete(int id, User principal) {
		User userEntity = userRepository.findById(id).orElseThrow(() -> new MyAsyncNotFoundException("해당 계정을 찾을 수 없습니다."));
		
		String encPassword = SHA.encrypt(principal.getPassword(), MyAlgorithm.SHA256);
		
		if (encPassword != userEntity.getPassword()) {
		throw new MyAsyncNotFoundException("해당 계정을 삭제할 권한이 없습니다.");
				}

		try {
		userRepository.deleteById(id); // 오류 발생??? (id가 없으면)} catch (Exception e) {
		throw new MyAsyncNotFoundException(id + "를 찾을 수 없어서 삭제할 수 없어요.");
				}catch (Exception e) {
					throw new MyAsyncNotFoundException(id + "를 찾을 수 없어서 삭제할 수 없어요.");
				}
		
	}

	@Override
	public User userLogin(LoginReqDto dto) {
		return userRepository.mLogin(dto.getUsername(), SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256));
	}

}
