package dev.innova.mockito.mockitoserver.facade;

import dev.innova.mockito.mockitoserver.domain.ClassifiedData;
import dev.innova.mockito.mockitoserver.domain.request.SaveAddRequest;
import dev.innova.mockito.mockitoserver.repository.ClassifiedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClassifiedService {

    @Autowired
    private ClassifiedRepository classifiedRepository;

    @Autowired
    private ClassifiedConverter classifiedConverter;

    public Flux<ClassifiedData> getAddsByName(String name) {
        return classifiedRepository.findByName(name);
    }

    public Mono<ClassifiedData> saveAdd(SaveAddRequest saveAddRequest) {
        return classifiedRepository.insert(classifiedConverter.convert(saveAddRequest));
    }

    public Flux<ClassifiedData> getAll() {
        return classifiedRepository.findAll();
    }
}
