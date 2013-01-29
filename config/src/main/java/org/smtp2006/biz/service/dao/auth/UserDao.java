package ox.andalu.wms.dao.auth;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import ox.andalu.wms.domain.auth.User;

@Transactional
public interface UserDao {
	/**
	 * 
	 * @param user
	 * @return
	 */
	Integer createUser(User user);

	/**
	 * 根据用户名密码LoadUser
	 * 
	 * @required user.userName
	 * @required user.password
	 * @param user
	 * @return
	 */
	User loadUserByUsernameAndPassword(User user);

	/**
	 * 
	 * @param key
	 */
	int deleteUserByKey(Long key);

	/**
	 * 
	 * @param key
	 */
	int deleteUserByUserName(String userName);

	/**
	 * 
	 * @param map
	 * @return
	 */
	List<User> loadUsers(Map<String, Object> map);

	/**
	 * @param map
	 * @return
	 */
	int countUsers(Map<String, Object> map);

	void updateUser(User user);

	void updateUsersStatus(Map<String, Object> map);

	void deleteUsers(List<String> ids);
}
