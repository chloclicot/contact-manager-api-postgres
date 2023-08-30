package com.example.contactmanagerapi.repository;

import com.example.contactmanagerapi.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgreDB")
public class ContactDB implements ContactRepo{
    @Override
    public int addContact(Contact contact) {
        return 0;
    }

    @Override
    public int updateContact(Contact contact, UUID id) {
        return 0;
    }

    @Override
    public Optional<Contact> getContactById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteContact(UUID id) {
        return 0;
    }

    @Override
    public List<Contact> getAllContacts() {
        return null;
    }
}
