package com.example.contactmanagerapi.api;

import com.example.contactmanagerapi.model.Contact;
import com.example.contactmanagerapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Contact> addContact(@NonNull @RequestBody Contact contact){
        return new ResponseEntity<>(contactService.addContact(contact), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") long id){
        return new ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") long id){
        contactService.deleteContact(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Contact> updateContact(@NonNull @RequestBody Contact contact){
        return new ResponseEntity<>(contactService.updateContact(contact), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts(){
        return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
    }


}
