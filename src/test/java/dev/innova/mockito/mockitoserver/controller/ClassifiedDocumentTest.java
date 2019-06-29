package dev.innova.mockito.mockitoserver.controller;

import dev.innova.mockito.mockitoserver.domain.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.function.Predicate;

@DataMongoTest
@RunWith(SpringRunner.class)
public class ClassifiedDocumentTest {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Test
    public void testUserPersist() {
        Flux<UserData> userDataFlux = Flux.just(new UserData("001", "sajith", "vijesekara"),
                new UserData("002", "ismail", "iqbal"))
                .flatMap(r -> this.reactiveMongoTemplate.save(r));

        Flux<UserData> userData = this.reactiveMongoTemplate.dropCollection(UserData.class)
                .thenMany(userDataFlux)
                .thenMany(this.reactiveMongoTemplate.findAll(UserData.class));

        Predicate<UserData> predicate = sample -> StringUtils.hasText(sample.getId()) && (sample.getName().equalsIgnoreCase("sajith") ||
                sample.getName().equalsIgnoreCase("ismail"));

        StepVerifier
                .create(userData)
                .expectNextMatches(predicate)
                .expectNextMatches(predicate)
                .verifyComplete();

    }
}
