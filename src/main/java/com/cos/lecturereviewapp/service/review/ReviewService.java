package com.cos.lecturereviewapp.service.review;



import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.web.dto.ReviewSaveReqDto;

public interface ReviewService {
	void reviewReg(int boardId, ReviewSaveReqDto dto, User principal);

}
