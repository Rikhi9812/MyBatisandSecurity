package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;
	

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests()
				.antMatchers("/", "/home/", "/shop/**", "/forgotPassword", "/register", "/product/**", "/addProduct").permitAll()

				.antMatchers("/admin/**").hasAuthority("ADMIN").antMatchers("/cart", "/addCart/**")
				.hasAnyAuthority("ADMIN", "USER").anyRequest().authenticated()

				.and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/").failureUrl("/login?error=true").and()
				.logout().deleteCookies("remove").logoutRequestMatcher(new AntPathRequestMatcher("/loginout"))
				.and().csrf().disable();

		return http.build();

	}
	
	
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/resources/**", "/static/**", "/images/**", "/productImages/**",
				"/css/**", "/js/**");
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailServiceImpl);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

}
