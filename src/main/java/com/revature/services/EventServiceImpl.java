package com.revature.services;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.revature.models.Communication;
import com.revature.models.Events;
import com.revature.repos.EventsRepo;

public class EventServiceImpl implements EventServices {
	public EventsRepo er;

	public EventServiceImpl(EventsRepo er) {
		this.er = er;
	}

	public EventServiceImpl() {
		super();
	}

	@Override
	public Events addEvents(Events ev) {
		return er.addEvents(ev);
	}

	@Override
	public List<Events> getAllEvents() {
		return er.getAllEvents();
	}

	@Override
	public Events getEvent(int id) {
		return er.getEvent(id);
	}

	@Override
	public Events updateEvents(Events change) {
		return er.updateEvents(change);
	}

	@Override
	public Events deleteEvents(Events ev) {
		return er.deleteEvents(ev);
	}

	@Override
	public String dateEvent(String eventdate) {
		Events ed = new Events();
		eventdate = er.getEvent(ed.getId()).toString();
		Date evdate = ed.getEventdate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(evdate);

	}

	@Override
	public String timeEvent(String time) {
		Events etime = new Events();
		time = er.getEvent(etime.getId()).toString();
		Date evtime = etime.getEventtime();
		DateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
		return timeformat.format(evtime);
	}

}
