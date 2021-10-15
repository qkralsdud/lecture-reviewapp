package com.cos.lecturereviewapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	//민영 - 리뷰 쓰기
	@GetMapping("/board/reviewsaveForm")
	public String reviewsaveForm() {
		return "board/reviewsaveForm";
	}
}
