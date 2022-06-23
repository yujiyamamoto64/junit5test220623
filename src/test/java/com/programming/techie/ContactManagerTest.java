package com.programming.techie;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContactManagerTest {
	
	ContactManager contactManager;
	
	@BeforeAll
	public void setupAll() {
		System.out.println("Should Print Before All Tests");
	}
	
	@BeforeEach
	public void setup() {
		ContactManager contactManager = new ContactManager();
	}

	@Test
	public void shouldCreateContact () {
		contactManager.addContact("John", "Doe", "0123456789");
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
		Assertions.assertThrows(RuntimeException.class, () -> {
			contactManager.addContact(null, "Doe", "0123456789");
		});
	}
	
	@Test
	@DisplayName("Should Not Create Contact When Last Name is Null")
	public void shouldThrowRunTimeExceptionWhenLastNameIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			contactManager.addContact("John", null, "0123456789");
		});
	}
	
	@Test
	@DisplayName("Should Not Create Contact When Phone Number is Null")
	public void shouldThrowRunTimeExceptionWhenPhoneNumberIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			contactManager.addContact("John", "Doe", null);
		});
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("Should Execute After Each Test");
	}
	
	@AfterAll
	public void tearDownAll() {
		System.out.println("Should be executed At the end of the Test");
	}
}
