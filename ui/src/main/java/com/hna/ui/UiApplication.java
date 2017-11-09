package com.hna.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
@EnableZuulProxy
@EnableOAuth2Sso
//@EnableWebSecurity
public class UiApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

	/**
	 * 目的是为了修改@EnableOAuth2Sso引起的默认Filter链,默认是org.springframework.boot.autoconfigure.security.oauth2.client.
	 * OAuth2SsoDefaultConfiguration#configure,这个类上面有@Conditional(NeedsWebSecurityCondition.class)意思应该是,
	 * 没有WebSecurityConfigurerAdapter才会去执行这个config,因为继承了这个类,所以此config不再执行
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
//		http
//				.logout()
//				.and()
//				.authorizeRequests().antMatchers("/**/*.html", "/login").permitAll()
//				.anyRequest().authenticated()
//				.and().csrf().disable();
	}
}
