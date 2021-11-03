package com.cos.lecturereviewapp.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.handler.ex.MyAsyncNotFoundException;
import com.cos.lecturereviewapp.service.user.UserServiceImpl;
import com.cos.lecturereviewapp.util.Script;
import com.cos.lecturereviewapp.web.dto.CMRespDto;
import com.cos.lecturereviewapp.web.dto.JoinReqDto;
import com.cos.lecturereviewapp.web.dto.LoginReqDto;
import com.cos.lecturereviewapp.web.dto.UserDeleteDto;
import com.cos.lecturereviewapp.web.dto.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	private final UserServiceImpl userServiceImpl;
	private final HttpSession session;
	
	// 영재 - 회원 탈퇴 @DeleteMapping("/user/{id}")
	@DeleteMapping("/user/{id}")
	public @ResponseBody CMRespDto<String> userDelete(@PathVariable int id) {


		// 인증
		User principal = (User) session.getAttribute("principal");

		
		userServiceImpl.userDelete(id, principal );
		

		return new CMRespDto<>(1, "성공", null);
	}
	
	// 영재 - 회원 탈퇴 페이지 이동 @GetMapping("/deleteForm") return "user/deleteForm";
	@GetMapping("/deleteForm/{id}")
	public String deleteForm(@PathVariable int id) {
	
		return "user/deleteForm";
	}
	
	
	// 영재 - 회원 수정 @PutMapping("/user/{id}")  
	@PutMapping("/user/{id}")
	public @ResponseBody CMRespDto<String> userUpdate(@PathVariable int id, @Valid @RequestBody UserUpdateDto dto,
			BindingResult bindingResult) {
		// 유효성
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			throw new MyAsyncNotFoundException(errorMap.toString());
		}

		// 인증
		User principal = (User) session.getAttribute("principal");

		// 권한
		if (principal.getId() != id) {
			throw new MyAsyncNotFoundException("회원정보를 수정할 권한이 없습니다.");
		}
		
		userServiceImpl.userUpdate(principal, dto);
		
		// 세션 동기화 해주는 부분
		principal.setEmail(dto.getEmail());
		principal.setPhone(dto.getPhone());
		principal.setPassword(dto.getPassword());
		session.setAttribute("principal", principal); // 세션 값 변경

		return new CMRespDto<>(1, "성공", null);
	}
	
	// 영재 - 회원 수정 페이지 이동 @GetMapping("/user/{id}")  return "user/updateForm";
	
	@GetMapping("/user/{id}")
	public String userInfo(@PathVariable int id) {
		// 기본은 userRepository.findById(id) 디비에서 가져와야 함.
		// 편법은 세션값을 가져올 수도 있다.
		
		return "user/updateForm";
	}
	
	// 영재 - 로그아웃 @GetMapping("/logout")
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // 세션 무효화 (jsessionId에 있는 값을 비우는 것)
		return "redirect:/"; 
	}
	
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
