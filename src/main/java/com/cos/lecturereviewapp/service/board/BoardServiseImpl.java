package com.cos.lecturereviewapp.service.board;

import org.springframework.stereotype.Service;

import com.cos.lecturereviewapp.domain.Board.Board;
import com.cos.lecturereviewapp.domain.Board.BoardRepository;
import com.cos.lecturereviewapp.domain.review.ReviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service 
public class BoardServiseImpl{

	private final BoardRepository boardRepository;
	private final ReviewRepository reviewRepository;
	

}
