package com.ravi.assignment.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket newsApi() {
    List<SecurityScheme> apiKeys = new ArrayList<>();
    apiKeys.add(apiKey());
    List<SecurityContext> secutiykey = new ArrayList<>();
    secutiykey.add(securityContext());
    return (new Docket(DocumentationType.SWAGGER_2)).groupName("public-api").select().apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.regex("/api/.*")).build().securitySchemes(apiKeys).securityContexts(secutiykey)
      .apiInfo(apiInfo());
  }
  
  private SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	} 

	private List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	}
  
  private ApiKey apiKey() {
    return new ApiKey("JWT", "Authorization", "header");
  }
  
  private ApiInfo apiInfo() {
    return (new ApiInfoBuilder()).title("Patient Portal Application")
      .description("Patient Portal App Developed by Ravi Puri")
      .termsOfServiceUrl("ravikumarpuri04@gmail.com")
      .contact(new Contact("Ravi Puri", "", "ravikumarpuri04@gmail.com"))
      .license("Ravi Puri").licenseUrl("ravikumarpuri04@gmail.com").version("1.0").build();
  }
  
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler(new String[] { "swagger-ui.html" }).addResourceLocations(new String[] { "classpath:/META-INF/resources/" });
    registry.addResourceHandler(new String[] { "/webjars/**" }).addResourceLocations(new String[] { "classpath:/META-INF/resources/webjars/" });
  }
}
