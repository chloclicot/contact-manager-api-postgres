package com.example.contactmanagerapi.api;

import com.example.contactmanagerapi.model.Contact;
import com.example.contactmanagerapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/contact")
@RestController
public class ContactController {

    //but d'un controller very simple
    //reçoit les requests les envoie au service et renvoie une réponse
    //partie backend exposé au world genre
    private final ContactService contactService;

    @Autowired //fait la connexion pour l'injection de dependencies
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/add") //va recevoir u ça via une requete post
    public void addContact(@NonNull @RequestBody Contact contact){
        contactService.addContact(contact);
    }

    @GetMapping("/find/{id}")
    public Contact getContactById(@PathVariable("id") UUID id){
        return contactService.getContactById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteContact(@PathVariable("id") UUID id){
        contactService.deleteContact(id);
    }

    @PutMapping("update/{id}")
    public void updateContact(@NonNull @RequestBody Contact contact, @PathVariable("id") UUID id){
        contactService.updateContact(contact, id);
    }

    @GetMapping("/all")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }


}
