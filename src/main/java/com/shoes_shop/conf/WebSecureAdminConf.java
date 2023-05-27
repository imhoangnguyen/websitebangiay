package com.shoes_shop.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // -> tạo ra 1 bean tên webConf và được spring-container quản lí.
// -> đồng thời module web sẽ biết được đây là file cấu hình của web.
@Order(1)
@EnableWebSecurity
public class WebSecureAdminConf extends WebSecurityConfigurerAdapter {
	@Autowired private UserDetailsService userDetailsService;
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests() // thực hiện xác thực request ngưười dùng gửi lên.
//
//			// không thực hiện xác thực đối với các url này.
//            .antMatchers().permitAll()
//
//            // thực hiện xác thực với các url kiểu ..../admin/....
////            .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
//            .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
////            .antMatchers("/user/**").hasAnyAuthority("USER")
//            .and()
//            .exceptionHandling().accessDeniedPage("/admin?error_access=loi")
//            .and() // kết hợp với điều kiện.
//
//            // khi click vào button logout thì không cần login.
//            // khi click vào button này thì dữ liệu user trên session sẽ bị xoá.
//            .logout()
//            .logoutUrl("/logout")
//            .logoutSuccessUrl("/admin")
//            .invalidateHttpSession(true) // xoá hết dữ liệu trên seesion
//            .deleteCookies("JSESSIONID") // xoá hết dữ liệu trên cokies.
//            .permitAll()
//
//            .and() // kết hợp với điều kiện.
//
//            .formLogin() // thực hiện xác thực qua form(username và password)
//            .loginPage("/admin") // trang login do mình thiết kế, trỏ vào request-mapping trong controller.
//            .loginProcessingUrl("/admin") // link action for form post.
//            .defaultSuccessUrl("/admin/dashboard", true) // when user success authenticated then go to this url.
//            .failureUrl("/admin?error_login=true") // nhập username, password sai thì redirect về trang nào.
//            .permitAll();
		http.cors().and().csrf().disable(); // thực hiện xác thực request người dùng gửi lên
		http.antMatcher("/admin/**") //bất kì đường link nào dẫn đến trang web có admin ở đằng trước đều phải xác thực
		.authorizeRequests()
		.antMatchers("/admin/**").hasAnyAuthority("ADMIN") // quyền truy cập
		.and()
        .exceptionHandling().accessDeniedPage("/admin?error_access=loi")
        .and() // kết hợp với điều kiện.
        
        // khi click vào button logout thì không cần login.
        // khi click vào button này thì dữ liệu user trên session sẽ bị xoá.
        .logout()
        .logoutUrl("/admin/logout")
        .logoutSuccessUrl("/admin")
        .invalidateHttpSession(true) // xoá hết dữ liệu trên seesion
        .deleteCookies("JSESSIONID") // xoá hết dữ liệu trên cokies.
        .permitAll()
        
        .and() // kết hợp với điều kiện.
        
        .formLogin() // thực hiện xác thực qua form(username và password)
        .loginPage("/admin") // trang login do mình thiết kế, trỏ vào request-mapping trong controller.
        .loginProcessingUrl("/admin") // link action for form post.
        .defaultSuccessUrl("/admin/dashboard", true) // when user success authenticated then go to this url.
        .failureUrl("/admin?error_login=true") // nhập username, password sai thì redirect về trang nào.
        .permitAll();
	}
	@Override
    public void configure(WebSecurity web) throws Exception {
		// không thực hiện xác thực đối với các url này.
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/assets/**", "/file/uploads/**");
    }
	@Bean("PasswordEncoder") public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8); // mã hoá mật khẩu của user để đối chiếu với mật khẩu được mã hoá bên trong database
		return encoder;
    }
	// so sánh mật khẩu được mã hoá trong database
	@Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
