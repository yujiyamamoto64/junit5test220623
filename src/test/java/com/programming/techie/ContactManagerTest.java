package com.programming.techie;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactManagerTest {

	@Test
	public void shouldCreateContact () {
		ContactManager contactManager = new ContactManager();
		contactManager.addContact("john", "Doe", "0123456789");
		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
		Assertions.assertEquals(1, contactManager.getAllContacts().size());
		Assertions.assertTrue(contactManager.getAllContacts().stream()
				.filter(contact -> contact.getFirstName().equals("John") &&
						contact.getLastName().equals("Doe") &&
						contact.getPhoneNumber().equals("0123456789"))
				.findAny()
				.isPresent());
	}
	
	@Test
	@DisplayName("Should Not Create Contact When First Name is Null")
	public void shouldThrowRunTimeExceptionWhenFirstNameIsNull() {
		ContactManager contactManager = new ContactManager();
		Assertions.assertThrows(RuntimeException.class, () -> {
			contactManager.addContact(null, "Doe", "0123456789");
		});
	}
	
	@Test
	@DisplayName("Should Not Create Contact When Last Name is Null")
	public void shouldThrowRunTimeExceptionWhenLastNameIsNull() {
		ContactManager contactManager = new ContactManager();
		Assertions.assertThrows(RuntimeException.class, () -> {
			contactManager.addContact("John", null, "0123456789");
		});
	}
	
	@Test
	@DisplayName("Should Not Create Contact When Phone Number is Null")
	public void shouldThrowRunTimeExceptionWhenPhoneNumberIsNull() {
		ContactManager contactManager = new ContactManager();
		Assertions.assertThrows(RuntimeException.class, () -> {
			contactManager.addContact("John", "Doe", null);
		});
	}
}
