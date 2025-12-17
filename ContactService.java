package contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    // Add a contact with unique ID
    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact is null or ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    // Update firstName
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) throw new IllegalArgumentException("Contact ID does not exist");
        contact.setFirstName(firstName);
    }

    // Update lastName
    public void updateLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) throw new IllegalArgumentException("Contact ID does not exist");
        contact.setLastName(lastName);
    }

    // Update phone
    public void updatePhone(String contactId, String phone) {
        Contact contact = contacts.get(contactId);
        if (contact == null) throw new IllegalArgumentException("Contact ID does not exist");
        contact.setPhone(phone);
    }

    // Update address
    public void updateAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) throw new IllegalArgumentException("Contact ID does not exist");
        contact.setAddress(address);
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
