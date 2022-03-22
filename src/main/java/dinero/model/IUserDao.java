package dinero.model;

import java.sql.SQLException;
import java.util.List;

import dinero.model.User;

public interface IUserDao {

	 void insertUser(User user);
	 User selectUser(long UserID);
	 List<User> selectAllUser();
	 boolean deleteUser(long UserID);
	 void updateUser(User user);

}