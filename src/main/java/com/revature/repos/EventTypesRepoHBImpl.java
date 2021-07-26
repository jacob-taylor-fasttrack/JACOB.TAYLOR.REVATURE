package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.EventTypes;

import com.revature.util.HibernateUtil;

public class EventTypesRepoHBImpl implements EventTypeRepo {

	@Override
	public EventTypes addEventTypes(EventTypes evt) {
		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			evt.setId((int) sess.save(evt));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			evt = null;
		} finally {
			sess.close();
		}
		return evt;
	}

	@Override
	public List<EventTypes> getAllEventTypes() {
		Session sess = HibernateUtil.getSession();
		List<EventTypes> evt = null;
		try {
			// select * FROM actors
			// HQL- want you to be able to just use your java classes
			evt = sess.createQuery("FROM EventTypes").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return evt;
	}

	@Override
	public EventTypes getEventType(int id) {
		Session sess = HibernateUtil.getSession();
		EventTypes evt = null;

		try {
			evt = sess.get(EventTypes.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return evt;
	}

	@Override
	public EventTypes updateEventTypes(EventTypes change) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.update(change);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return change = null;
		} finally {
			sess.close();
		}

		return change;
	}

	@Override
	public EventTypes deleteEventTypes(EventTypes evt) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.delete(evt);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return evt;
	}

}
