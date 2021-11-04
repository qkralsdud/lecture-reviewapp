package com.cos.lecturereviewapp.service.user;

import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.web.dto.JoinReqDto;
import com.cos.lecturereviewapp.web.dto.LoginReqDto;
import com.cos.lecturereviewapp.web.dto.UserDeleteDto;
import com.cos.lecturereviewapp.web.dto.UserUpdateDto;

public interface UserService {
	void userUpdate(User principal, UserUpdateDto dto);
	
	void userJoin(JoinReqDto dto);
	
<<<<<<< HEAD
	User userDelete( LoginReqDto dto);
=======
	int userDelete( LoginReqDto dto);
>>>>>>> 정영재

	User userLogin(LoginReqDto dto);

}
