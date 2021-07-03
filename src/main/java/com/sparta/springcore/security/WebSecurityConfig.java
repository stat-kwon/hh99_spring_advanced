package com.sparta.springcore.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

        // 로그인 기능 상세 설정을 해주는 것것 
       http.authorizeRequests()
                .anyRequest().authenticated()                // 어떠한 요청이 오든지 로그인이 필요하다.

                .and()

                .formLogin()         // 하지만 로그인 페이지에 대해서는 permitAll을 해줘야하고 로그인이 완료되었을 때 이동할 위치도 알려줌
                .defaultSuccessUrl("/")
                .permitAll()

                .and()

                .logout()   //로그아웃 기능도 permitAll로 해줌
                .permitAll();
    }
}

