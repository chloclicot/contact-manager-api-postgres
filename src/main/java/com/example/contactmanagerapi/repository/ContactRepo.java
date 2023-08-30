package com.example.contactmanagerapi.repository;

import com.example.contactmanagerapi.model.Contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactRepo {

    int addContact(Contact contact);
    int updateContact(Contact contact,UUID id);
    Optional<Contact> getContactById(UUID id);
    int deleteContact(UUID id);
    List<Contact> getAllContacts();
}
