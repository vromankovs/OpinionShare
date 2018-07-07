package lv.akurss.opinionshare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired //dobavljaem zavosomostj
	private DataSource dataSource;


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.usersByUsernameQuery("select email, password, true from users where email=?")
				.authoritiesByUsernameQuery("SELECT u.email, r.role from users u inner join user_role ur on u.id=ur.user_id inner join roles r on ur.role_id=r.id where u.email=?")
				.passwordEncoder(passwordEncoder())
				.dataSource(dataSource);

	}

	@Override

	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/user").permitAll()
				.antMatchers("/registration.html").permitAll()
				.anyRequest().authenticated()
			.and().formLogin()
				.loginPage("/login.html")
				.permitAll()
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/")
				.usernameParameter("email")
				.passwordParameter("password")
			.and().csrf().disable();}//popadaet na startovuju strani4ku

	
	
}
