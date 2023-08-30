package com.example.contactmanagerapi.service;

import com.example.contactmanagerapi.model.Contact;
import com.example.contactmanagerapi.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service //Bean pour qu'il soit instancié par springboot
public class ContactService {
    private final ContactRepo contactRepo;

    @Autowired //
    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public Contact addContact(Contact contact){
        return contactRepo.save(contact);
    }

    public Contact updateContact(Contact contact){
        return contactRepo.save(contact);
    }

    public Contact getContactById(long id){
        return contactRepo.findContactById(id).orElse(null);
    }

    public void deleteContact(long id){
        contactRepo.deleteContactById(id);
    }

    public List<Contact> getAllContacts(){
        return contactRepo.findAll();
    }


}
