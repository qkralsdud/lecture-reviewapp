package com.cos.lecturereviewapp.service.board;

import com.cos.lecturereviewapp.domain.Board.Board;
import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.web.dto.BoardSaveDto;

public interface BoardService {
	void boardDelete(int id, User principal);
	
	Board  boardDetail(int id);
	
	void boardSave(BoardSaveDto dto, User principal);

}
