package dev.innova.mockito.mockitoserver.controller;

import dev.innova.mockito.mockitoserver.config.UserResourceConfiguration;
import dev.innova.mockito.mockitoserver.domain.UserData;
import dev.innova.mockito.mockitoserver.facade.ClassifiedService;
import dev.innova.mockito.mockitoserver.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@WebFluxTest
@Import(UserResourceConfiguration.class)
@RunWith(SpringRunner.class)
public class AddsRestApiTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ClassifiedService classifiedService;

    @Test
    public void getAllAddsTest() throws Exception {

        UserData add1 = new UserData();
        add1.setId("001");
        add1.setName("Sample1");

        UserData add2 = new UserData();
        add2.setId("002");
        add2.setName("Sample2");

        UserData add3 = new UserData();
        add3.setId("003");
        add3.setName("Sample3");

        Mockito.when(this.userRepository.findAll())
                .thenReturn(Flux.just(add1, add2, add3));

        this.webTestClient.get()
                .uri("http://localhost:8084/allUsers")
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("@.[0].id").isEqualTo("001");

    }
}
