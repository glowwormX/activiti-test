package com.activiti;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author crh
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}, scanBasePackages = {"cn.echaincity.workflow", "com.activiti"})
@EnableSwagger2
public class VueActivitiServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueActivitiServiceDemoApplication.class, args);
	}

}
