package com.cos.lecturereviewapp.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO = Data Transfer Object (데이터 전송 오브젝트)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqDto {
	@Size(min = 6, max = 20)
	@NotBlank
	private String username;
	@Size(min = 4, max = 20)
	@NotBlank
	private String password;
}
