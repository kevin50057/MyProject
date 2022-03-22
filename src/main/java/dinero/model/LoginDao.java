package dinero.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dinero.model.User;
import utils.HibernateUtil;

public class LoginDao {

	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(user);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public boolean validate(String userName, String password) {

		Transaction transaction = null;
		User user = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName",userName).uniqueResult();

			if (user != null && user.getPassword().equals(password)) {
				return true;
			}
			System.out.println("login ok");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}
		return false;
	}

}