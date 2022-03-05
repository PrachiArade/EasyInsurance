package perscholas.mycasestudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import perscholas.mycasestudy.security.CustomSuccessHandler;
import perscholas.mycasestudy.security.UserDetailsServiceImpl;


import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

   @Autowired
    private CustomSuccessHandler customSuccessHandler;


    private final static String [] allowedURL={"/pub/**", "/error/**", "/login/**","/search","/Everyone/**","/","/contact"};


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .authorizeRequests()

                .antMatchers(allowedURL).permitAll()
                // these are URLs that the user must be authenticated for
                .antMatchers("/admin/**", "/user/**").authenticated()
                .and()
                .formLogin()
                // this is the URL for the login page - displays your JSP page for login
                // this needs to be implemented in a controller.
                // TODO create a controller method for this URL
               .loginPage("/login/login")
                // this is the URL where the login page submits to be processed by spring security
                // this is implemented by spring security and does not need a controller
                //TODO make your login page form action point to this url with a method:POST
              .loginProcessingUrl("/login/loginSecurityPost")
                //
                // .defaultSuccessUrl("/homepage.html", true)
                 //.defaultSuccessUrl("/insurance/selectInsurance", true)
                .successHandler(customSuccessHandler)
                .failureUrl("/login/loginSecurityPost?error=true")
                //.successHandler(successHandler)
                //.failureHandler(failureHandler)
                .and()
                .logout()
                // invalidating the session removes the JSESSION_ID cookie from the browser
                // and removes the user session from tomcat and from spring security
                .invalidateHttpSession(true)

                // this is the URL that logs out a user.   So in your menu when you implement
                // this is implemented by spring security in a hidden controller specific for spring security and does not need a controller
                .logoutUrl("/login/logout")

                // this is the URL the user will be redirected to after the have logged out
                //.logoutSuccessUrl("/login/logoutSuccess")
                .logoutSuccessUrl("/login/loginSecurityPost?logout=true")
                .and()
                .rememberMe()
                // this configuration is for remember me and is not required for the class
                // but it would be nice if you implement it
                .key("SR_KEY_1")
                .tokenValiditySeconds(60 * 60 * 24 * 30)
                .rememberMeParameter("remember-me")
                .and()
                .exceptionHandling()
                //.authenticationEntryPoint(getAuthenticationEntryPoint())
                // this is the URL for the access denied page.
                .accessDeniedPage("/error/404");
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(getPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(getAuthenticationProvider());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean(name="passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
