package com.cos.lecturereviewapp.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	
	@Query(value="select round(avg(rating), -1)  from review", nativeQuery = true)
	int ratingmin(String ratingmin);
}
