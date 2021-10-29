package com.cos.lecturereviewapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	private final HttpSession session;
	
	// 영재 - 회원 탈퇴 @DeleteMapping("/user/{id}")
	
	// 영재 - 회원 탈퇴 페이지 이동 @GetMapping("/deleteForm") return "user/deleteForm";
	
	// 영재 - 회원 수정 @PutMapping("/user/{id}") 
	
	// 영재 - 회원 수정 페이지 이동 @GetMapping("/user/{id}")  return "user/updateForm";
	
	// 영재 - 로그아웃 @GetMapping("/logout")
	
	// 영재 - 로그인 @PostMapping("/login")
	
	// 영재 - 회원가입  @PostMapping("/join")
	
	// 영재 - 로그인 페이지 이동 @GetMapping("/loginForm") return "user/loginForm";
	
	// 영재 - 회원가입페이지 이동 @GetMapping("/joinForm") return "user/joinForm";
	

}
