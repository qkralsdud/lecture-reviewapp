package com.cos.lecturereviewapp.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControllerTest {
	// 유저 관련-------------------
	@GetMapping("/test/user/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	@GetMapping("/test/user/joinForm")
	public String joForm() {
		return "user/joinForm";
	}
	@GetMapping("/test/user/detail")
	public String userDetail() {
		return "user/detail";
	}
	@GetMapping("/test/user/updateForm")
	public String userUpdateForm() {
		return "user/updateForm";
	}
	@GetMapping("/test/user/deleteForm")
	public String userDeleteForm() {
		return "user/deleteForm";
	}

	//강의 부분---------------------------
	@GetMapping("/test/board/detail")
	public String detail() {
		return "board/detail";
	}
	@GetMapping("/test/board/list")
	public String list() {
		return "board/list";
	}
	@GetMapping("/test/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	@GetMapping("/test/board/updateForm")
	public String updateForm() {
		return "board/updateForm";
	}
	
	//리뷰------------------------------------
	@GetMapping("/test/board/reviewupdateForm")
	public String reviewupdateForm() {
		return "board/reviewupdateForm";
	}
	@GetMapping("/test/board/reviewsaveForm")
	public String reviewsaveForm() {
		return "board/reviewsaveForm";
	}

}
