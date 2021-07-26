package com.revature.app;

import com.revature.controllers.TRMSController;
import com.revature.repos.CommRepo;
import com.revature.repos.CommRepoHBImpl;
import com.revature.repos.DeniedReqHBImpl;
import com.revature.repos.DeniedRequestsRepo;
import com.revature.repos.EmployeesRepo;
import com.revature.repos.EmployeesRepoHBImpl;
import com.revature.repos.EventTypeRepo;
import com.revature.repos.EventTypesRepoHBImpl;
import com.revature.repos.EventsRepo;
import com.revature.repos.EventsRepoHBImpl;
import com.revature.repos.GradingFormatsHBImpl;
import com.revature.repos.GradingFormatsRepo;
import com.revature.repos.ReimbRequestsRepo;
import com.revature.repos.ReimbRequestsRepoHBImpl;
import com.revature.repos.ReimbursementsRepo;
import com.revature.repos.ReimbursementsRepoHBImpl;
import com.revature.repos.RequestAttachmentsRepo;
import com.revature.repos.RequestAttachmentsRepoHBImpl;
import com.revature.services.CommServices;
import com.revature.services.CommServicesImpl;
import com.revature.services.DeniedRequestServiceImpl;
import com.revature.services.DeniedRequestsServices;
import com.revature.services.EmployeeServicesImpl;
import com.revature.services.EmployeesServices;
import com.revature.services.EventServiceImpl;
import com.revature.services.EventServices;
import com.revature.services.EventTypeServices;
import com.revature.services.EventTypesServicesImpl;
import com.revature.services.GradingFormatServiceImpl;
import com.revature.services.GradingFormatServices;
import com.revature.services.ReimbRequestServiceImpl;
import com.revature.services.ReimbRequestServices;
import com.revature.services.ReimbursementServices;
import com.revature.services.ReimbursementServicesImpl;
import com.revature.services.RequestAttachmentServiceImpl;
import com.revature.services.RequestAttachmentServices;

import io.javalin.Javalin;

public class TRMSApp {
	public static void main(String[] args) {
		// Establish our Javalin Object
		Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());

		// Establish the Routes/Endpoints Javalin will manage
		establishRoutes(app);

