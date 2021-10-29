package com.kaffotek.nyang.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.kaffotek.nyang.service.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	private final UserService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.cors().and()
        	.csrf().disable().authorizeRequests()
        	.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_IN_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.GET, SecurityConstants.GET_ROUNDS_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.POST, SecurityConstants.POST_ROUNDS_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.GET, SecurityConstants.GET_ROUND_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.GET, SecurityConstants.GET_MEAL_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.GET, SecurityConstants.GET_MEALS_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.POST, SecurityConstants.POST_MEALS_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.PUT, SecurityConstants.UPDATE_MEALS_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.DELETE, SecurityConstants.DELETE_MEALS_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.GET, SecurityConstants.GET_PICKUP_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.GET, SecurityConstants.GET_PICKUPS_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.POST, SecurityConstants.POST_PICKUPS_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.PUT, SecurityConstants.UPDATE_PICKUPS_URL)
        	.permitAll()
        	.antMatchers(HttpMethod.DELETE, SecurityConstants.DELETE_PICKUPS_URL)
        	.permitAll()
        	.antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
            .permitAll()
        	.anyRequest().authenticated().and()
        	.addFilter(getAuthenticationFilter())
        	.addFilter(new AuthorizationFilter(authenticationManager()))
        	.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    
    protected AuthenticationFilter getAuthenticationFilter() throws Exception {
	    final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
	    filter.setFilterProcessesUrl("/users/login");
	    return filter;
	}
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource()
    {
    	final CorsConfiguration configuration = new CorsConfiguration();
    	   
    	configuration.setAllowedOrigins(Arrays.asList("*"));
    	configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE","OPTIONS"));
    	configuration.setAllowCredentials(true);
    	configuration.setAllowedHeaders(Arrays.asList("*"));
    	
    	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	source.registerCorsConfiguration("http://127.0.0.1:3000", configuration);
    	
    	return source;
    }
}
