package com.escalade.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)

	{Process p;
//		try {
//		String[] cmd = { "sh", "/sudo service mysql start"};
//		p = Runtime.getRuntime().exec(cmd);
//
//			p.waitFor();
//		} catch (InterruptedException | IOException e) {
//			e.printStackTrace();
//		}

		SpringApplication.run(DemoApplication.class, args);
	}

}
