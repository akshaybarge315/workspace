package com.ak.IocUsingAnnotation3.classes;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="com.ak.IocUsingAnnotation3.impl, com.ak.IocUsingAnnotation3.classes")
public class ConfigClassCustomer {

	
}
