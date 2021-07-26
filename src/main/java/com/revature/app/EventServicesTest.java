package com.revature.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import com.revature.models.Events;
import com.revature.repos.EventsRepo;
import com.revature.repos.EventsRepoHBImpl;
import com.revature.services.EventServiceImpl;
import com.revature.services.EventServices;

public class EventServicesTest {
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

	@Test
	public void testdateEvent() {
		EventServices evs = new EventServiceImpl();
		Events ev = new Events();
		String test = evs.dateEvent("2021/10/21");
		assertNotNull(test);
		assertEquals(ev.getId(), 1);
	}

	@Test
	public void testtimeEvent() {
		EventServices evs = new EventServiceImpl();
		Events ev = new Events();
		String test = evs.timeEvent("10:21:21");
		assertNotNull(test);
		assertEquals(ev.getId(), 1);
	}
}
