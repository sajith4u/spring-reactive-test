package dev.innova.mockito.mockitoserver.repository;

import dev.innova.mockito.mockitoserver.domain.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@DataMongoTest
@RunWith(SpringRunner.class)
public class UserDataRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserQuery() {

        Flux<UserData> userDataFlux = this.userRepository.deleteAll()
                .thenMany(Flux.just("sajith", "sajith", "sajith2", "sajuth3")
                .flatMap(item -> this.userRepository.save(new UserData(null, item, item)))
                .thenMany(this.userRepository.findByName("sajith")));

        StepVerifier.create(userDataFlux)
                .expectNextCount(2)
                .verifyComplete();
    }
}
