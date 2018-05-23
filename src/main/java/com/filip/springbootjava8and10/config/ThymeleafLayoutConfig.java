package com.filip.springbootjava8and10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafLayoutConfig {

    @Bean
    @NotNull
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
