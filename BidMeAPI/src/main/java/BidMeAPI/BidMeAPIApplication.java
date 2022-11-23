package BidMeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-beans.xml")
public class BidMeAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidMeAPIApplication.class, args);
	}

}