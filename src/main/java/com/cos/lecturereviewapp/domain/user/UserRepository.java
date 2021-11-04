package com.cos.lecturereviewapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "insert into user (username, password, email, phone) values (:username, :password, :email, :phone)", nativeQuery = true)
	void join(String username, String password, String email, String phone);
	
	@Query(value = "select * from user where username= :username and password= :password", nativeQuery = true)
	User mLogin(String username, String password);
	
	@Modifying
	@Query(value = "delete from user where username= :username and password= :password", nativeQuery = true)
	int uDelete(String username, String password);
}
