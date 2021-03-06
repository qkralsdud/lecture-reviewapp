package com.cos.lecturereviewapp.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.lecturereviewapp.domain.Board.Board;
import com.cos.lecturereviewapp.domain.Board.BoardRepository;
import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.handler.ex.MyAsyncNotFoundException;
import com.cos.lecturereviewapp.service.board.BoardServiceImpl;
import com.cos.lecturereviewapp.service.review.ReviewServiceImpl;
import com.cos.lecturereviewapp.util.Script;
import com.cos.lecturereviewapp.web.dto.BoardSaveDto;
import com.cos.lecturereviewapp.web.dto.CMRespDto;
import com.cos.lecturereviewapp.web.dto.ReviewSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	private final ReviewServiceImpl reviewServiceimpl;
	private final HttpSession session;
	//
	private final BoardServiceImpl boardService;
	//
	private final BoardRepository boardRepository;
	
	// 주완 - 강의 삭제 @DeleteMapping("/board/{id}")
	@DeleteMapping("/board/{id}")
	public @ResponseBody CMRespDto<String> deleteById(@PathVariable int id) {
		User principal = (User) session.getAttribute("principal");
		
		boardService.boardDelete(id, principal);
	
		return new CMRespDto<String>(1, "성공", null);
	}
	
	// 주완 - 강의 상세보기 @GetMapping("/board/{id}") return "board/detail"
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("boardEntity", boardService.boardDetail(id));	
		return "board/detail";
	}
	
	// 주완 - 강의 리스트(메인) 페이지 이동 @GetMapping("/board/list")
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("boardsEntity", boardService.boardList(model));
		return "board/list";
	}
	// 주완 - 강의 등록 @PostMapping("/board") 
	@PostMapping("/board")
	public @ResponseBody String boardSave(@Valid BoardSaveDto dto, BindingResult bindingResult) {
		User principal = (User) session.getAttribute("principal");

		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return Script.back(errorMap.toString());
		}
		boardService.boardSave(dto, principal);
		
		return Script.href("/", "강의 등록 완료");
	}
	// 주완 - 강의 등록 페이지 이동 @GetMapping("/board/saveForm")
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	//민영 - 리뷰 수정 @PutMapping("/board/{id}/review")
	@PutMapping("/board/{id}/reviewupdate")
	public @ResponseBody CMRespDto<String> reviewUpdate(@PathVariable int id,  @Valid @RequestBody ReviewSaveReqDto dto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {			
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			throw new MyAsyncNotFoundException(errorMap.toString());
		}
		
		User principal = (User) session.getAttribute("principal");
		reviewServiceimpl.reviewupdate(id, dto, principal);
		
		return new CMRespDto<>(1, "리뷰 업데이트 성공", null);
	}
	
	//민영 - 리뷰 수정페이지 이동 @GetMapping("/board/reviewupdateForm")
	@GetMapping("/board/{id}/reviewupdateForm")
	public String reviewupdateForm(@PathVariable int id, Model model) {
		model.addAttribute("reviewEntity", reviewServiceimpl.reviewupdatepage(id));
		//model.addAttribute("boardEntity", boardService.boardDetail(id));
		return "board/reviewupdateForm";
	}
	
	//민영 - 리뷰 등록 @PostMapping("/board/{boardId}/review")
	@PostMapping("/board/{boardId}/review")
	public String review(@PathVariable int boardId, ReviewSaveReqDto dto, Model model) {
		
		User principal = (User) session.getAttribute("principal");
		
		dto.setContent(dto.getContent().replace("<p>", ""));
		dto.setContent(dto.getContent().replace("</p>", ""));
		dto.setContent(dto.getContent().replace("<br>", ""));
				
		reviewServiceimpl.reviewReg(boardId, dto, principal);
		
		model.addAttribute("boardEntity", boardService.avgRating(boardId, dto));	
		return "redirect:/board/"+boardId;
	}
	
	//민영 - 리뷰 쓰기페이지 이동 @GetMapping
	@GetMapping("/board/{boardId}/reviewsaveForm")
	public String reviewsaveForm(@PathVariable int boardId, Model model) {
		
		model.addAttribute("boardEntity", boardService.boardDetail(boardId));	
		return "board/reviewsaveForm";
	}
}