//package com.lym.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * 跨域解决方案
// * @author NieChangan
// */
//@Configuration
//public class CrosConfig implements WebMvcConfigurer {
//
//    /**
//     * Configure cross origin requests processing.
//     *
//     * @param registry
//     * @since 4.2
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOriginPatterns("*")
//                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","HEAD")
//                .allowCredentials(true)
//                .maxAge(3600)
//                .allowedHeaders("*");
//    }
//}