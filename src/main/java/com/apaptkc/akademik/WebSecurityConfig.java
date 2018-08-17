package com.apaptkc.akademik;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/css/*").permitAll()
				.antMatchers("/img/*").permitAll()
				.antMatchers("/js/*").permitAll()
				.antMatchers("/portal/**").permitAll()
				.antMatchers("/rest/**").permitAll()
				.antMatchers("/mahasiswa/**").hasAuthority("USER")
				.antMatchers("/dashboard/**").hasAuthority("ADMIN")
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll();
    }

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select username, password, enabled from akun where username=?")
				.authoritiesByUsernameQuery(
						"select username, role from akun_roles where username=?");

	}
}
