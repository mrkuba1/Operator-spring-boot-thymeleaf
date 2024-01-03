package bdbt_project.SpringApplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails admin = User
				.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.authorities("ADMIN")
				.build();
		UserDetails user = User
				.withUsername("user")
				.password(passwordEncoder().encode("user"))
				.authorities("USER")
				.build();
		return new InMemoryUserDetailsManager(admin, user);
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeRequests()
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				.antMatchers("/user/operators/**").hasAuthority("USER")
				.antMatchers("/user/departments/**").hasAuthority("ADMIN")
				.antMatchers("/user/department/**").hasAuthority("ADMIN")
				.antMatchers("/user/customers/**").hasAuthority("ADMIN")
				.antMatchers("/user/customer/**").hasAuthority("ADMIN")
				.antMatchers("/user/senders/**").hasAuthority("ADMIN")
				.antMatchers("/user/sender/**").hasAuthority("ADMIN")
				.antMatchers("/user/offers/**").hasAuthority("ADMIN")
				.antMatchers("/user/offer/**").hasAuthority("ADMIN")
				.antMatchers("/user/employees/**").hasAuthority("ADMIN")
				.antMatchers("/user/employee/**").hasAuthority("ADMIN")
				.antMatchers("/user/salaries/**").hasAuthority("ADMIN")
				.antMatchers("/user/salary/**").hasAuthority("ADMIN")
				.antMatchers("/user/salaries/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/index",true)
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.csrf().disable();
	}
}
