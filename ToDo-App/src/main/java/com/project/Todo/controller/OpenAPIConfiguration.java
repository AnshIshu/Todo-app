package com.project.Todo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfiguration {

   @Bean
   public OpenAPI defineOpenApi() {
       
	  
       
       Info information = new Info()
               .title("Ansh ToDo App API")
               .version("1.0")
               .description("This API exposes endpoints to manage ToDo List.");
       return new OpenAPI().info(information);
   }
}