package com.sap.refapps.espm.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("local")
@EnableWebSecurity
@EnableAutoConfiguration
public class DefaultSecurityConfig {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf(csrf -> (csrf).disable()).authorizeHttpRequests(auth ->(auth).anyRequest().permitAll());
		return http.build();
	}
}
