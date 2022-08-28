package dev.michael.AddressBook.repository;

import dev.michael.AddressBook.Exceptions.ContactNotFoundException;
import dev.michael.AddressBook.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AddressBookRepository {

    List<Contact> contacts = new ArrayList<>();

    public AddressBookRepository(){
    }

    public List<Contact> findAll(){
        return contacts;
    }

    public Contact findById(String id) throws ContactNotFoundException {
        return contacts.stream().filter(contact -> contact.id().equals(id)).findFirst().orElseThrow(ContactNotFoundException::new);
    }
    public Contact create(Contact contact){
        contacts.add(contact);
        return contact;
    }

    public void delete(String id) {
        contacts.removeIf(contact -> contact.id().equals(id));
    }

    public void update(Contact contact, String id){

        Contact existing = contacts.stream().filter(entry -> entry.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Contact not found"));
        int i = contacts.indexOf(existing);
        contacts.set(i, contact);
    }
}
