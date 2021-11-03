package com.cos.lecturereviewapp.web.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDeleteDto {
	@NotBlank
	private String password;

	private String username;
	
}
