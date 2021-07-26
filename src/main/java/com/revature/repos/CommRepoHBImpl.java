package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Communication;
import com.revature.util.HibernateUtil;

public class CommRepoHBImpl implements CommRepo {

	@Override
	public Communication addCommunication(Communication c) {
		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			c.setId((int) sess.save(c));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			c = null;
		} finally {
			sess.close();
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Communication> getAllCommunication() {
		Session sess = HibernateUtil.getSession();
		List<Communication> comms = null;
		try {
			// select * FROM actors
			// HQL- want you to be able to just use your java classes
			comms = sess.createQuery("FROM Communication").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return comms;
	}

	@Override
	public Communication getCommunication(int id) {
		Session sess = HibernateUtil.getSession();
		Communication c = null;

		try {
			c = sess.get(Communication.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return c;
	}

	@Override
	public Communication updateCommunication(Communication change) {
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
	public Communication deleteCommunication(Communication c) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.delete(c);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return c;
	}
}
