package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc //@EnableWebMvc 애너테이션은 Spring MVC를 활성화
public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	//이 설정을 통해 정적 리소스나 다른 Spring MVC에서 처리하지 않는 요청에 대해 기본 서블릿을 사용할 수 있음

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/",".jsp"); //view의 위치정보 포워딩 시키기 전
	}
	
}
//Spring MVC의 설정 서블릿, 뷰 설정하여 MVC동작 구현
//JSP 파일을 뷰로 사용할 수 있도록 한다.