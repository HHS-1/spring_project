package jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
    	try {
    		System.out.println("configuration 작동1");
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    
   	}

    @Override
    protected void configure(HttpSecurity http)  {
    	System.out.println("configuration 작동2");
    	try {
    		System.out.println("configuration 작동3");
        http.httpBasic().disable()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/**").permitAll()
        .and()
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() {
    	try {
    		System.out.println("configuration 작동");
    		return super.authenticationManager();
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    }
}
