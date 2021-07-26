package com.revature.services;

import java.util.List;

import com.revature.models.EventTypes;

public interface EventTypeServices {
	public EventTypes addEventTypes(EventTypes evt);

	public List<EventTypes> getAllEventTypes();

	public EventTypes getEventType(int id);

	public EventTypes updateEventTypes(EventTypes change);

	public EventTypes deleteEventTypes(EventTypes evt);

	double addPercentMods(double d);
}
