package com.rent.carrenting.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/dashboards/admin").hasRole("ADMIN")
                //.antMatchers("/dashboards/admin").hasRole("RECEPTIONIST")
                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/index").permitAll()
                .antMatchers("/users/create").permitAll()
                .antMatchers("/users/register").permitAll()
                .antMatchers("/users/feedback").permitAll()
                .antMatchers("/layout").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/static/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                //.loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/index", true)
                //.failureUrl("/login.html?error=true")
                //.failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                //.logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID");
        //.logoutSuccessHandler(logoutSuccessHandler());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

