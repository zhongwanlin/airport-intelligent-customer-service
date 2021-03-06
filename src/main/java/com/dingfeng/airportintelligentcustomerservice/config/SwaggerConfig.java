package com.dingfeng.airportintelligentcustomerservice.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

        @Bean
        public Docket buildDocket() {

                return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf()).select()
                                .apis(RequestHandlerSelectors.basePackage(
                                                "com.dingfeng.airportintelligentcustomerservice.controller"))
                                .paths(PathSelectors.any()).build().globalOperationParameters(setHeaderToken());

        }

        private ApiInfo buildApiInf() {

                return new ApiInfoBuilder().title("系统RESTful API文档").contact(new Contact("顶峰科技", "", "")).version("1.0")
                                .build();

        }

        private List<Parameter> setHeaderToken() {
                List<Parameter> pars = new ArrayList<>();
                ParameterBuilder gomstokenPar = new ParameterBuilder();
                gomstokenPar.name("gomstoken").description("机器码").modelRef(new ModelRef("string"))
                                .parameterType("header").required(false).build();

                pars.add(gomstokenPar.build());
                return pars;
        }

}