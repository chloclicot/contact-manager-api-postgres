package com.example.contactmanagerapi.repository;

import com.example.contactmanagerapi.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDB") //Bean pour être instancié par springboot
public class FakeContactDB implements ContactRepo {

    private static List<Contact> DB = new ArrayList<>();


    @Override
    public int addContact(Contact contact) {
        contact.setId(UUID.randomUUID());
        this.DB.add(contact);
        Collections.sort(DB,(c1,c2)->c1.compareTo(c2));
        return 1;
    }

    @Override
    public int updateContact(Contact contact, UUID id) {
        var c = getContactById(id);
        contact.setId(id);
        if(c.isEmpty()) return 0;
        else{
            int index = DB.indexOf(c.get());
            DB.set(index,contact);
            return 1;
        }
    }

    @Override
    public Optional<Contact> getContactById(UUID id) {
        return DB.stream()
                .filter(contact -> contact.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteContact(UUID id) {
        Optional<Contact> c = getContactById(id);
        if(c.isEmpty()) return 0;
        else DB.remove(c.get());
        return 1;
    }


    @Override
    public List<Contact> getAllContacts() {
        return DB;
    }
}
