package com.poly.truongnvph29176.config;

import com.poly.truongnvph29176.interceptor.GlobalInnterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final GlobalInnterceptor globalInnterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalInnterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/rest/**", "/admin/**", "/assets/**");
    }
}
