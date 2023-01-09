package net.javaguides.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    // ToDo: Why custom beans??
    // ToDo: Why public??
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        // Can manipulate all received requests..

        return builder.routes()
                .route(p -> p.path("/get") // If path is get -> redirect
                    .filters(f -> f.addRequestHeader("MyHeader", "MyURI")
                        .addRequestParameter("Param", "MyParam"))
                    .uri("http://httpbin.org:80"))
                // Redirect URLs to services
                .route(p -> p.path("/api/employee/**")
                        .uri("lb://EMPLOYEE-SERVICE"))
                .route(p -> p.path("/api/department/**")
                        .uri("lb://DEPARTMENT-SERVICE"))
                .build();
    }

}
