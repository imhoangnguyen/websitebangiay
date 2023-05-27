package com.shoes_shop.conf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.shoes_shop.entities.User;
import com.shoes_shop.repositories.UserRepo;


@Configuration // -> tạo ra 1 bean tên webConf và được spring-container quản lí.
// -> đồng thời module web sẽ biết được đây là file cấu hình của web.
@Order(2)
@EnableWebSecurity
public class WebSecureUserConf extends WebSecurityConfigurerAdapter {
	@Autowired private UserDetailsService userDetailsService;
	@Autowired
	private UserRepo userRepo;
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();//thực hiện xác thực với request gửi lên
		http.antMatcher("/user/**") // bất cứ request nào có user ở đằng trước đều phải xác thực
		.authorizeRequests()
		.antMatchers("/user/**").hasAnyAuthority("USER","ADMIN") //quyền truy cập của user
		.and()
        .exceptionHandling().accessDeniedPage("/USER?error_access=loi")
        .and() // kết hợp với điều kiện.
        
        // khi click vào button logout thì không cần login.
        // khi click vào button này thì dữ liệu user trên session sẽ bị xoá.
        .logout()
        .logoutUrl("/user/logout")
        .logoutSuccessUrl("/")
        .invalidateHttpSession(true) // xoá hết dữ liệu trên seesion
        .deleteCookies("JSESSIONID") // xoá hết dữ liệu trên cokies.
        .permitAll()
        
        .and() // kết hợp với điều kiện.
        
        .formLogin() // thực hiện xác thực qua form(username và password)
        .loginPage("/user") // trang login do mình thiết kế, trỏ vào request-mapping trong controller.
        .loginProcessingUrl("/user") // link action for form post.
        .successHandler(new AuthenticationSuccessHandler() { // sau khi truy cập khởi tạo session cho user
       	 @Override
         public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                 Authentication authentication) throws IOException, ServletException {
             // run custom logics upon successful login
    		 HttpSession ss = request.getSession();
             UserDetails userDetails = (UserDetails) authentication.getPrincipal();
             User user =  userRepo.findByUsername(userDetails.getUsername());
             user.setPassword("");
             ss.setAttribute("currentUser",user);
             response.sendRedirect("/user/info");
         }
    }) // when user success authenticated then go to this url.
        .failureUrl("/user?error_login=true") // nhập username, password sai thì redirect về trang nào.
        .permitAll();
	}
	@Override
    public void configure(WebSecurity web) throws Exception {
		//không thực hiện hiện xác thực đối với các đường link có các tiền tố bên dưới
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/assets/**", "/file/uploads/**");
    }
	@Bean public PasswordEncoder passwordEncoder() {
		//mã hoá code của user gửi tới
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
		return encoder;
    }
	
	@Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//so sánh mật khẩu của người dùng gửi đến với mật khẩu đã được mã hoá trong database
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
