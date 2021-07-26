package com.revature.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.revature.models.EventTypes;
import com.revature.repos.EventTypeRepo;
import com.revature.repos.EventTypesRepoHBImpl;

public class EventTypesRepoTest {
	public static EventTypes evt;

	@Before
	public void init() {
		evt = new EventTypes();
		evt.setCoveragepercent(.60);
		evt.setTypename("Training");
		evt.setId(1);
	}

	@Test
	public void testCreateEventTypes() {
		EventTypeRepo evtr = new EventTypesRepoHBImpl();
		EventTypes test = evtr.addEventTypes(evt);
		assertNotNull(test);
		assertEquals(test.getTypename(), "Training");
	}

	@Test
	public void testGetEventTypes() {
		EventTypeRepo evtr = new EventTypesRepoHBImpl();
		EventTypes test = evtr.getEventType(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllEventTypes() {
		EventTypeRepo evtr = new EventTypesRepoHBImpl();
		List<EventTypes> tests = evtr.getAllEventTypes();
		assertNotNull(tests);
	}

	@Test
	public void testUpdateEventTypes() {
		EventTypeRepo evtr = new EventTypesRepoHBImpl();
		EventTypes test = evtr.updateEventTypes(evt);
		assertNotNull(test);
		assertEquals(test.getTypename(), "Training");
	}

	@Test
	public void testDeleteEventTypes() {
		EventTypeRepo evtr = new EventTypesRepoHBImpl();
		EventTypes test = evtr.deleteEventTypes(evt);
		assertEquals(null, test);

	}
}
