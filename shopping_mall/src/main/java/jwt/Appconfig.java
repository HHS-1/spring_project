package jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }
}
