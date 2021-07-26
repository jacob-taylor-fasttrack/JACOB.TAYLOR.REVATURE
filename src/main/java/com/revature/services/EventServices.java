package com.revature.services;

import java.util.List;

import com.revature.models.Events;

public interface EventServices {
	public Events addEvents(Events ev);

	public List<Events> getAllEvents();

	public Events getEvent(int id);

	public Events updateEvents(Events change);

	public Events deleteEvents(Events ev);

	public String dateEvent(String eventdate);

	public String timeEvent(String time);

}
