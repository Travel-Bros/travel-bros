package com.travelbros.travelbros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {

    // Bean to configure filter chain and set which pages must be authorized to view
//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/posts/create", "/posts/{id}/edit").authenticated()
//                .antMatchers("/", "/register", "/login", "/posts", "/posts/{id}").permitAll()
//                .and().formLogin().loginPage("/login").defaultSuccessUrl("/posts")
//                .and().logout()
//                .and().httpBasic();
//
//        return http.build();
//    }
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/login", "/", "/register").permitAll()
                .antMatchers("/dashboard", "/allUsers", "/profile","/dashboard", "/trips", "/trips/create", "/trips/testing", "/vehicles/create", "/trips/{id}/edit").authenticated()
                // sets the url success page
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/dashboard")
//                .and().logout().logoutSuccessUrl("/splash?logout")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/?logout").deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .and().httpBasic();
        return http.build();
    }

    // Bean to hash return password encoder to hash password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}


