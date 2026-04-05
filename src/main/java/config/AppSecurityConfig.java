package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Настройки Безопасности (Spring Security)
 */
@Configuration // Это класс конфигурации
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(encoder.encode("user")).roles("USER").build());
        manager.createUser(User.withUsername("admin")
                .password(encoder.encode("admin")).roles("ADMIN").build());
        manager.createUser(User.withUsername("superadmin")
                .password(encoder.encode("superadmin")).roles("SUPERADMIN").build());
        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/protected/**").hasRole("ADMIN")
                .requestMatchers("/confidential/**").hasRole("SUPERADMIN")
                .anyRequest().permitAll()
        ).formLogin(form -> form.defaultSuccessUrl("/", false));
        return http.build();
    }
}
