package com.example.demojpa.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@SpringBootConfiguration
@ComponentScan(basePackages={"com.example.demojpa"})
public class SpringConfig {
//xml:<bean id="" class="org.springframework.web.servlet.config.annotation.WebMvcConfigurer"/>
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        //WebMvcConfigurerAdapter  implements WebMvcConfigurer  --->addCorsMappings
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 限制了路径和域名的访问
                registry.addMapping("/**")
                //授权访问的前端地址
                .allowedOrigins("http://localhost:8080")
                //设置允许访访问 的方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                //设置允许的header
                .allowedHeaders("*")
                 //是否允许证书
                .allowCredentials(true);
            }
        };
    }
}
