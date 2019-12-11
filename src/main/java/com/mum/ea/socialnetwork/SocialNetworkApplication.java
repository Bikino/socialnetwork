package com.mum.ea.socialnetwork;

import com.mum.ea.socialnetwork.controller.UploadImageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
//@ComponentScan("com.mum.ea.socialnetwork")
public class SocialNetworkApplication {

	public static void main(String[] args) {

//		new File(UploadImageController.uploadDirectory).mkdir();
		SpringApplication.run(SocialNetworkApplication.class, args);
	}

}
