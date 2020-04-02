package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hbm.Products;

public class ProductsDao implements IProductsDao {

	@Override
	public void insertar(Products product) {
		// TODO Auto-generated method stub

		SessionFactory sessions = // Representa el archivo de configuracion principal
				new Configuration().configure().buildSessionFactory();
		Session session = sessions.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(product); // guarda o actualiza
			tx.commit();
			tx = null;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Could not acquire message" + e);
		} finally {
			session.close();
		}

	}

	public List<Products> leer(Products product) {
		SessionFactory sessions = // Representa el archivo de configuracion principal
				new Configuration().configure().buildSessionFactory();
		Session session = sessions.openSession();

		Transaction tx = null;
		Products products = null;

		try {
			tx = session.beginTransaction();
			// clase// crea una lista de tipo producto //////////// y selecciona los datos a
			// la lista
			List<Products> list = session.createQuery("from Products").list();
			tx.commit(); //
			tx = null;

			for (Products products1 : list) {// recorre la lista generada y los muestra
				products = products1;
				System.out.println("Numero de item: " + products1.getIdItem());

			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Could not acquire message" + e);
		} finally {
			session.close();
		}
		return (List<Products>) products;
	}

	public static Products select(int idItem) {

		SessionFactory sessions = // Representa el archivo de configuracion principal
				new Configuration().configure().buildSessionFactory();
		Session session = sessions.openSession();

		Transaction tx = null;
		Products product = null;

		try {
			tx = session.beginTransaction();

			Query q = session.createQuery("from Products where idItem= :idItem_param");
			q.setString(idItem, "idItem_param");

			List<Products> list = q.list(); // nombre de archivo de mapeo // generado(Usuario.hbm.xml)

			for (Products p : list) {
				product = p;
			}

			tx.commit();
			session.saveOrUpdate(product); // guarda o actualiza
			tx = null;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Could not acquire message" + e);
		} finally {
			session.close();
		}
		return product;

	}

	public static  int borrar(int idItem) {
		// TODO Auto-generated method stub
		SessionFactory sessions =
				new Configuration().configure().buildSessionFactory();
		Session session = sessions.openSession();

		Transaction tx = null;
		Products product = null;

		try {
			tx = session.beginTransaction();

			Query q = session.createQuery("from Products where idItem= :idItem_param");
			q.setString(idItem, "idItem_param");

			List<Products> list = q.list(); // nombre de archivo de mapeo // generado(Usuario.hbm.xml)

			for (Products p : list) {
				product = p;
			}

			tx.commit();
			session.saveOrUpdate(product); // guarda o actualiza
			tx = null;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Could not acquire message" + e);
		} finally {
			session.close();
		}

		return 0;
	}

	@Override
	public int borrar(Products product) {
		// TODO Auto-generated method stub
		SessionFactory sessions = // Representa el archivo de configuracion principal
				new Configuration().configure().buildSessionFactory();
		Session session = sessions.openSession();

		Transaction tx = null;
		Products products = null;

		try {
			tx = session.beginTransaction();
			// clase// crea una lista de tipo producto //////////// y selecciona los datos a
			// la lista
			List<Products> list = session.createQuery("from Products").list();
			
			for (Products products1 : list) {// recorre la lista generada y los muestra
				products = products1;

			}
			tx.commit();
			session.delete(product); // elimina
			tx = null;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Could not acquire message" + e);
		} finally {
			session.close();
		}
		//return (List<Products>) products;

		return 0;
	}

}
