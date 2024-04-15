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
                new Contact("John Doe", "invalid_email", "1234567890", "1234 Boulevard St");
            })
            .withMessageContaining("invalied mail");

    }
}
