package com.programming.techie;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactManagerTest {

	@Test
	public void shouldCreateContact () {
		ContactManager contactManager = new ContactManager();
		contactManager.addContact("john", "Doe", "0123456789");
		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
		Assertions.assertEquals(1, contactManager.getAllContacts().size());
	}
}
