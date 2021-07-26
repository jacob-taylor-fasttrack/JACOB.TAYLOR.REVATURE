package com.revature.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.revature.models.Communication;
import com.revature.models.DeniedRequests;
import com.revature.models.Employees;
import com.revature.models.EventTypes;
import com.revature.models.Events;
import com.revature.models.GradingFormats;
import com.revature.models.ReimbRequests;
import com.revature.models.Reimbursements;
import com.revature.models.RequestAttachments;
import com.revature.services.CommServices;
import com.revature.services.DeniedRequestsServices;
import com.revature.services.EmployeesServices;
import com.revature.services.EventServices;
import com.revature.services.EventTypeServices;
import com.revature.services.GradingFormatServices;
import com.revature.services.ReimbRequestServices;
import com.revature.services.ReimbursementServices;
import com.revature.services.RequestAttachmentServices;

import io.javalin.http.Handler;

public class TRMSController {
	public static Logger log = Logger.getLogger(TRMSController.class);
	public CommServices cs;
	public DeniedRequestsServices drs;
	public EmployeesServices ems;
	public EventServices evs;
	public EventTypeServices ets;
	public GradingFormatServices gfs;
	public ReimbRequestServices rrs;
	public ReimbursementServices rs;
	public RequestAttachmentServices ras;

	Gson gson = new Gson();

	public TRMSController(CommServices cs) {
		this.cs = cs;
	}

	public Handler getAllCommunication = (context) -> {

		// creates a list from method
		List<Communication> comms = cs.getAllCommunication();

		context.result(gson.toJson(comms));
	};

	public Handler getCommunicationById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("communication_id");
		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		Communication c = cs.getCommunication(id);

