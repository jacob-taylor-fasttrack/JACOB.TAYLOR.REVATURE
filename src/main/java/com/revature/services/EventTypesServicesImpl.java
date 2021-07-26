package com.revature.services;

import java.util.List;

import com.revature.models.EventTypes;
import com.revature.repos.EventTypeRepo;

public class EventTypesServicesImpl implements EventTypeServices {
	public EventTypeRepo etr;

	public EventTypesServicesImpl(EventTypeRepo etr) {
		this.etr = etr;
	}

	public EventTypesServicesImpl() {
		super();
	}

	@Override
	public EventTypes addEventTypes(EventTypes evt) {
		return etr.addEventTypes(evt);
	}

	@Override
	public List<EventTypes> getAllEventTypes() {
		return etr.getAllEventTypes();
	}

	@Override
	public EventTypes getEventType(int id) {
		return etr.getEventType(id);
	}

	@Override
	public EventTypes updateEventTypes(EventTypes change) {
		return etr.updateEventTypes(change);
	}

	@Override
	public EventTypes deleteEventTypes(EventTypes evt) {
		return etr.deleteEventTypes(evt);
	}

	@Override
	public double addPercentMods(double d) {
		EventTypes eventtype = new EventTypes();
		eventtype = etr.getEventType(eventtype.getId());
		ReimbRequestServiceImpl rrsi = new ReimbRequestServiceImpl(null);
		if (eventtype.getTypename() == "university course") {
			eventtype.setCoveragepercent(.80);
			double finalamount = eventtype.getCoveragepercent() * rrsi.proposedAmount(0);
			return finalamount;
		}
		if (eventtype.getTypename() == "seminar") {
			eventtype.setCoveragepercent(.60);
			double finalamount = eventtype.getCoveragepercent() * rrsi.proposedAmount(0);
			return finalamount;
		}
		if (eventtype.getTypename() == "certificate prep") {
			eventtype.setCoveragepercent(.75);
			double finalamount = eventtype.getCoveragepercent() * rrsi.proposedAmount(0);
			return finalamount;
		}
		if (eventtype.getTypename() == "certificate") {
			eventtype.setCoveragepercent(1);
			double finalamount = eventtype.getCoveragepercent() * rrsi.proposedAmount(0);
			return finalamount;
		}
		if (eventtype.getTypename() == "technical training") {
			eventtype.setCoveragepercent(.90);
			double finalamount = eventtype.getCoveragepercent() * rrsi.proposedAmount(0);
			return finalamount;
		} else {
			eventtype.setCoveragepercent(.30);
			double finalamount = eventtype.getCoveragepercent() * rrsi.proposedAmount(0);
			return finalamount;
		}
	}

}
