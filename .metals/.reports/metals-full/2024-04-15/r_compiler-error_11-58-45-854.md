file:///C:/Users/h_bri/Documents/Intégration_Continue/contacts-messaging-app/contacts-messaging-app/src/main/java/com/yourcompany/controller/ContactController.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.1\scala3-library_3-3.3.1.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 867
uri: file:///C:/Users/h_bri/Documents/Intégration_Continue/contacts-messaging-app/contacts-messaging-app/src/main/java/com/yourcompany/controller/ContactController.java
text:
```scala
package com.yourcompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.yourcompany.model.Contact;
import com.yourcompany.service.ContactService;

import java.util.List;

@Controller  // Utilisez @Controller pour gérer aussi les vues
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // Récupérer tous les contacts en JSON
    @GetMapping("/api")
    @ResponseBody  // Pour indiquer que cette méthode renvoie un corps de réponse
    public List<Contact> getAllContacts() {
        return contactSe@@rvice.findAll();
    }

    // Récupérer tous les contacts et retourner une vue
    @GetMapping
    public String showContactsPage(Model model) {
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        return "contacts";  // Nom du fichier HTML dans /src/main/resources/templates
    }

    // Récupérer un contact par ID en JSON
    @GetMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = contactService.findById(id);
        return new ResponseEntity<>(contact, contact != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    // Ajouter un nouveau contact via API
    @PostMapping("/api")
    @ResponseBody
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact newContact = contactService.save(contact);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }
        
    // Mettre à jour un contact existant via API
    @PutMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
        Contact updatedContact = contactService.update(id, contactDetails);
        return new ResponseEntity<>(updatedContact, updatedContact != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    // Supprimer un contact via API
    @DeleteMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable Long id) {
        boolean isDeleted = contactService.delete(id);
        return new ResponseEntity<>(isDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:34)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:352)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator