package com.laine.projekti;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Crypt {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("salasana"));
	}
}  