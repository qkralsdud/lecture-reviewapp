package com.cos.lecturereviewapp.service.board;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.cos.lecturereviewapp.domain.Board.Board;
import com.cos.lecturereviewapp.domain.Board.BoardRepository;
import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.handler.ex.MyAsyncNotFoundException;
import com.cos.lecturereviewapp.handler.ex.MyNotFoundException;
import com.cos.lecturereviewapp.web.dto.BoardSaveDto;
import com.cos.lecturereviewapp.web.dto.ReviewSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service 
public class BoardServiceImpl implements BoardService{

	private final BoardRepository boardRepository;
	
	// 강의삭제
	@Transactional(rollbackFor = MyAsyncNotFoundException.class)
	public void  boardDelete(int id, User principal) {
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow(() -> new MyAsyncNotFoundException("해당강의를 찾을 수 없습니다."));

		if (principal.getId() != boardEntity.getUser().getId()) {
			throw new MyAsyncNotFoundException("삭제할 권한이 없습니다.");
		}

		try {
			boardRepository.deleteById(id); // 오류 발생??? (id가 없으면)
		} catch (Exception e) {
			throw new MyAsyncNotFoundException(id + "를 찾을 수 없어서 삭제할 수 없어요.");
		}
	}
	
	// 강의 등록
	@Transactional(rollbackFor = MyAsyncNotFoundException.class)
	@Override
	public void boardSave (BoardSaveDto dto, User principal) {
		boardRepository.save(dto.toEntity(principal));
	}
	
	// detail 
	@Override
	public Board  boardDetail(int id) {
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow(()-> new MyAsyncNotFoundException(id + "해당 강의를 찾을 수 없습니다."));
		return boardEntity;
	}
	
	// list
	public List<Board> boardList(Model model) {
		List<Board> boardsEntity = boardRepository.findAll();
		return boardsEntity;
	}
	
	//
	@Transactional(rollbackFor = MyAsyncNotFoundException.class)
	@Override
	public int avgRating(int id, ReviewSaveReqDto dto) {
		
						
		return boardRepository.ratingmin(dto.getRating());
	}
	
}