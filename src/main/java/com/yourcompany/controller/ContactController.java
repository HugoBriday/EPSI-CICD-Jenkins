package com.yourcompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yourcompany.model.Contact;
import com.yourcompany.service.ContactService;

import java.util.List;

@Controller  // Utilisez @Controller pour gérer aussi les vues
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // Récupérer tous les contacts et retourner une vue
    @GetMapping
    public String showContactsPage(Model model) {
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        return "contacts";  // Nom du fichier HTML dans /src/main/resources/templates
    }

    @GetMapping("/add")
    public String showAddContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "add";  // Vue pour ajouter un nouveau contact
    }

    @PostMapping
    public String createContact(@ModelAttribute Contact contact, RedirectAttributes redirectAttributes) {
        contactService.save(contact);
        redirectAttributes.addFlashAttribute("successMessage", "Contact added successfully!");
        return "redirect:/contacts";  // Redirection vers la liste des contacts après l'ajout
    }

    @GetMapping("/edit/{id}")
    public String showEditContactForm(@PathVariable Long id, Model model) {
        Contact contact = contactService.findById(id);
        if (contact != null) {
            model.addAttribute("contact", contact);
            return "edit";  // Vue pour éditer un contact existant
        }
        return "redirect:/contacts";  // Rediriger si le contact n'est pas trouvé
    }

    @PostMapping("/update/{id}")
    public String updateContact(@PathVariable Long id, @ModelAttribute Contact contactDetails, RedirectAttributes redirectAttributes) {
        Contact updatedContact = contactService.update(id, contactDetails);
        if (updatedContact != null) {
            redirectAttributes.addFlashAttribute("successMessage", "Contact updated successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Error updating contact!");
        }
        return "redirect:/contacts";  // Redirection vers la liste des contacts après la mise à jour
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        boolean isDeleted = contactService.delete(id);
        if (isDeleted) {
            redirectAttributes.addFlashAttribute("successMessage", "Contact deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting contact!");
        }
        return "redirect:/contacts";  // Redirection vers la liste des contacts après suppression
    }
}