		// Run Javalin
		app.start(7001);

	}

	private static void establishRoutes(Javalin app) {
		// Going to define a list of routes/endpoints Javalin will manage
		CommRepo cr = new CommRepoHBImpl();
		CommServices cs = new CommServicesImpl(cr);
		TRMSController cc = new TRMSController(cs);

		;

		DeniedRequestsRepo drr = new DeniedReqHBImpl();
		DeniedRequestsServices drs = new DeniedRequestServiceImpl(drr);
		TRMSController drc = new TRMSController(drs);

		EmployeesRepo er = new EmployeesRepoHBImpl();
		EmployeesServices es = new EmployeeServicesImpl(er);
		TRMSController ec = new TRMSController(es);

		EventsRepo evr = new EventsRepoHBImpl();
		EventServices evs = new EventServiceImpl(evr);
		TRMSController evc = new TRMSController(evs);

		EventTypeRepo evtr = new EventTypesRepoHBImpl();
		EventTypeServices evts = new EventTypesServicesImpl(evtr);
		TRMSController evtc = new TRMSController(evts);

		GradingFormatsRepo gfr = new GradingFormatsHBImpl();
		GradingFormatServices gfs = new GradingFormatServiceImpl(gfr);
		TRMSController gfc = new TRMSController(gfs);

		ReimbRequestsRepo rrr = new ReimbRequestsRepoHBImpl();
		ReimbRequestServices rrs = new ReimbRequestServiceImpl(rrr);
		TRMSController rrc = new TRMSController(rrs);
		rrr.getAllReimbRequests();

		ReimbursementsRepo rr = new ReimbursementsRepoHBImpl();
		ReimbursementServices rs = new ReimbursementServicesImpl(rr);
		TRMSController rt = new TRMSController(rs);

		RequestAttachmentsRepo rar = new RequestAttachmentsRepoHBImpl();
		RequestAttachmentServices ras = new RequestAttachmentServiceImpl(rar);
		TRMSController rat = new TRMSController(ras);

		// Establish a route to the 'landing' page
		app.get("/", (ctx) -> ctx.result("This is Our TRMS App Home Page!"));

		// Establish routes to every possibility
		app.get("/comms", cc.getAllCommunication);
		app.get("/comms/:communication_id", cc.getCommunicationById);
		app.post("/comms/:communication_id", cc.createCommunication);
		app.put("/comms/:communication_id", cc.updateCommunication);
		app.delete("/comms/:communication_id", cc.deleteCommunication);
		app.get("/comms/:communication_id/messagedate", cc.messagedate);
		app.get("/comms/:communication_id/supervisor", cc.supervisorComm);
		app.get("/comms/:communication_id/depthead", cc.deptheadComm);
		app.get("/comms/:communication_id/benco", cc.bencoComm);

		app.get("/deniedreq", drc.getAllDeniedRequests);
		app.get("/deniedreq/:deniedrequest_id", drc.getDeniedRequestById);
		app.post("/deniedreq/:deniedrequest_id", drc.createDeniedRequest);
		app.put("/deniedreq/:deniedrequest_id", drc.updateDeniedRequests);
		app.delete("/deniedreq/:deniedrequest_id", drc.deleteDeniedRequests);
		app.get("/deniedreq/:deniedrequest_id/decisiondate", drc.getDecisionDate);

		app.get("/employee", ec.getAllEmployees);
		app.get("/employee/:employee_id", ec.getEmployeeById);
		app.post("/employee/:employee_id", ec.createEmployee);
		app.put("/employee/:employee_id", ec.updateEmployees);
		app.delete("/employee/:employee_id", ec.deleteEmployees);

		app.get("/events", evc.getAllEvents);
		app.get("/events/:events_id", evc.getEventById);
		app.post("/events/:events_id", evc.createEvents);
		app.put("/events/:events_id", evc.updateEvents);
		app.delete("/events/:events_id", evc.deleteEvents);
		app.get("/events/:events_id/eventdate", evc.dateEvents);
		app.get("/events/:events_id/eventtime", evc.timeEvents);

		app.get("/eventTypes", evtc.getAllEventTypes);
		app.get("/eventTypes/:eventTypes_id", evtc.getEventTypeById);
		app.post("/eventTypes/:eventTypes_id", evtc.createEventTypes);
		app.put("/eventTypes/:eventTypes_id", evtc.updateEventTypes);
		app.delete("/eventTypes/:eventTypes_id", evtc.deleteEventTypes);
		app.put("/eventTypes/:eventTypes_id/coveragepercent", evtc.addPercentMods);

		app.get("/gradingformats", gfc.getAllGradingFormats);
		app.get("gradingformats/:gradingformat_id", gfc.getGradingFormatById);
		app.post("gradingformats/:gradingformat_id", gfc.createGradingFormats);
		app.put("gradingformats/:gradingformat_id", gfc.updateGradingFormats);
		app.delete("gradingformats/:gradingformat_id", gfc.deleteGradingFormats);

		app.get("/reimbrequests", rrc.getAllReimbRequests);
		app.get("/reimbrequests/:rr_id", rrc.getReimbRequestById);
		app.post("/reimbrequests/:rr_id", rrc.createReimbRequests);
		app.put("/reimbrequests/:rr_id", rrc.updateReimbRequests);
		app.delete("/reimbrequests/:rr_id", rrc.deleteReimbRequests);
		app.get("/reimbrequests/:rr_id/lastupdated", rrc.lastUpdated);
		app.put("/reimbrequests/:rr_id/urgent", rrc.urgentReimbRequests);
		app.put("/reimbrequests/:rr_id/proposedamount", rrc.proposedAmount);

		app.get("/reimbursements", rt.getAllReimbursements);
		app.get("/reimbursements/:reimbursements_id", rt.getReimbursementById);
		app.post("/reimbursements/:reimbursements_id", rt.createReimbursements);
		app.put("/reimbursements/:reimbursements_id", rt.updateReimbursements);
		app.delete("/reimbursements/:reimbursements_id", rt.deleteReimbursements);
		app.get("/reimbursements/:reimbursements_id/disbursaldate", rt.disbursedondate);

		app.get("/requestattachments", rat.getAllRequestAttachments);
		app.get("/requestattachments/:requestattachment_id", rat.getRequestAttachmentById);
		app.post("/requestattachments/:requestattachment_id", rat.createRequestAttachments);
		app.put("/requestattachments/:requestattachment_id", rat.updateRequestAttachments);
		app.delete("/requestattachments/:requestattachment_id", rat.deleteRequestAttachments);
		app.post("/requestattachments/:requestattachment_id/attach", rat.addAttachFunctionality);

	}
}
