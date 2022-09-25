package com.example.ClinicaOdontologica.common.config;

import com.example.ClinicaOdontologica.security.JwtRequestFilter;
import com.example.ClinicaOdontologica.security.JwtService;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Autowired
    private JwtService jwtService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(dentistaService)
                .passwordEncoder(bCryptPasswordEncoder);
    }
    public OncePerRequestFilter jwtFilter() {
        return new JwtRequestFilter(dentistaService, jwtService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST,"/dentistas/auth")
                        .permitAll()
                    .antMatchers(HttpMethod.POST,"/pacientes/auth")
                        .permitAll()
                    .antMatchers(HttpMethod.GET,"/destistas", "/dentistas/**")
                        .hasAnyRole("PACIENTE", "ADMIN")
                    .antMatchers(HttpMethod.POST, "/destistas", "/dentistas/**")
                        .hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.PUT,"/destistas", "/dentistas/**")
                        .hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.DELETE,"/destistas", "/dentistas/**")
                        .hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.GET,"/pacientes", "/pacientes/**")
                        .hasAnyRole("PACIENTE", "ADMIN")
                    .antMatchers(HttpMethod.POST,"/pacientes", "/pacientes/**")
                        .hasAnyRole("ADMIN")
                    .antMatchers("/enderecos", "/enderecos/**")
                        .hasAnyRole("PACIENTE", "ADMIN")
                    .antMatchers("/consultas", "/consultas/**", "/enderecos", "/enderecos/**")
                        .hasAnyRole("ADMIN")
                    .antMatchers("/dentistas/**")
                        .hasAnyRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                    //.formLogin();
                    //.httpBasic();
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
