package dev.innova.mockito.mockitoserver.controller;

import dev.innova.mockito.mockitoserver.domain.ClassifiedData;
import dev.innova.mockito.mockitoserver.domain.request.SaveAddRequest;
import dev.innova.mockito.mockitoserver.facade.ClassifiedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/api/v1/adds")
public class ClassifiedController {

    @Autowired
    private ClassifiedService classifiedService;

    @GetMapping("/find")
    public Flux<ClassifiedData> getTicketsByMovieName(@RequestParam(name = "name") String name) {
        log.debug("Find Adds by Name : {}", name);
        return classifiedService.getAddsByName(name);
    }

    @GetMapping("/all")
    public Flux<ClassifiedData> findAllAdds() {
        log.debug("Get All Adds ");
        return classifiedService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ClassifiedData> create(@RequestBody SaveAddRequest ticket) {
        log.debug("Save Add with : {}", ticket);
        return classifiedService.saveAdd(ticket);
    }
}
