//package dinero.model;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//
//import org.hibernate.Session;
//
//import dinero.model.ProfilesBean;
//
///**
// * This DAO class provides CRUD database operations for the table todos in the
// * database.
// * 
// * @author Ramesh Fadatare
// *
// */
//
//public class ProfilesDaoImpl  implements ProfilesDao{
//	
//	private Session session;
//	
//    public ProfilesDaoImpl() {
//		// TODO Auto-generated constructor stub
//	}
//	
//    public ProfilesDaoImpl(Session session) {
//    	this.session = session;
//    }
//	
//	
//	
//	
//
//	@Override
//	public ProfilesBean insertProfiles(ProfilesBean profiles) throws SQLException {
//		System.out.println("insert users");
//		// try-with-resource statement will auto close the connection.
//		ProfilesBean profiles2 = session.get(ProfilesBean.class, profiles.get)	;	
//		
//		
//	}
//		
//		
//		
//	@Override
//	public ProfilesBean selectProfiles(long ProfileID) {
//		ProfilesBean Profiles = null;
//		// Step 1: Establishing a Connection
//		try (Connection connection = dataSource.getConnection();
//				// Step 2:Create a statement using connection object
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROFILES_BY_ID);) {
////			preparedStatement.setLong(1, ProfileID);
//			System.out.println(preparedStatement);
//			// Step 3: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//
//			// Step 4: Process the ResultSet object.
//			while (rs.next()) {
//				long ID = rs.getLong("ProfileID");
//				String gender = rs.getString("gender");
//				String Email = rs.getString("Email");
//				String cellphone = rs.getString("cellphone");
////				LocalDate birthday = rs.getDate("birthday").toLocalDate();
//				String address = rs.getString("address");
//				Profiles = new ProfilesBean(ID, gender, Email, cellphone,  address);
//
//			}
//		} catch (SQLException e) {
//			// process sql exception
//			System.err.println("商品新增失敗");
//			e.printStackTrace();
//		}
//		return Profiles;
//	}
//
//	@Override
//	public List<ProfilesBean> selectAllProfiles() {
//
//		// using try-with-resources to avoid closing resources (boiler plate code)
//		List<ProfilesBean> Profiles = new ArrayList<>();
//
//		// Step 1: Establishing a Connection
//		try (Connection connection = dataSource.getConnection();
//
//				// Step 2:Create a statement using connection object
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROFILES);) {
//			System.out.println(preparedStatement);
//			// Step 3: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//
//			// Step 4: Process the ResultSet object.
//			while (rs.next()) {
//				long ProfileID = rs.getLong("ProfileID");
//				String gender = rs.getString("gender");
//				String Email = rs.getString("Email");
//				String cellphone = rs.getString("cellphone");
//				LocalDate birthday = rs.getDate("birthday").toLocalDate();
//				String address = rs.getString("address");
//				Profiles.add(new ProfilesBean(ProfileID, gender, Email, cellphone, address));
//			}
//		} catch (SQLException e) {
//			// process sql exception
//			System.err.println("商品新增失敗");
//			e.printStackTrace();
//		}
//		return Profiles;
//	}
//
//	@Override
//	public boolean deletProfiles(int ProfileID) throws SQLException {
//		boolean rowDeleted;
//		try (Connection connection = dataSource.getConnection();
//				PreparedStatement statement = connection.prepareStatement(DELETE_PROFILES_BY_ID);) {
//			statement.setInt(1, ProfileID);
//			rowDeleted = statement.executeUpdate() > 0;
//		}
//		return rowDeleted;
//	}
//
//	@Override
//	public boolean updateProfiles(ProfilesBean Profiles) throws SQLException {
//		boolean rowUpdated;
//		try (Connection connection = dataSource.getConnection();
//				PreparedStatement statement = connection.prepareStatement(UPDATE_PROFILES);) {
//			statement.setString(1, Profiles.getGender());
//			statement.setString(2, Profiles.getEmail());
//			statement.setString(3, Profiles.getCellphone());
////			statement.setDate(4, dataSource.getSQLDate(Profiles.getBirthday()));
//			statement.setString(4, Profiles.getAddress());
//			statement.setLong(5, Profiles.getProfileID());
//			rowUpdated = statement.executeUpdate() > 0;
//		}
//		return rowUpdated;
//	}
//
//	@Override
//	public boolean deleteProfiles(int ProfileID) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
