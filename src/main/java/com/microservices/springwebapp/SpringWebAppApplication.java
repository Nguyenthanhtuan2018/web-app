package com.microservices.springwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.microservices.springwebapp.dao.UserDao;
import com.microservices.springwebapp.entity.UserEntity;

@SpringBootApplication
@ComponentScan({"spring","com.microservices.springwebapp"})
public class SpringWebAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringWebAppApplication.class, args);
	}
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
    UserDao userDao;
	
	@Override
    public void run(String... args) throws Exception {
        // Khi chương trình chạy
        // Insert vào csdl một user.
        UserEntity user = new UserEntity();
        user.setUsername("loda");
        user.setPassword(passwordEncoder.encode("loda"));
        userDao.save(user);
        System.out.println(user);
    }

}
