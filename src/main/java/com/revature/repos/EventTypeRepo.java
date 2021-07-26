package com.revature.repos;

import java.util.List;

import com.revature.models.EventTypes;

public interface EventTypeRepo {
	public EventTypes addEventTypes(EventTypes evt);

	public List<EventTypes> getAllEventTypes();

	public EventTypes getEventType(int id);

	public EventTypes updateEventTypes(EventTypes change);

	public EventTypes deleteEventTypes(EventTypes evt);
}
