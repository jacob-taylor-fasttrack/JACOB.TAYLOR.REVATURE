package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.DeniedRequests;
import com.revature.util.HibernateUtil;

public class DeniedReqHBImpl implements DeniedRequestsRepo {

	@Override
	public DeniedRequests addDeniedRequest(DeniedRequests dr) {
		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			dr.setId((int) sess.save(dr));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			dr = null;
		} finally {
			sess.close();
		}
		return dr;
	}

	@Override
	public List<DeniedRequests> getAllDeniedRequests() {
		Session sess = HibernateUtil.getSession();
		List<DeniedRequests> denr = null;
		try {
			// select * FROM actors
			// HQL- want you to be able to just use your java classes
			denr = sess.createQuery("FROM DeniedRequests").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return denr;
	}

	@Override
	public DeniedRequests getDeniedRequest(int id) {
		Session sess = HibernateUtil.getSession();
		DeniedRequests dr = null;

		try {
			dr = sess.get(DeniedRequests.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return dr;
	}

	@Override
	public DeniedRequests updateDeniedRequests(DeniedRequests change) {
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
	public DeniedRequests deleteDeniedRequests(DeniedRequests dr) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.delete(dr);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return dr;
	}
}
