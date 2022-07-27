package com.lym;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

//Property 'sqlSessionFactory' or 'sqlSessionTemplate' are requiredexclude = {DataSourceAutoConfiguration.class}
@SpringBootApplication
public class MailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class,args);
    }
@Bean
    public Queue queue(){
        return new Queue("mail.welcome");
}

}
