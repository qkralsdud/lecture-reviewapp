package com.cos.lecturereviewapp.domain.review;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.cos.lecturereviewapp.domain.Board.Board;
import com.cos.lecturereviewapp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Review {
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
	private int id; // PK(자동증가 번호)

	private String title;

	private String rating;

	private String content;

	@JoinColumn(name = "userId")
	@ManyToOne
	private User user;

	@JoinColumn(name = "boardId")
	@ManyToOne
	private Board board;

	private LocalDateTime createdAt;

	@PrePersist // 디비에 INSERT 되기 직전에 실행
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

}
