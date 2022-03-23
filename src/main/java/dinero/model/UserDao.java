package dinero.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dinero.model.User;
import utils.HibernateUtil;

public class UserDao implements IUserDao {

	private Session session;

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	public UserDao(Session session) {
		this.session = session;
	}

	@Override
	public void insertUser(User user) {
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

	@Override
	public User selectUser(long UserID) {
		User userresult = session.get(User.class, UserID);

		return userresult;
	}

	@Override
	public List<User> selectAllUser() {

		Query<User> query = session.createQuery("select u from User u", User.class);
		List<User> list = query.list();

		return list;

	}

	@Override
	public void updateUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.saveOrUpdate(user);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public boolean deleteUser(long UserID) {
		User resultBean = session.get(User.class, UserID);

		if (resultBean != null) {
			session.delete(resultBean);
			return true;
		}

		return false;

	}
	
	public int registerUser(User user) throws ClassNotFoundException {

		int result = 0;
		

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
		return result;
	
	}
	
	public dinero.model.User getUserByUserAccAndPwd(String account ,String pwd){
		
		Transaction transaction = null;
		User user = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName",account).uniqueResult();

			if (user != null && user.getPassword().equals(pwd)) {
				
			}
			System.out.println("login ok");
			transaction.commit();
		
			return user;
			
			
		}

		
		
	}

}