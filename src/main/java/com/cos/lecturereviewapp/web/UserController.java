package com.cos.lecturereviewapp.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.service.user.UserServiceImpl;
import com.cos.lecturereviewapp.util.Script;
import com.cos.lecturereviewapp.web.dto.JoinReqDto;
import com.cos.lecturereviewapp.web.dto.LoginReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	private final UserServiceImpl userServiceImpl;
	private final HttpSession session;
	
	// 영재 - 회원 탈퇴 @DeleteMapping("/user/{id}")
	
	// 영재 - 회원 탈퇴 페이지 이동 @GetMapping("/deleteForm") return "user/deleteForm";
	
	// 영재 - 회원 수정 @PutMapping("/user/{id}") 
	
	// 영재 - 회원 수정 페이지 이동 @GetMapping("/user/{id}")  return "user/updateForm";
	
	// 영재 - 로그아웃 @GetMapping("/logout")
	
	// 영재 - 로그인 @PostMapping("/login")
	@PostMapping("/login")
	public @ResponseBody String login(@Valid LoginReqDto dto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return Script.back(errorMap.toString());
		}

		User userEntity =  userServiceImpl.userLogin(dto);

		if (userEntity == null) { // username, password 잘못 기입
			return Script.back("아이디 혹은 비밀번호를 잘못 입력하였습니다.");
		} else {
			// 세션 날라가는 조건 : 1. session.invalidate(), 2. 브라우저를 닫으면 날라감
			session.setAttribute("principal", userEntity);
			return Script.href("/", "로그인 성공");
		}
	}

	
	// 영재 - 회원가입  @PostMapping("/join")
	@PostMapping("/join")
	public @ResponseBody String join(@Valid JoinReqDto dto, BindingResult bindingResult) { // username=love&password=1234&email=love@nate.com

		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}

			return Script.back(errorMap.toString());
		}

		userServiceImpl.userJoin(dto);
		
		return Script.href("/loginForm"); // 리다이렉션 (300)
	}

	// 영재 - 로그인 페이지 이동 @GetMapping("/loginForm") return "user/loginForm";
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	// 영재 - 회원가입페이지 이동 @GetMapping("/joinForm") return "user/joinForm";
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}

}
