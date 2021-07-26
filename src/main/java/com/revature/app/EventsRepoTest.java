package com.revature.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import com.revature.models.Events;
import com.revature.repos.EventsRepo;
import com.revature.repos.EventsRepoHBImpl;

public class EventsRepoTest {
	public static Events ev;

	@Before
	public void init() {
		ev = new Events();
		ev.setEventlocation("Miami");
		ev.setDesc("Python program");
		ev.setCost(100.50);
		ev.setId(1);
	}

	@Test
	public void testCreateEvents() {
		EventsRepo evr = new EventsRepoHBImpl();
		Events test = evr.addEvents(ev);
		assertNotNull(test);
		assertEquals(test.getCost(), 100.50);
	}

	@Test
	public void testGetEvents() {
		EventsRepo evr = new EventsRepoHBImpl();
		Events test = evr.getEvent(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllEvents() {
		EventsRepo evr = new EventsRepoHBImpl();
		List<Events> tests = evr.getAllEvents();
		assertNotNull(tests);
	}

	@Test
	public void testUpdateEvents() {
		EventsRepo evr = new EventsRepoHBImpl();
		Events test = evr.updateEvents(ev);
		assertNotNull(test);
		assertEquals(test.getCost(), 100.60);
	}

	@Test
	public void testDeleteEvents() {
		EventsRepo evr = new EventsRepoHBImpl();
		Events test = evr.deleteEvents(ev);
		assertEquals(null, test);

	}
}
