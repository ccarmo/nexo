package br.com.devs.Nexo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Classe utilizada para criptografia da senha digitada pelo usuário.
 * 
 * @since 1.0
 * @author Felipe Gusstavo.
 */

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	private @Autowired UserDetailsServiceImplements service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
		auth.inMemoryAuthentication().withUser("root").password(passwordEncoder().encode("root"))
				.authorities("ROLE_USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/usuario/cadastrar").permitAll()
				.antMatchers(HttpMethod.PUT, "/usuario/entrar").permitAll().anyRequest().authenticated().and()
				.httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.cors().and().csrf().disable();
	}
}
