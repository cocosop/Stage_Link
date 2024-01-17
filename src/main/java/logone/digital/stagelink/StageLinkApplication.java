package logone.digital.stagelink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StageLinkApplication {

	public static void main(String[] args) {
		//commentaire
		SpringApplication.run(StageLinkApplication.class, args);

//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String password = "password";
//		String encodedPassword = passwordEncoder.encode(password);
//
//		System.out.println();
//		System.out.println("Password is         : " + password);
//		System.out.println("Encoded Password is : " + encodedPassword);
//		System.out.println();
//
//
//		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
//		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);


	}


}
