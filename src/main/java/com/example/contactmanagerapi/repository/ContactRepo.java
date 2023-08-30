package com.example.contactmanagerapi.repository;

import com.example.contactmanagerapi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactRepo extends JpaRepository<Contact, Long> {


    void deleteContactById(long id);

    Optional<Contact> findContactById(long id);
}
