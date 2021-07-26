package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Events;
import com.revature.util.HibernateUtil;

public class EventsRepoHBImpl implements EventsRepo {

	@Override
	public Events addEvents(Events ev) {
		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			ev.setId((int) sess.save(ev));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			ev = null;
		} finally {
			sess.close();
		}
		return ev;
	}

	@Override
	public List<Events> getAllEvents() {
		Session sess = HibernateUtil.getSession();
		List<Events> ev = null;
		try {
			// select * FROM actors
			// HQL- want you to be able to just use your java classes
			ev = sess.createQuery("FROM Events").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return ev;
	}

	@Override
	public Events getEvent(int id) {
		Session sess = HibernateUtil.getSession();
		Events ev = null;

		try {
			ev = sess.get(Events.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return ev;
	}

	@Override
	public Events updateEvents(Events change) {
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
	public Events deleteEvents(Events ev) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.delete(ev);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return ev;
	}

}
