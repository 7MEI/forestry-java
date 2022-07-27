package com.lym;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//找到mapper包
@MapperScan("com/lym/system/mapper")
//开启Swagger
@EnableSwagger2
public class ForestryWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForestryWebApplication.class,args);
    }


}
