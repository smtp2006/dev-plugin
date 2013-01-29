package ox.andalu.wms.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import ox.andalu.wms.dao.auth.UserDao;
import ox.andalu.wms.domain.auth.User;

@ContextConfiguration(locations = { "classpath*:spring.xml" })
public class DaoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserDao userDao;

	@Test
	public void test() throws Exception {
		System.out.println(userDao.deleteUserByUserName("admin"));
		User user=new User();
		user.setEmail("smtp2006@126.com");
		user.setNickName("admin");
		user.setOrgId(1L);
		user.setPassword("admin");
		user.setRealName("administrator");
		user.setStatus(1);
		user.setType(1);
		user.setUserName("admin");
		userDao.createUser(user);
		System.out.println(user.getId());
	}
}
