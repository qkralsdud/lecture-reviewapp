package com.cos.lecturereviewapp.service.review;



import com.cos.lecturereviewapp.domain.review.Review;
import com.cos.lecturereviewapp.domain.user.User;
import com.cos.lecturereviewapp.web.dto.ReviewSaveReqDto;

public interface ReviewService {
	void reviewReg(int boardId, ReviewSaveReqDto dto, User principal);
	
	void reviewupdate(int id, ReviewSaveReqDto dto, User principal );
	
	Review reviewupdatepage(int id);

}
