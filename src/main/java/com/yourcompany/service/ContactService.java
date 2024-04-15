package com.yourcompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yourcompany.model.Contact;
import com.yourcompany.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // Récupérer tous les contacts
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    // Récupérer un contact par son ID
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElse(null);
    }

    // Enregistrer un contact
    @Transactional
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    // Mettre à jour un contact
    @Transactional
    public Contact update(Long id, Contact contactDetails) {
        Contact contact = findById(id);
        if (contact != null) {
            contact.setName(contactDetails.getName());
            contact.setEmail(contactDetails.getEmail());
            contact.setPhoneNumber(contactDetails.getPhoneNumber());
            contact.setAddress(contactDetails.getAddress());
            return contactRepository.save(contact);
        }
        return null;
    }

    // Supprimer un contact
    @Transactional
    public boolean delete(Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
