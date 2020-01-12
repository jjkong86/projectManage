package task.configs;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(PathSelectors.any())
				.build().apiInfo(apiInfo())
				.globalResponseMessage(RequestMethod.GET,
					Arrays.asList(
							new ResponseMessageBuilder().code(500).message("Internal Server Error")
									.responseModel(new ModelRef("Error")).build(),
							new ResponseMessageBuilder().code(400).message("Bad Request").build(),
							new ResponseMessageBuilder().code(404).message("Not Found").build()));
	}
	
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Project Manage")
                .description("API documentation for Project Manage")
                .version("1.0.0")
                .build();
    }
}
