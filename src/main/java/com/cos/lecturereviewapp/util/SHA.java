package com.cos.lecturereviewapp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {

	public static  String encrypt(String rawPassword, MyAlgorithm algorithm)  {
		// getInstance() = new를 한것을 계속 쓰라고(메모리에 떠있는거 사용)
		// 1. SHA256 함수를 가진 클래스 객체 가져오기
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm.getType());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// 2. 비밀번호 1234 -> SHA259 던지기
		md.update(rawPassword.getBytes());
		
		// 3. 암호화된 글자를 16진수로 변환(헥사코드)
		StringBuilder sb = new StringBuilder();
		for(Byte b : md.digest()) {
			sb.append(String.format("%02x", b));
		}		
		return sb.toString();
	}
}
