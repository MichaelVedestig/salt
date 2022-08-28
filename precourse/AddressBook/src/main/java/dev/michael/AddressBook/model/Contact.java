package dev.michael.AddressBook.model;

import java.util.UUID;

public record Contact(String id, String firstName, String lastName, String address, String phoneNumber) {

}
