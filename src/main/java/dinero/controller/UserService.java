package dinero.controller;

import java.util.List;

import org.hibernate.Session;

import dinero.model.UserDao;
import dinero.model.User;



public class UserService implements IUserService {
	
private UserDao dao;
	
	public UserService(Session session) {
		this.dao = new UserDao(session);
	}
	
	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public User selectUser(long UserID) {
		// TODO Auto-generated method stub
		return dao.selectUser(UserID);
	}


	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return dao.selectAllUser();
	}


	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null ;
	}


	@Override
	public boolean deleteUser(long UserID) {
		// TODO Auto-generated method stub
		return dao.deleteUser(UserID);
	}

	@Override
	public User updateUser(long UserID, String username) {
		// TODO Auto-generated method stub
		return null;
	}


}
