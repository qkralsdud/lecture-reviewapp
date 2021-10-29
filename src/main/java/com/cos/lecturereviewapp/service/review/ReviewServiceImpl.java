package com.cos.lecturereviewapp.service.review;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.lecturereviewapp.domain.Board.Board;
import com.cos.lecturereviewapp.domain.Board.BoardRepository;
import com.cos.lecturereviewapp.domain.review.Review;
import com.cos.lecturereviewapp.domain.review.ReviewRepository;
import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.handler.ex.MyNotFoundException;
import com.cos.lecturereviewapp.web.dto.ReviewSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService{

	private final ReviewRepository reviewRepository;
	private final BoardRepository boardRepository;
	
	@Transactional(rollbackFor = MyNotFoundException.class)
	@Override
	public void reviewReg(int boardId, ReviewSaveReqDto dto, User principal) {
		Board boardEntity = boardRepository.findById(boardId)
				.orElseThrow(() -> new MyNotFoundException("해당 게시글을 찾을 수 없습니다."));
		Review review = new Review();
		review.setTitle(dto.getTitle());
		review.setContent(dto.getContent());
		review.setRating(dto.getRating());
		review.setUser(principal);
		review.setBoard(boardEntity);
		
		reviewRepository.save(review);
	}
	

}
