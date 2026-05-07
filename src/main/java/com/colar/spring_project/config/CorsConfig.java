package com.colar.spring_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	// React(3000) → Spring(8080) 크로스 도메인 요청 허용
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**") // /api/ 로 시작하는 모든 경로에 대해
				.allowedOrigins("http://localhost:3000") // React(3000)에서 오는 요청은 허용
				.allowedMethods("GET", "POST", "PUT", "DELETE") // 이 메서드들 허용
				.allowedHeaders("*"); // 모든 헤더 허용
	}
}