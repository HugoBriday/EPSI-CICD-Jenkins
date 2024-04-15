package com.yourcompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yourcompany.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Ici, vous pouvez définir d'autres méthodes spécifiques si nécessaire
}
