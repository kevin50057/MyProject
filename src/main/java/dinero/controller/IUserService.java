package dinero.controller;

import java.util.List;

import dinero.model.User;


public interface IUserService {
	public User insertUser(User user);
	public  User selectUser(long UserID);
	public List<User> selectAllUser();
	public User updateUser(long UserID, String username);
	public boolean deleteUser(long UserID);
	User updateUser(User user);

}
