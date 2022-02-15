package com.reancloud.platform.feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableFeignClients("com.reancloud.platform")
@ComponentScan("com.reancloud.platform")
public class FeignClientApplication {
//	@Autowired
//	CidrManagerClient cidrManagerClient;

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
		
	}

}
