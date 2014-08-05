package com.pranabdash.blog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configures the Dispatcherservlet context with custom configuration. 
 * Also it loads the @Controller classes into the web application context through component scanning.
 * @author pranabdash
 *
 */
@EnableWebMvc
@ComponentScan("com.pranabdash.blog.controller")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    
	public @Bean InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
		resourceViewResolver.setPrefix("/WEB-INF/jsp/");
		resourceViewResolver.setSuffix(".jsp");
		return resourceViewResolver;
	}
}
