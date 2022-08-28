package dev.michael.streamschedule.controller;

import dev.michael.streamschedule.Exception.LiveStreamNotFoundException;
import dev.michael.streamschedule.model.LiveStream;
import dev.michael.streamschedule.repository.LiveStreamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

  private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<LiveStream> finalAll() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id) throws LiveStreamNotFoundException {
        return repository.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@Valid @RequestBody LiveStream stream){
     return repository.create(stream);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody LiveStream stream, @PathVariable String id){
        repository.update(stream, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        ;repository.delete(id);
    }

}
