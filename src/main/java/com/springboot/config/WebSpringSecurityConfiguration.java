package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSpringSecurityConfiguration {

	@Bean
	static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						(authorize) -> authorize.requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
								.requestMatchers(new AntPathRequestMatcher("/register/**")).permitAll()
								.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
								.requestMatchers(new AntPathRequestMatcher("/admin/**")).hasAnyRole("ADMIN", "GUEST")
								.requestMatchers(new AntPathRequestMatcher("/")).permitAll()
								.requestMatchers(new AntPathRequestMatcher("/post/**")).permitAll().anyRequest()
								.authenticated())
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/admin/posts")
						.loginProcessingUrl("/login").permitAll())
				.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
		return http.build();
	}

}
