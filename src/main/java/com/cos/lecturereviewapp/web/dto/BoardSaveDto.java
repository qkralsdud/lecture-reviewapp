package com.cos.lecturereviewapp.web.dto;

import com.cos.lecturereviewapp.domain.Board.Board;
import com.cos.lecturereviewapp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardSaveDto {
	
	// 사진
	private String filename;
	// 강의명
	private String title;
	// 강사명
	private String teacher;
	// 취업분야
	private String employment;
	// 프로그램
	private String program;
	// 강의소개
	private String Intro;
	// 커리큘럼 step1
	private String curriculum1;
	// 커리큘럼 step2
	private String curriculum2;
	// 커리큘럼 step3
	private String curriculum3;
	// 커리큘럼 step4
	private String curriculum4;
	// 커리큘럼 step5
	private String curriculum5;
	
	public Board toEntity(User principal) {
		Board board = new Board();
		board.setFilename(filename);
		board.setTitle(title);
		board.setTeacher(teacher);
		board.setEmployment(employment);
		board.setProgram(program);
		board.setIntro(Intro);
		board.setCurriculum1(curriculum1);
		board.setCurriculum2(curriculum2);
		board.setCurriculum3(curriculum3);
		board.setCurriculum4(curriculum4);
		board.setCurriculum5(curriculum5);
		return board;
	}
}
