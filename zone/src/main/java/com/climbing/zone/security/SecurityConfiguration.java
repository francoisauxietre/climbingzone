package com.climbing.zone.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //    definition des utilisateurs et de leurs roles
    @Override
    protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").authorities("ACCESS_ADMIN")
                .and()
                .withUser("video").password(passwordEncoder().encode("video")).roles("VIDEO").authorities("ACCES_VIDEO", "ACCES_MANAGER")
                .and()
                .withUser("manager").password(passwordEncoder().encode("manager")).roles("MANAGER").authorities("ACCES_MANAGER")
                .and()
                .withUser("profile").password(passwordEncoder().encode("profile")).roles("PROFILE").authorities("ACCES_PROFILE")
        ;
    }
//
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/v2/api-docs",
////                "/configuration/ui",
////                "/swagger-resources/**",
////                "/configuration/security",
////                "/swagger-ui.html",
////                "/webjars/**");
////    }
//
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable(); // ajout car chaque methode post faisait une erreur 403
        http

                .authorizeRequests()

                .antMatchers("/video/**").hasAnyRole("ADMIN", "VIDEO")
                .antMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/profile/**").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**").hasAnyRole("ADMIN", "PROFILE")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/log").hasRole("ADMIN")
                .antMatchers("/management/**").hasAnyRole("ADMIN", "PROFILE")
                .antMatchers("/swagger-ui.html#/**").authenticated()
                .antMatchers("/climbingroutes/**").authenticated()
                .antMatchers("/cards/**").authenticated()
                .antMatchers("/climbers/**").authenticated()
                .antMatchers("/api/**").hasAuthority("ACCES_ADMIN")

                .and()
                .httpBasic();
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
   }
//
//
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
////
////    @Override
////    public UserDetailsService userDetailsService() {
////        UserDetails user =
////                User.withDefaultPasswordEncoder()
////                        .username("user")
////                        .password("password")
////                        .roles("USER")
////                        .build();
////
////        return new InMemoryUserDetailsManager(user);
////    }
}