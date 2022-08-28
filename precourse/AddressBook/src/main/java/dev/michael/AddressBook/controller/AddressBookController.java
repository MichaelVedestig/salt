package dev.michael.AddressBook.controller;

import dev.michael.AddressBook.Exceptions.ContactNotFoundException;
import dev.michael.AddressBook.model.Contact;
import dev.michael.AddressBook.repository.AddressBookRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {

    private final AddressBookRepository repository;

    public AddressBookController(AddressBookRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Contact> finalAll(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Contact findById(@PathVariable String id) throws ContactNotFoundException {
        return repository.findById(id);
    }

    @CrossOrigin(origins = "/home/mvedesti/salt/precourse/jsDom-trainingGround/getDataWithFetch.html")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@Valid @RequestBody Contact contact) {
        return repository.create(contact);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    @CrossOrigin(origins = "/home/mvedesti/salt/precourse/jsDom-trainingGround/getDataWithFetch.html")
    public void update(@RequestBody Contact contact, @PathVariable String id) {
        repository.update(contact, id);
    }
    @DeleteMapping("/{id}")

    @CrossOrigin(origins = "/home/mvedesti/salt/precourse/jsDom-trainingGround/getDataWithFetch.html")
    public void delete(@PathVariable("id") String id){
        repository.delete(id);
    }
}
