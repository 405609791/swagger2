package fun.codefarmer.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2 配置类
 * @ @ClassName Swagger2Config
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/26 17:51
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //controller位置
                .apis(RequestHandlerSelectors.basePackage("fun.codefarmer.swagger2.controller"))

                .paths(PathSelectors.any())
                //apiInfo（）配置网站基本信息
                .build().apiInfo(new ApiInfoBuilder()
                        .description("接口文档的描述信息")
                        .title("微人事项目接口文档")
                        .contact(new Contact("codefarmer","http://www.codefarmer.fun","zhanglianhui811@"))
                        .version("v1.0")
                        .license("Apache2.0")
                        .build()
                );
    }
}
