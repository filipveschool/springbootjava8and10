package com.filip.springbootjava8and10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctionDslKt;

//@Configuration
public class WebfluxConfig {

    @Bean
    @NotNull
    public RouterFunction routes() {
//        RouterFunction var10000 = RouterFunctionDslKt.router((Function1)null.INSTANCE).filter((HandlerFilterFunction)null.INSTANCE);
//        Intrinsics.checkExpressionValueIsNotNull(var10000, "router {\n    (\"/\").nest … next.handle(request)\n  }");
//        return var10000;
        return null;
    }
}
