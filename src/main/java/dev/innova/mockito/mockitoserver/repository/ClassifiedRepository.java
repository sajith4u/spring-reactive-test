package dev.innova.mockito.mockitoserver.repository;

import dev.innova.mockito.mockitoserver.domain.ClassifiedData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ClassifiedRepository extends ReactiveMongoRepository<ClassifiedData, String> {

    Flux<ClassifiedData> findByName(String name);
}
