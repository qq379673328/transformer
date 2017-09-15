package cn.com.sinosoft.tbf.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 应用安全配置
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年8月9日
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 自定义web认证
	 */
	@Autowired
	private AuthenticationProviderCustom authProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 禁止srping控制cache control
		http.headers().cacheControl().disable();

		http.csrf().disable()// 禁用csrf
			.authorizeRequests()// 安全认证
			.antMatchers("/api/**").permitAll()// 通过ApiTokenAuthInterceptor认证
			.anyRequest().authenticated() // 其它
			.and().formLogin()// 登录页
				.loginPage("/login")
				.defaultSuccessUrl("/index", true)
				.permitAll()
			.and().logout()// 登出页
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.permitAll();

		// 设置最大session数-同一账号只允许在一个地方登陆
		http.sessionManagement().maximumSessions(1);

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/scripts/**", "/css/**", "/images/**", "/upfiles/**");
	}

	/**
	 * 认证配置
	 *
	 *
	 * @param auth
	 * @throws Exception
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 自定义认证
		auth.authenticationProvider(authProvider);
		// 简单内存认证
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

}
