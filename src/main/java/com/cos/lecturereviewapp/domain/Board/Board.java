package com.cos.lecturereviewapp.domain.Board;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.cos.lecturereviewapp.domain.review.Review;
import com.cos.lecturereviewapp.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // PK
	
	@Column(nullable = false, length = 50)
	private String filename;
	
	@Column(nullable = false, length = 50)
	private String title;

	@Column(nullable = false, length = 50)
	private String teacher;

	@Column(nullable = false, length = 50)
	private String employment;

	@Column(nullable = false, length = 50)
	private String program;

	@Lob
	private String intro;

	@Lob
	private String curriculum1;

	@Lob
	private String curriculum2;

	@Lob
	private String curriculum3;

	@Lob
	private String curriculum4;

	@Lob
	private String curriculum5;

	@JoinColumn(name = "userId")
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@JsonIgnoreProperties({"board"})
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	@OrderBy("id desc")
	private List<Review> reviews;
	
	@Transient
	private int ratingmin;
	
	private LocalDateTime createdAt;

	@PrePersist // 디비에 INSERT 되기 직전에 실행
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

}
