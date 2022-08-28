package dev.michael.AddressBook.controller;

import dev.michael.AddressBook.model.Contact;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class ControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void findAll(){

        ResponseEntity<List<Contact>> entity = findAllContacts();
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        assertEquals(1, entity.getBody().size());
    }

    @Test
    @Order(2)
    void findById(){

        Contact existing = findAllContacts().getBody().get(0);
        String id = existing.id();
        String name = "Michael";
        Contact user2 = restTemplate.getForObject("/contacts/" + id, Contact.class);
        assertEquals(id, user2.id());
        assertEquals("Vedestig", user2.lastName());
        assertEquals(name, user2.firstName());
    }

    @Test
    @Order(3)
    void create() {
        Contact user3 = new Contact(
                UUID.randomUUID().toString(),
                "Bjarne",
                "Olsen",
                "Slottsgata 1",
                "+47 111 22 333");

        ResponseEntity<Contact> entity = restTemplate.postForEntity("http://localhost:8080/contacts", user3, Contact.class);
        assertEquals(HttpStatus.CREATED,entity.getStatusCode());
        assertEquals(2,findAllContacts().getBody().size());

        Contact user4 = entity.getBody();
        assertEquals(user3.id(), user4.id());
        assertEquals("Bjarne", user4.firstName());
        assertEquals("Olsen", user4.lastName());
        assertEquals("Slottsgata 1", user4.address());
        assertEquals("+47 111 22 333", user4.phoneNumber());
    }

    @Test
    @Order(4)
    void update() {
        Contact existing = findAllContacts().getBody().get(0);
        Contact user5 = new Contact(
                existing.id(),
                existing.firstName(),
                existing.lastName(),
                existing.address(),
                "new phone number: 444 55 666"
        );

        ResponseEntity<Contact> entity = restTemplate.exchange("https://localhost:8080/contacts/" + existing.id(), HttpMethod.PUT, new HttpEntity<>(user5), Contact.class);
        assertEquals(HttpStatus.NO_CONTENT,entity.getStatusCode());
    }

    @Test
    @Order(5)
    void delete() {
        Contact existing = findAllContacts().getBody().get(0);
        ResponseEntity<Contact> entity = restTemplate.exchange("/contacts/" + existing.id(), HttpMethod.DELETE, null, Contact.class);
        assertEquals(HttpStatus.NO_CONTENT,entity.getStatusCode());
        assertEquals(1,findAllContacts().getBody().size());
    }

    private ResponseEntity<List<Contact>> findAllContacts() {
        return restTemplate.exchange("/contacts",
                HttpMethod.GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Contact>>() {
                });
    }
}
