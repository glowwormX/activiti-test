package cn.echaincity.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import({ActivitiConfig.class})
public class AcitivitiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcitivitiDemoApplication.class, args);
    }
}
