package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.models.ReimbRequests;
import com.revature.util.HibernateUtil;

public class ReimbRequestsRepoHBImpl implements ReimbRequestsRepo {

	@Override
	public ReimbRequests addReimbRequests(ReimbRequests rrr) {
		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			rrr.setId((int) sess.save(rrr));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			rrr = null;
		} finally {
			sess.close();
		}
		return rrr;
	}

	@Override
	public List<ReimbRequests> getAllReimbRequests() {
		Session sess = HibernateUtil.getSession();
		List<ReimbRequests> rrr = null;
		try {
			// select * FROM actors
			// HQL- want you to be able to just use your java classes
			rrr = sess.createQuery("FROM ReimbRequests").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return rrr;
	}

	@Override
	public ReimbRequests getReimbRequest(int id) {
		Session sess = HibernateUtil.getSession();
		ReimbRequests rrr = null;

		try {
			rrr = sess.get(ReimbRequests.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return rrr;
	}

	@Override
	public ReimbRequests updateReimbRequests(ReimbRequests change) {
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
	public ReimbRequests deleteReimbRequests(ReimbRequests rrr) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.delete(rrr);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return rrr;
	}

}
