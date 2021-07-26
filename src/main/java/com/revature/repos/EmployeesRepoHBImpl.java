package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employees;
import com.revature.util.HibernateUtil;

public class EmployeesRepoHBImpl implements EmployeesRepo {

	@Override
	public Employees addEmployee(Employees e) {
		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			e.setId((int) sess.save(e));
			sess.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			sess.getTransaction().rollback();
			e = null;
		} finally {
			sess.close();
		}
		return e;
	}

	@Override
	public List<Employees> getAllEmployees() {
		Session sess = HibernateUtil.getSession();
		List<Employees> e = null;
		try {
			// select * FROM actors
			// HQL- want you to be able to just use your java classes
			e = sess.createQuery("FROM Employees").list();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			sess.close();
		}

		return e;
	}

	@Override
	public Employees getEmployee(int id) {
		Session sess = HibernateUtil.getSession();
		Employees e = null;

		try {
			e = sess.get(Employees.class, id);
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			sess.close();
		}

		return e;
	}

	@Override
	public Employees updateEmployees(Employees change) {
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
	public Employees deleteEmployees(Employees e) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.delete(e);
			tx.commit();

		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return e;
	}

}
