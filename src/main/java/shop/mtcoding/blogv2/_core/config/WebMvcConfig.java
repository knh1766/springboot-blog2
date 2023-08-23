package shop.mtcoding.blogv2._core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration //설정파일바꿀때
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);


        registry.addResourceHandler("/images/**")
        .addResourceLocations("file:"+"./images/")
        .setCachePeriod(10)//10초
        .resourceChain(true)
        .addResolver(new PathResourceResolver());
        
    }
    

}
