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
    public ContactService(@Qualifier("fakeDB") ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public int addContact(Contact contact){
        return contactRepo.addContact(contact);
    }

    public int updateContact(Contact contact, UUID id){
        return contactRepo.updateContact(contact,id);
    }

    public Contact getContactById(UUID id){
        return contactRepo.getContactById(id).orElse(null);
    }

    public int deleteContact(UUID id){
        return contactRepo.deleteContact(id);
    }

    public List<Contact> getAllContacts(){
        return contactRepo.getAllContacts();
    }


}
