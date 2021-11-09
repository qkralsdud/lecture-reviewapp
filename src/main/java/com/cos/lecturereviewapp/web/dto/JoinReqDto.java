package com.cos.lecturereviewapp.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.lecturereviewapp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinReqDto {
	@Size(min = 6, max = 20)
	@NotBlank
	private String username;
	
	@Size(min = 4, max = 20)
	@NotBlank
	private String password;
	
	@Size(min = 4, max = 50)
	@NotBlank
	private String email;
	
	@Size(min = 2, max= 30)
	@NotBlank
	private String name;

	@Size(min = 8, max= 30)
	@NotBlank
	private String phone;

	
	public User toEntity() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setName(name);
		user.setPhone(phone);
		return user;
	}
}



