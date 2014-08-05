package com.pranabdash.blog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Configures the root web application context with service and database configuration with the @Congiguration annotated classes.
 * Look at the @Import annotation where it loads the configuration from those classes.It also does a component scanning of the packages
 * provided in the @ComponentScan annotation and loads files with @Service or @Repository annotation.
 * 
 * @author pranabdash
 *
 */
@Configuration
@ComponentScan("com.pranabdash.blog.service")
@Import(MongoDBJavaConfig.class)
public class JavaConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
