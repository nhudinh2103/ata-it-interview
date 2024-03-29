package com.ata.interview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 
 * @author dinhnn
 *
 */
@Configuration
public class SecurityConfig {
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
	}
	
	/**
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf((csrf) -> csrf.disable()).cors(Customizer.withDefaults())
				.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests.anyRequest().permitAll());
		
		return http.build();
	}

}
