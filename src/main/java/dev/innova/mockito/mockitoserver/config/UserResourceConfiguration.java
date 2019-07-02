package dev.innova.mockito.mockitoserver.config;

import dev.innova.mockito.mockitoserver.domain.UserData;
import dev.innova.mockito.mockitoserver.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class UserResourceConfiguration {

    @Bean
    RouterFunction<ServerResponse> routes(UserRepository userRepository) {
        return RouterFunctions.route(GET("/allUsers"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON).body(userRepository.findAll(), UserData.class));
    }
}
