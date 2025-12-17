package test;

import contactservice.Contact;
import contactservice.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        service.addContact(contact);
    }

    // Verify that a contact with a unique ID can be added successfully
    @Test
    void addContactWithUniqueId() {
        Contact newContact = new Contact("67890", "Andy", "Yang", "0987654321", "456 Avenue");
        service.addContact(newContact);
        assertEquals(newContact, service.getContact("67890"));
    }

    // Verify that adding a contact with a duplicate ID throws an exception
    @Test
    void addContactWithDuplicateIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(new Contact("12345", "Duplicate", "Test", "0000000000", "Some Address"));
        });
    }

    // Verify that deleting an existing contact works correctly
    @Test
    void deleteContactWorks() {
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    // Verify that deleting a non-existent contact throws an exception
    @Test
    void deleteNonexistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("99999");
        });
    }

    // Verify that updating the first name of a contact works correctly
    @Test
    void updateFirstNameWorks() {
        service.updateFirstName("12345", "Andy");
        assertEquals("Andy", service.getContact("12345").getFirstName());
    }

    // Verify that updating the last name of a contact works correctly
    @Test
    void updateLastNameWorks() {
        service.updateLastName("12345", "Yang");
        assertEquals("Yang", service.getContact("12345").getLastName());
    }

    // Verify that updating the phone number of a contact works correctly
    @Test
    void updatePhoneWorks() {
        service.updatePhone("12345", "0987654321");
        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    // Verify that updating the address of a contact works correctly
    @Test
    void updateAddressWorks() {
        service.updateAddress("12345", "456 Avenue");
        assertEquals("456 Avenue", service.getContact("12345").getAddress());
    }

    // Verify that updating a non-existent contact throws an exception
    @Test
    void updateNonexistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("99999", "Test");
        });
    }
}
