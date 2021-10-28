package com.cos.lecturereviewapp.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class ReviewSaveReqDto {
	@Size(min = 1, max = 50)
	@NotBlank
	private String title;
	
	@NotBlank
	private String rating;
	
	@NotBlank
	@Size(min = 1, max = 255)
	private String content;
}
