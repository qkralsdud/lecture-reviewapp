package com.cos.lecturereviewapp.service.user;

import com.cos.lecturereviewapp.domain.user.User;

public interface UserService {
	void userUpdate(User principal, UserUpdateDto dto);
	
	void userJoin(JoinReqtDto dto);
	
	void userDeleteById(int id, User principal);

	User userLogin(LoginReqDto dto);
}
