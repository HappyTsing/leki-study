package com.wang;


import org.springframework.context.annotation.*;

@Configuration
@Import(AppConfig2.class)
@ComponentScan(value = "com.wang")//设置要扫描的包
@PropertySource("classpath:name.properties") //指定properties文件的位置
public class AppConfig {

    @Bean
    public User myUser(){
        return new User();
    }
}
