package dinero.model;

import java.sql.SQLException;
import java.util.List;

import dinero.model.ProfilesBean;

public interface ProfilesDao {

	ProfilesBean insertProfiles(ProfilesBean Profiles) throws SQLException;

	ProfilesBean selectProfiles(long ProfileID);

	List<ProfilesBean> selectAllProfiles();

	boolean deleteProfiles(int ProfileID) throws SQLException;

	boolean updateProfiles(ProfilesBean Profiles) throws SQLException;

	boolean deletProfiles(int ProfileID) throws SQLException;
	
	
}