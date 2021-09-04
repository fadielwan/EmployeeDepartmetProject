package net.fadi.deptemp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

	auth.inMemoryAuthentication().withUser("manager").password("manager").roles("MANAGER");
	auth.inMemoryAuthentication().withUser("employee").password("employee").roles("EMPLOYEE");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests().
        antMatchers("/", "/main").access("hasAnyRole('ROLE_MANAGER','ROLE_EMPLOYEE')")
        .antMatchers("/manageEmp", "/manageDept", "/addDept","/addEmp","/addProject","/manageProject").access("hasRole('ROLE_MANAGER')")
            .and()
        .formLogin().loginPage("/login").and().exceptionHandling().accessDeniedPage("/deny");
	}

}
