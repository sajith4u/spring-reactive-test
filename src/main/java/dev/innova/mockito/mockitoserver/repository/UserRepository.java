package dev.innova.mockito.mockitoserver.repository;

import dev.innova.mockito.mockitoserver.domain.UserData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserData, String> {

    Flux<UserData> findByName(String name);
}
