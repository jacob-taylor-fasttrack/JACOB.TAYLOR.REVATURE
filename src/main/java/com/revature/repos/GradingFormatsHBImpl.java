package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.GradingFormats;
import com.revature.util.HibernateUtil;

public class GradingFormatsHBImpl implements GradingFormatsRepo {

	@Override
	public GradingFormats addGradingFormats(GradingFormats gf) {
		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			gf.setId((int) sess.save(gf));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			gf = null;
		} finally {
			sess.close();
		}
		return gf;
	}

	@Override
	public List<GradingFormats> getAllGradingFormats() {
		Session sess = HibernateUtil.getSession();
		List<GradingFormats> gf = null;
		try {
			// select * FROM actors
			// HQL- want you to be able to just use your java classes
			gf = sess.createQuery("FROM GradingFormats").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return gf;
	}

	@Override
	public GradingFormats getGradingFormat(int id) {
		Session sess = HibernateUtil.getSession();
		GradingFormats gf = null;

		try {
			gf = sess.get(GradingFormats.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return gf;
	}

	@Override
	public GradingFormats updateGradingFormats(GradingFormats change) {
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
	public GradingFormats deleteGradingFormats(GradingFormats gf) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.delete(gf);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return gf;
	}

}
