package ox.andalu.wms.dao.auth;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import ox.andalu.wms.domain.IConstants;
import ox.andalu.wms.domain.auth.Role;

@ContextConfiguration(locations = { "classpath*:spring.xml" })
public class RoleDaoTest  extends AbstractJUnit4SpringContextTests {
	@Autowired
	private RoleDao roleDao;

	@Test
	public void c() throws Exception {
		Role role=new Role();
		role.setCode("ROLE_ORG_001");
		role.setName("角色001");
		role.setOrgId(1L);
		role.setStatus(Constants.INT_ENABLED);
		System.out.println(roleDao.createRole(role));
	}
	@Test
	public void r() throws Exception {
	}
	@Test
	public void u() throws Exception {
	}
	@Test
	public void d() throws Exception {
	}
}
