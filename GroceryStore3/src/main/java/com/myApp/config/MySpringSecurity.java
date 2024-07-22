//default password for application is  : raju123
//User name is Raju

package com.myApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class MySpringSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSource myDataSource;
	
	//user authentication with JDBC template 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		                                           
		auth.jdbcAuthentication()
		.dataSource(myDataSource)
		.passwordEncoder(passwordEncoder);

	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
   
		http
		.authorizeRequests()	
		.antMatchers("/").authenticated()	
		.antMatchers("/userRegistration","/process-registration").permitAll()	
		.antMatchers("/about").hasAnyAuthority("Admin","User")
		.antMatchers("/createMenu").hasAuthority("Admin")	
		.antMatchers("/addItems").hasAuthority("Admin")
		.antMatchers("/add").hasAuthority("Admin")
		.antMatchers("/myContact").hasAnyAuthority("Admin","User")
		.antMatchers("/Menu").hasAnyAuthority("Admin","User")
		.antMatchers("/deleteItems/{item_id}").hasAuthority("Admin")
		.antMatchers("/editItems/{item_id}").hasAuthority("Admin")
		.antMatchers("/updateItems").hasAuthority("Admin")
		.antMatchers("/addToCart/{item_id}","/viewCart","/myCart","/deleteCartItems/{cart_id}").hasAnyAuthority("Admin","User")
		.antMatchers("/proceedToPayment","/paymentConfirmation").hasAnyAuthority("Admin","User")
		.antMatchers("/orderdItems").hasAnyAuthority("Admin","User")
		.antMatchers("/billing").hasAnyAuthority("Admin","User")
		.antMatchers("/downloadBill?order_id").hasAnyAuthority("Admin","User")
		.antMatchers("/myAppHomeMenu").hasAnyAuthority("Admin","User")
		.antMatchers("/resources/**", "/static/**", "/images/**").permitAll()
		.antMatchers("/changepassword","/updatePassword").hasAnyAuthority("Admin","User")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/myLoginPage").loginProcessingUrl("/process-Log").permitAll()
		.and()
		.httpBasic()
		.and()
		.logout()
		.and()
		.exceptionHandling().accessDeniedPage("/restrict-access")
		.and()
		.csrf().disable();
		
		

	}
	
	
}
