package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.models.Reimbursements;
import com.revature.util.HibernateUtil;

public class ReimbursementsRepoHBImpl implements ReimbursementsRepo {

	@Override
	public Reimbursements addReimbursements(Reimbursements rr) {
		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			rr.setId((int) sess.save(rr));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			rr = null;
		} finally {
			sess.close();
		}
		return rr;
	}

	@Override
	public List<Reimbursements> getAllReimbursements() {
		Session sess = HibernateUtil.getSession();
		List<Reimbursements> rr = null;
		try {
			// select * FROM actors
			// HQL- want you to be able to just use your java classes
			rr = sess.createQuery("FROM Reimbursements").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return rr;
	}

	@Override
	public Reimbursements getReimbursement(int id) {
		Session sess = HibernateUtil.getSession();
		Reimbursements rr = null;

		try {
			rr = sess.get(Reimbursements.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return rr;
	}

	@Override
	public Reimbursements updateReimbursements(Reimbursements change) {
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
	public Reimbursements deleteReimbursements(Reimbursements rr) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.delete(rr);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return rr;
	}

}
