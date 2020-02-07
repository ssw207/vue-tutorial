package come.home.global.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConf implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
				.allowedOrigins("http://127.0.0.1:8080")
					.allowedMethods(HttpMethod.GET.name())
					.allowedMethods(HttpMethod.POST.name())
					.allowedMethods(HttpMethod.PUT.name())
					.allowedMethods(HttpMethod.DELETE.name());
		WebMvcConfigurer.super.addCorsMappings(registry);
	}
}
