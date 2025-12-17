package test;

import org.junit.jupiter.api.Test;
import contactservice.Contact;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    // Verify that a valid contact is created successfully
    @Test
    void testContact() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        assertEquals("12345", contact.getContactId());
        assertEquals("Sean", contact.getFirstName());
        assertEquals("Eastwood", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123 Street", contact.getAddress());
    }

    // Verify that ID must be non-null
    @Test
    void ContactIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Sean", "Eastwood", "0123456789", "123 Street");
        });
    }

    // Verify that ID must not exceed 10 characters
    @Test
    void ContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Sean", "Eastwood", "0123456789", "123 Street");
        });
    }

    // Boundary test: ID exactly 10 characters should be accepted
    @Test
    void ContactIdExactly10Chars() {
        Contact contact = new Contact("1234567890", "Sean", "Eastwood", "0123456789", "123 Street");
        assertEquals("1234567890", contact.getContactId());
    }

    // Verify that first name must be non-null
    @Test
    void ContactFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Eastwood", "0123456789", "123 Street");
        });
    }

    // Verify that first name must not exceed 10 characters
    @Test
    void ContactFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "VeryLongFirstName", "Eastwood", "0123456789", "123 Street");
        });
    }

    // Boundary test: first name exactly 10 characters should be accepted
    @Test
    void ContactFirstNameExactly10Chars() {
        Contact contact = new Contact("12345", "FirstNameX", "Eastwood", "0123456789", "123 Street");
        assertEquals("FirstNameX", contact.getFirstName());
    }

    // Verify that last name must be non-null
    @Test
    void ContactLastNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Sean", null, "0123456789", "123 Street");
        });
    }

    // Verify that last name must not exceed 10 characters
    @Test
    void ContactLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Sean", "VeryLongLastName", "0123456789", "123 Street");
        });
    }

    // Boundary test: last name exactly 10 characters should be accepted
    @Test
    void ContactLastNameExactly10Chars() {
        Contact contact = new Contact("12345", "Sean", "LastNameX", "0123456789", "123 Street");
        assertEquals("LastNameX", contact.getLastName());
    }

    // Verify that phone must be non-null
    @Test
    void ContactPhoneIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Sean", "Eastwood", null, "123 Street");
        });
    }

    // Verify that phone must be exactly 10 digits
    @Test
    void ContactPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Sean", "Eastwood", "01234", "123 Street");
        });
    }

    // Boundary test: phone exactly 10 digits should be accepted
    @Test
    void ContactPhoneExactly10Digits() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        assertEquals("0123456789", contact.getPhone());
    }

    // Verify that address must be non-null
    @Test
    void ContactAddressIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Sean", "Eastwood", "0123456789", null);
        });
    }

    // Verify that address must not exceed 30 characters
    @Test
    void ContactAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Sean", "Eastwood", "0123456789",
                    "This address is way too long to be valid");
        });
    }

    // Boundary test: address exactly 30 characters should be accepted
    @Test
    void ContactAddressExactly30Chars() {
        String thirtyCharAddress = "123456789012345678901234567890";
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", thirtyCharAddress);
        assertEquals(thirtyCharAddress, contact.getAddress());
    }

    // Verify setters update fields correctly
    @Test
    void testContactSetters() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");

        contact.setFirstName("Andy");
        contact.setLastName("Yang");
        contact.setPhone("0987654321");
        contact.setAddress("456 Avenue");

        assertEquals("Andy", contact.getFirstName());
        assertEquals("Yang", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Avenue", contact.getAddress());
    }

    // Verify setter rejects null first name
    @Test
    void ContactSetFirstNameIsNull() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    // Verify setter rejects too-long first name
    @Test
    void ContactSetFirstNameTooLong() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("VeryLongFirstName"));
    }

    // Verify setter rejects null last name
    @Test
    void ContactSetLastNameIsNull() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    // Verify setter rejects too-long last name
    @Test
    void ContactSetLastNameTooLong() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("VeryLongLastName"));
    }

    // Verify setter rejects null phone
    @Test
    void ContactSetPhoneIsNull() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    // Verify setter rejects too-short phone
    @Test
    void ContactSetPhoneTooShort() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("01234"));
    }

    // Verify setter rejects null address
    @Test
    void ContactSetAddressIsNull() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    // Verify setter rejects too-long address
    @Test
    void ContactSetAddressTooLong() {
        Contact contact = new Contact("12345", "Sean", "Eastwood", "0123456789", "123 Street");
        assertThrows(IllegalArgumentException.class, () -> 
            contact.setAddress("This address is way too long to be valid")
        );
    }
}
