package com.example.ClinicaOdontologica.common.config;

import com.example.ClinicaOdontologica.security.JwtRequestFilter;
import com.example.ClinicaOdontologica.security.JwtService;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import com.example.ClinicaOdontologica.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
    private PacienteServiceImpl pacienteService;

    @Autowired
    private JwtService jwtService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(dentistaService)
                .passwordEncoder(bCryptPasswordEncoder);
    }
    public OncePerRequestFilter jwtFilter() {
        return new JwtRequestFilter(dentistaService, pacienteService, jwtService);
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
                    .antMatchers("/destistas", "/dentistas/**")
                        .hasAnyRole( "ADMIN")
                    .antMatchers("/pacientes", "/pacientes/**")
                        .hasAnyRole( "ADMIN")
                    .antMatchers("/enderecos", "/enderecos/**")
                        .hasAnyRole( "ADMIN")
                    .antMatchers(HttpMethod.GET,"/consultas", "/consultas/**")
                        .hasAnyRole( "PACIENTE", "ADMIN")
                    .antMatchers(HttpMethod.POST, "/consultas", "/consultas/**")
                        .hasAnyRole("PACIENTE", "ADMIN")
                    .antMatchers(HttpMethod.DELETE, "/consultas", "/consultas/**")
                        .hasAnyRole( "ADMIN")
                    .antMatchers(HttpMethod.PUT, "/consultas", "/consultas/**")
                        .hasAnyRole( "ADMIN")
                    .anyRequest().authenticated()
                .and()
                    //.formLogin();
                    //.httpBasic();
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui/index.html",
                "/swagger-ui/**",
                "/webjars/**");
    }

}
