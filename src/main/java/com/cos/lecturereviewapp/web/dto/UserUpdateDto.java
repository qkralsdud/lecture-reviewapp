package com.cos.lecturereviewapp.web.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
	@NotBlank
	private String email;
<<<<<<< HEAD
	private String phone;
	private String password;
=======
	private String password;

>>>>>>> 정영재
	
}
