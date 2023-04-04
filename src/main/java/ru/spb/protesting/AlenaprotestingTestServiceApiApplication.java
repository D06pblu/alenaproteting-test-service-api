package ru.spb.protesting;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Alena ProTesting API",
        version = "1.0.0"))
public class AlenaprotestingTestServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlenaprotestingTestServiceApiApplication.class, args);
    }
}