		if (c != null) {
			ctx.result(gson.toJson(c));

		} else {
			log.info("Missing Client Info");
			ctx.status(404);
		}

	};
	public Handler createCommunication = (context) -> {

		// Gets values from postman (body)
		Communication c = gson.fromJson(context.body(), Communication.class);

		c = cs.addCommunication(c);

		if (c != null) {
			context.result(gson.toJson(c));
			context.status(201);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler updateCommunication = (context) -> {

		// gets values from postman (body)
		Communication c = gson.fromJson(context.body(), Communication.class);

		// calls specified method
		c = cs.updateCommunication(c);

		if (c != null) {
			context.result(gson.toJson(c));
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler deleteCommunication = (context) -> {

		// gets values from app.class request

		Communication c = gson.fromJson(context.body(), Communication.class);

		try {
			context.result(gson.toJson(c));
			log.info("Changes Id to interger");
		} catch (NumberFormatException e) {
			log.error("Error with changing id" + e.getMessage());
			context.status(404);
		}

		// Calls specified method

		c = cs.deleteCommunication(c);

		if (c != null) {
			// sends results to postman
			context.result(gson.toJson(c));
			context.status(204);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
		;

	};
	public Handler messagedate = (context) -> {
		String coverage = context.pathParam("messagedate");

		String messagedate;

		try {
			messagedate = (coverage).toString();
			log.info("Seting coverage to double");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving coverage" + e.getMessage());
			messagedate = null;
		}

		// Calls specific method
		messagedate = cs.messagedate(messagedate);

		if (messagedate != null) {
			context.result(gson.toJson(messagedate));

		} else {
			log.info("Missing Client Info");
			context.status(404);
		}

	};
	public Handler supervisorComm = (context) -> {
		// gets values from postman (body)
		Communication c = gson.fromJson(context.body(), Communication.class);

		// calls specified method
		c = cs.supervisorComm(c);

		if (c != null) {
			context.result(gson.toJson(c));
		} else {
			log.info("Missing Supervisor Info");
			context.status(404);
		}
	};

	public Handler deptheadComm = (context) -> {
		// gets values from postman (body)
		Communication c = gson.fromJson(context.body(), Communication.class);

		// calls specified method
		c = cs.deptheadComm(c);

		if (c != null) {
			context.result(gson.toJson(c));
		} else {
			log.info("Missing depthead Info");
			context.status(404);
		}
	};

	public Handler bencoComm = (context) -> {
		// gets values from postman (body)
		Communication c = gson.fromJson(context.body(), Communication.class);

		// calls specified method
		c = cs.bencoComm(c);

		if (c != null) {
			context.result(gson.toJson(c));
		} else {
			log.info("Missing Benco Info");
			context.status(404);
		}
	};

	public TRMSController(DeniedRequestsServices drs) {
		this.drs = drs;
	}

	public Handler getAllDeniedRequests = (context) -> {

		// creates a list from method
		List<DeniedRequests> deniedreq = drs.getAllDeniedRequests();

		context.result(gson.toJson(deniedreq));
	};

	public Handler getDeniedRequestById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("deniedrequest_id");

		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		DeniedRequests dr = drs.getDeniedRequest(id);

		if (dr != null) {
			ctx.result(gson.toJson(dr));

		} else {
			log.info("Missing Client Info");
			ctx.status(404);
		}

	};
	public Handler createDeniedRequest = (context) -> {

		// Gets values from postman (body)
		DeniedRequests dr = gson.fromJson(context.body(), DeniedRequests.class);

		dr = drs.addDeniedRequest(dr);

		if (dr != null) {
			context.result(gson.toJson(dr));
			context.status(201);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler updateDeniedRequests = (context) -> {

		// gets values from postman (body)
		DeniedRequests dr = gson.fromJson(context.body(), DeniedRequests.class);

		// calls specified method
		dr = drs.updateDeniedRequests(dr);

		if (dr != null) {
			context.result(gson.toJson(dr));
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler deleteDeniedRequests = (context) -> {

		// gets values from app.class request

		DeniedRequests dr = gson.fromJson(context.body(), DeniedRequests.class);

		try {
			context.result(gson.toJson(dr));
			log.info("Changes Id to interger");
		} catch (NumberFormatException e) {
			log.error("Error with changing id" + e.getMessage());
			context.status(404);
		}

		// Calls specified method

		dr = drs.deleteDeniedRequests(dr);

		if (dr != null) {
			// sends results to postman
			context.result(gson.toJson(dr));
			context.status(204);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
		;

	};

	public Handler getDecisionDate = (context) -> {
		String decision = context.pathParam("decisionmade");

		String decisiondate;

		try {
			decisiondate = (decision).toString();
			log.info("Seting coverage to double");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving coverage" + e.getMessage());
			decisiondate = null;
		}

		// Calls specific method
		decisiondate = drs.getDecisionDate(decisiondate);

		if (decisiondate != null) {
			context.result(gson.toJson(decisiondate));

		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public TRMSController(EmployeesServices ems) {
		this.ems = ems;
	}

	public Handler getAllEmployees = (context) -> {

		// creates a list from method
		List<Employees> employees = ems.getAllEmployees();

		context.result(gson.toJson(employees));
	};

	public Handler getEmployeeById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("employee_id");

		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		Employees e = ems.getEmployee(id);

		if (e != null) {
			ctx.result(gson.toJson(e));

		} else {
			log.info("Missing Client Info");
			ctx.status(404);
		}

	};
	public Handler createEmployee = (context) -> {

		// Gets values from postman (body)
		Employees e = gson.fromJson(context.body(), Employees.class);

		e = ems.addEmployee(e);

		if (e != null) {
			context.result(gson.toJson(e));
			context.status(201);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler updateEmployees = (context) -> {

		// gets values from postman (body)
		Employees e = gson.fromJson(context.body(), Employees.class);

		// calls specified method
		e = ems.updateEmployees(e);

		if (e != null) {
			context.result(gson.toJson(e));
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler deleteEmployees = (context) -> {

		// gets values from app.class request

		Employees e = gson.fromJson(context.body(), Employees.class);

		try {
			context.result(gson.toJson(e));
			log.info("Changes Id to interger");
		} catch (NumberFormatException f) {
			log.error("Error with changing id" + f.getMessage());
			context.status(404);
		}

		// Calls specified method

		e = ems.deleteEmployees(e);

		if (e != null) {
			// sends results to postman
			context.result(gson.toJson(e));
			context.status(204);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
		;

	};

	public TRMSController(EventServices evs) {
		this.evs = evs;
	}

	public Handler getAllEvents = (context) -> {

		// creates a list from method
		List<Events> events = evs.getAllEvents();

		context.result(gson.toJson(events));
	};

	public Handler getEventById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("events_id");

		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		Events ev = evs.getEvent(id);

		if (ev != null) {
			ctx.result(gson.toJson(ev));

		} else {
			log.info("Missing Client Info");
			ctx.status(404);
		}

	};
	public Handler createEvents = (context) -> {

		// Gets values from postman (body)
		Events ev = gson.fromJson(context.body(), Events.class);

		ev = evs.addEvents(ev);

		if (ev != null) {
			context.result(gson.toJson(ev));
			context.status(201);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler updateEvents = (context) -> {

		// gets values from postman (body)
		Events ev = gson.fromJson(context.body(), Events.class);

		// calls specified method
		ev = evs.updateEvents(ev);

		if (ev != null) {
			context.result(gson.toJson(ev));
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler deleteEvents = (context) -> {

		// gets values from app.class request

		Events ev = gson.fromJson(context.body(), Events.class);

		try {
			context.result(gson.toJson(ev));
			log.info("Changes Id to interger");
		} catch (NumberFormatException f) {
			log.error("Error with changing id" + f.getMessage());
			context.status(404);
		}

		// Calls specified method

		ev = evs.deleteEvents(ev);

		if (ev != null) {
			// sends results to postman
			context.result(gson.toJson(ev));
			context.status(204);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
		;

	};

	public Handler dateEvents = (context) -> {
		String events = context.pathParam("eventdate");

		String eventdate;

		try {
			eventdate = (events).toString();
			log.info("Seting coverage to double");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving coverage" + e.getMessage());
			eventdate = null;
		}

		// Calls specific method
		eventdate = evs.dateEvent(eventdate);

		if (eventdate != null) {
			context.result(gson.toJson(eventdate));

		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};
	public Handler timeEvents = (context) -> {
		String time = context.pathParam("eventtime");

		String eventtime;

		try {
			eventtime = (time).toString();
			log.info("Seting coverage to double");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving coverage" + e.getMessage());
			eventtime = null;
		}

		// Calls specific method
		eventtime = evs.timeEvent(eventtime);

		if (eventtime != null) {
			context.result(gson.toJson(eventtime));

		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public TRMSController(EventTypeServices ets) {
		this.ets = ets;
	}

	public Handler getAllEventTypes = (context) -> {

		// creates a list from method
		List<EventTypes> eventTypes = ets.getAllEventTypes();

		context.result(gson.toJson(eventTypes));
	};

	public Handler getEventTypeById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("eventTypes_id");

		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		EventTypes et = ets.getEventType(id);

		if (et != null) {
			ctx.result(gson.toJson(et));

		} else {
			log.info("Missing Client Info");
			ctx.status(404);
		}

	};
	public Handler createEventTypes = (context) -> {

		// Gets values from postman (body)
		EventTypes et = gson.fromJson(context.body(), EventTypes.class);

		et = ets.addEventTypes(et);

		if (et != null) {
			context.result(gson.toJson(et));
			context.status(201);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler updateEventTypes = (context) -> {

		// gets values from postman (body)
		EventTypes et = gson.fromJson(context.body(), EventTypes.class);

		// calls specified method
		et = ets.updateEventTypes(et);

		if (et != null) {
			context.result(gson.toJson(et));
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler deleteEventTypes = (context) -> {

		// gets values from app.class request

		EventTypes et = gson.fromJson(context.body(), EventTypes.class);

		try {
			context.result(gson.toJson(et));
			log.info("Changes Id to interger");
		} catch (NumberFormatException f) {
			log.error("Error with changing id" + f.getMessage());
			context.status(404);
		}

		// Calls specified method

		et = ets.deleteEventTypes(et);

		if (et != null) {
			// sends results to postman
			context.result(gson.toJson(et));
			context.status(204);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
		;

	};
	public Handler addPercentMods = (context) -> {
		// gets values from app.class request
		String coverage = context.pathParam("coveragepercent");

		double cpercent;

		try {
			cpercent = Double.parseDouble(coverage);
			log.info("Seting coverage to double");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving coverage" + e.getMessage());
			cpercent = -1;
		}

		// Calls specific method
		double et = ets.addPercentMods(cpercent);

		if (et != 0) {
			context.result(gson.toJson(et));

		} else {
			log.info("Missing Client Info");
			context.status(404);
		}

	};

	public TRMSController(GradingFormatServices gfs) {
		this.gfs = gfs;
	}

	public Handler getAllGradingFormats = (context) -> {

		// creates a list from method
		List<GradingFormats> gf = gfs.getAllGradingFormats();

		context.result(gson.toJson(gf));
	};

	public Handler getGradingFormatById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("gradingformat_id");

		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		GradingFormats gf = gfs.getGradingFormat(id);

		if (gf != null) {
			ctx.result(gson.toJson(gf));

		} else {
			log.info("Missing Grading Format Info");
			ctx.status(404);
		}

	};
	public Handler createGradingFormats = (context) -> {

		// Gets values from postman (body)
		GradingFormats gf = gson.fromJson(context.body(), GradingFormats.class);

		gf = gfs.addGradingFormats(gf);

		if (gf != null) {
			context.result(gson.toJson(gf));
			context.status(201);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler updateGradingFormats = (context) -> {

		// gets values from postman (body)
		GradingFormats gf = gson.fromJson(context.body(), GradingFormats.class);

		// calls specified method
		gf = gfs.updateGradingFormats(gf);

		if (gf != null) {
			context.result(gson.toJson(gf));
		} else {
			log.info("Missing Grading Formats Info");
			context.status(404);
		}
	};

	public Handler deleteGradingFormats = (context) -> {

		// gets values from app.class request

		GradingFormats gf = gson.fromJson(context.body(), GradingFormats.class);

		try {
			context.result(gson.toJson(gf));
			log.info("Changes Id to interger");
		} catch (NumberFormatException f) {
			log.error("Error with changing id" + f.getMessage());
			context.status(404);
		}

		// Calls specified method

		gf = gfs.deleteGradingFormats(gf);

		if (gf != null) {
			// sends results to postman
			context.result(gson.toJson(gf));
			context.status(204);
		} else {
			log.info("Missing Grading Formats Info");
			context.status(404);
		}
		;

	};

	public TRMSController(ReimbRequestServices rrs) {
		this.rrs = rrs;
	}

	public Handler getAllReimbRequests = (context) -> {

		// creates a list from method
		List<ReimbRequests> rr = rrs.getAllReimbRequests();

		context.result(gson.toJson(rr));
	};

	public Handler getReimbRequestById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("rr_id");

		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		ReimbRequests rr = rrs.getReimbRequest(id);

		if (rr != null) {
			ctx.result(gson.toJson(rr));

		} else {
			log.info("Missing Grading Format Info");
			ctx.status(404);
		}

	};
	public Handler createReimbRequests = (context) -> {

		// Gets values from postman (body)
		ReimbRequests rr = gson.fromJson(context.body(), ReimbRequests.class);

		rr = rrs.addReimbRequests(rr);

		if (rr != null) {
			context.result(gson.toJson(rr));
			context.status(201);
		} else {
			log.info("Missing Reimb Request Info");
			context.status(404);
		}
	};

	public Handler updateReimbRequests = (context) -> {

		// gets values from postman (body)
		ReimbRequests rr = gson.fromJson(context.body(), ReimbRequests.class);

		// calls specified method
		rr = rrs.updateReimbRequests(rr);

		if (rr != null) {
			context.result(gson.toJson(rr));
		} else {
			log.info("Missing Reimb Request Info");
			context.status(404);
		}
	};

	public Handler deleteReimbRequests = (context) -> {

		// gets values from app.class request

		ReimbRequests rr = gson.fromJson(context.body(), ReimbRequests.class);

		try {
			context.result(gson.toJson(rr));
			log.info("Changes Id to interger");
		} catch (NumberFormatException f) {
			log.error("Error with changing id" + f.getMessage());
			context.status(404);
		}

		// Calls specified method

		rr = rrs.deleteReimbRequests(rr);

		if (rr != null) {
			// sends results to postman
			context.result(gson.toJson(rr));
			context.status(204);
		} else {
			log.info("Missing Reimb Request Info");
			context.status(404);
		}
		;

	};
	public Handler lastUpdated = (context) -> {
		String updated = context.pathParam("lastupdated");

		String updateddate;

		try {
			updateddate = (updated).toString();
			log.info("Seting coverage to double");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving coverage" + e.getMessage());
			updateddate = null;
		}

		// Calls specific method
		updateddate = rrs.lastUpdated(updateddate);

		if (updateddate != null) {
			context.result(gson.toJson(updateddate));

		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};
	public Handler urgentReimbRequests = (context) -> {
		// gets values from app.class request
		String input = context.pathParam("urgent");

		int urgent;

		try {
			urgent = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving urgent" + e.getMessage());
			urgent = -1;
		}

		// Calls specific method
		ReimbRequests rr = rrs.urgentReimbRequests(urgent);

		if (rr != null) {
			context.result(gson.toJson(rr));

		} else {
			log.info("Missing urgent Info");
			context.status(404);
		}
	};
	public Handler proposedAmount = (context) -> {
		String amount = context.pathParam("proposedamount");

		double proposedamount;

		try {
			proposedamount = Double.parseDouble(amount);
			log.info("Seting amount to double");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving amount" + e.getMessage());
			proposedamount = -1;
		}

		// Calls specific method
		double rrt = rrs.proposedAmount(proposedamount);

		if (rrt != 0) {
			context.result(gson.toJson(rrt));

		} else {
			log.info("Missing Reimb Request Info");
			context.status(404);
		}
	};

	public TRMSController(ReimbursementServices rs) {
		this.rs = rs;
	}

	public Handler getAllReimbursements = (context) -> {

		// creates a list from method
		List<Reimbursements> r = rs.getAllReimbursements();

		context.result(gson.toJson(r));
	};

	public Handler getReimbursementById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("reimbursements_id");

		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		Reimbursements r = rs.getReimbursement(id);

		if (r != null) {
			ctx.result(gson.toJson(r));

		} else {
			log.info("Missing Reimbursement Info");
			ctx.status(404);
		}

	};
	public Handler createReimbursements = (context) -> {

		// Gets values from postman (body)
		Reimbursements r = gson.fromJson(context.body(), Reimbursements.class);

		r = rs.addReimbursements(r);

		if (r != null) {
			context.result(gson.toJson(r));
			context.status(201);
		} else {
			log.info("Missing Reimb Request Info");
			context.status(404);
		}
	};

	public Handler updateReimbursements = (context) -> {

		// gets values from postman (body)
		Reimbursements r = gson.fromJson(context.body(), Reimbursements.class);

		// calls specified method
		r = rs.updateReimbursements(r);

		if (r != null) {
			context.result(gson.toJson(r));
		} else {
			log.info("Missing Reimbursements Info");
			context.status(404);
		}
	};

	public Handler deleteReimbursements = (context) -> {

		// gets values from app.class request

		Reimbursements r = gson.fromJson(context.body(), Reimbursements.class);

		try {
			context.result(gson.toJson(r));
			log.info("Changes Id to interger");
		} catch (NumberFormatException f) {
			log.error("Error with changing id" + f.getMessage());
			context.status(404);
		}

		// Calls specified method

		r = rs.deleteReimbursements(r);

		if (r != null) {
			// sends results to postman
			context.result(gson.toJson(r));
			context.status(204);
		} else {
			log.info("Missing Reimbursement Info");
			context.status(404);
		}
		;

	};
	public Handler disbursedondate = (context) -> {
		String disbursed = context.pathParam("disbursedon");

		String disbursedondate;

		try {
			disbursedondate = (disbursed).toString();
			log.info("Seting coverage to double");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving coverage" + e.getMessage());
			disbursedondate = null;
		}

		// Calls specific method
		disbursedondate = rs.disbursedondate(disbursedondate);

		if (disbursedondate != null) {
			context.result(gson.toJson(disbursedondate));

		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public TRMSController(RequestAttachmentServices ras) {
		this.ras = ras;
	}

	public Handler getAllRequestAttachments = (context) -> {

		// creates a list from method
		List<RequestAttachments> ra = ras.getAllRequestAttachments();

		context.result(gson.toJson(ra));
	};

	public Handler getRequestAttachmentById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("requestattachment_id");

		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		RequestAttachments ra = ras.getRequestAttachment(id);

		if (ra != null) {
			ctx.result(gson.toJson(ra));

		} else {
			log.info("Missing Reimbursement Info");
			ctx.status(404);
		}

	};
	public Handler createRequestAttachments = (context) -> {

		// Gets values from postman (body)
		RequestAttachments ra = gson.fromJson(context.body(), RequestAttachments.class);

		ra = ras.addRequestAttachments(ra);

		if (ra != null) {
			context.result(gson.toJson(ra));
			context.status(201);
		} else {
			log.info("Missing Request Attachment Info");
			context.status(404);
		}
	};

	public Handler updateRequestAttachments = (context) -> {

		// gets values from postman (body)
		RequestAttachments ra = gson.fromJson(context.body(), RequestAttachments.class);

		// calls specified method
		ra = ras.updateRequestAttachments(ra);

		if (ra != null) {
			context.result(gson.toJson(ra));
		} else {
			log.info("Missing Request Attachment Info");
			context.status(404);
		}
	};

	public Handler deleteRequestAttachments = (context) -> {

		// gets values from app.class request

		RequestAttachments ra = gson.fromJson(context.body(), RequestAttachments.class);

		try {
			context.result(gson.toJson(ra));
			log.info("Changes Id to interger");
		} catch (NumberFormatException f) {
			log.error("Error with changing id" + f.getMessage());
			context.status(404);
		}

		// Calls specified method

		ra = ras.deleteRequestAttachments(ra);

		if (ra != null) {
			// sends results to postman
			context.result(gson.toJson(ra));
			context.status(204);
		} else {
			log.info("Missing Reimbursement Info");
			context.status(404);
		}
		;

	};

	public Handler addAttachFunctionality = (context) -> {
		String attach = context.pathParam("docurl");
		String attachurl;

		try {
			attachurl = (attach);
			log.info("Seting coverage to double");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving coverage" + e.getMessage());
			attachurl = null;
		}

		// Calls specific method
		attachurl = ras.addAttachFunctionality(attachurl);

		if (disbursedondate != null) {
			context.result(gson.toJson(disbursedondate));

		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};
}
