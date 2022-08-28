package dev.michael.AddressBook;

import dev.michael.AddressBook.model.Contact;
import org.hibernate.validator.internal.util.Contracts;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressBookApplicationTests {

	@Test
	void create_new_contact() {

		Contact user1 = new Contact(
				UUID.randomUUID().toString(),
				"Arne",
				"Hansen",
				"Sjøgata 8",
				"+47 123 45 789"
		);
		Contracts.assertNotNull(user1);
		assertNotNull(user1);
		assertTrue(user1.getClass().isRecord());
		assertEquals("Arne", user1.firstName(), user1.address());
		assertEquals(5, user1.getClass().getRecordComponents().length);
	}

}
