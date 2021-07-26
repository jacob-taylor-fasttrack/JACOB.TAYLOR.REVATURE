package com.revature.repos;

import java.util.List;

import com.revature.models.Events;

public interface EventsRepo {
	public Events addEvents(Events ev);

	public List<Events> getAllEvents();

	public Events getEvent(int id);

	public Events updateEvents(Events change);

	public Events deleteEvents(Events ev);
}
