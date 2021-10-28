package com.cos.lecturereviewapp.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
	private int id; // PK(자동증가 번호)

	@Column(nullable = false, length = 20, unique = true)
	private String username; // 아이디

	@Column(nullable = false, length = 70)
	private String password;

	@Column(nullable = false, length = 10)
	private String name;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = false, length = 20)
	private String phone;

	private LocalDateTime createdAt;

	@PrePersist // 디비에 INSERT 되기 직전에 실행
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

}
