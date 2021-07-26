package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.models.RequestAttachments;
import com.revature.util.HibernateUtil;

public class RequestAttachmentsRepoHBImpl implements RequestAttachmentsRepo {

	@Override
	public RequestAttachments addRequestAttachments(RequestAttachments rar) {
		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			rar.setId((int) sess.save(rar));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			rar = null;
		} finally {
			sess.close();
		}
		return rar;
	}

	@Override
	public List<RequestAttachments> getAllRequestAttachments() {
		Session sess = HibernateUtil.getSession();
		List<RequestAttachments> rar = null;
		try {
			// select * FROM actors
			// HQL- want you to be able to just use your java classes
			rar = sess.createQuery("FROM RequestAttachments").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return rar;
	}

	@Override
	public RequestAttachments getRequestAttachment(int id) {
		Session sess = HibernateUtil.getSession();
		RequestAttachments rar = null;

		try {
			rar = sess.get(RequestAttachments.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return rar;
	}

	@Override
	public RequestAttachments updateRequestAttachments(RequestAttachments change) {
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
	public RequestAttachments deleteRequestAttachments(RequestAttachments rar) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.delete(rar);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return rar;
	}

}
