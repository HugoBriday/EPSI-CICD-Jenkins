file:///C:/Users/h_bri/Documents/Intégration_Continue/contacts-messaging-app/contacts-messaging-app/src/test/java/com/yourcompany/model/ContactTest.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.1\scala3-library_3-3.3.1.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 1853
uri: file:///C:/Users/h_bri/Documents/Intégration_Continue/contacts-messaging-app/contacts-messaging-app/src/test/java/com/yourcompany/model/ContactTest.java
text:
```scala
package com.yourcompany.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact("John Doe", "john.doe@example.com", "1234567890", "1234 Boulevard St");
        assertThat(contact.getName()).isEqualTo("John Doe");
        assertThat(contact.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(contact.getPhoneNumber()).isEqualTo("1234567890");
        assertThat(contact.getAddress()).isEqualTo("1234 Boulevard St");
    }

    @Test
    void testContactUpdate() {
        Contact contact = new Contact("Jane Doe", "jane.doe@example.com", "0987654321", "4321 Avenue Q");
        contact.setName("Jane Roe");
        contact.setEmail("jane.roe@example.com");
        contact.setPhoneNumber("1122334455");
        contact.setAddress("5678 Street R");

        assertThat(contact.getName()).isEqualTo("Jane Roe");
        assertThat(contact.getEmail()).isEqualTo("jane.roe@example.com");
        assertThat(contact.getPhoneNumber()).isEqualTo("1122334455");
        assertThat(contact.getAddress()).isEqualTo("5678 Street R");
    }
    @Test
    void testContactFailure() {
        Contact contact = new Contact("Fake Name", "fake.email@example.com", "0000000000", "0000 Nowhere St");
        // Test to intentionally fail
        assertThat(contact.getEmail()).isNotEqualTo("correct.email@example.com");
    }

    @Test
    void testInvalidContactCreationShouldThrowException() {
        // Assuming constructor throws IllegalArgumentException for invalid email
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
               @@ new Contact("John Doe", "invalid_email", "1234567890", "1234 Boulevard St");
            })
            .withMessageContaining("invalied mail");

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