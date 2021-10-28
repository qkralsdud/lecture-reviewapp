package com.cos.lecturereviewapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cos.lecturereviewapp.service.BoardService;
import com.cos.lecturereviewapp.service.ReviewService;
import com.cos.lecturereviewapp.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	private final ReviewService reviewService;
	private final BoardService boardService;
	private final HttpSession session;
	
	// 주완 - 강의 삭제 @DeleteMapping("/board/{id}")
	
	// 주완 - 강의 상세보기 @GetMapping("/board/{id}") return "board/detail"
	
	// 주완 - 강의 리스트(메인) 페이지 이동 @GetMapping("/board/list")
	@GetMapping("/")
	public String home() {
		return "board/list";
	}
	// 주완 - 강의 등록 @PostMapping("/board") 
	
	// 주완 - 강의 등록 페이지 이동 @GetMapping("/board/saveForm")
	
	//민영 - 리뷰 수정 @PutMapping("/board/{id}/review")

	//민영 - 리뷰 수정페이지 이동 @GetMapping("/board/reviewupdateForm")

	//민영 - 리뷰 등록 @PostMapping("/board/{boardId}/review")

	//민영 - 리뷰 쓰기페이지 이동 @GetMapping
	@GetMapping("/board/{boardId}/reviewsaveForm")
	public String reviewsaveForm() {
		return "board/reviewsaveForm";
	}
}
