package kisit.group471.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin()
                .usernameParameter("login")
                .loginPage("/login")
                .defaultSuccessUrl("/", false)
                .failureUrl("/error")
                .and()
                .authorizeRequests()
                .mvcMatchers("/").authenticated()
                .and()
                .rememberMe()
                .key("remember-me");
    }
}
