package com.cos.lecturereviewapp.service.board;

import org.springframework.ui.Model;

import com.cos.lecturereviewapp.domain.Board.Board;
import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.web.dto.BoardSaveDto;
import com.cos.lecturereviewapp.web.dto.ReviewSaveReqDto;

public interface BoardService {
	void boardDelete(int id, User principal);
	
	Board  boardDetail(int id);
	
	void boardSave(BoardSaveDto dto, User principal);

	int avgRating(int id, ReviewSaveReqDto dto);


}
