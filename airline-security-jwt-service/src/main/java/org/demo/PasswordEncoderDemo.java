package org.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderDemo {

	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String[] pwds = {"admin@123", "user@123"};
		for(String pwd: pwds) {			
			String encodedStr = encoder.encode(pwd);
			System.out.println("Password: "+pwd+", Encoded: "+encodedStr);
		}
	}
	
}
