package com.personal.security.example.config;

import com.personal.security.example.util.URLs;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController(URLs.ROOT).setViewName("index");
        registry.addViewController(URLs.LOGIN).setViewName("login");
    }
}
