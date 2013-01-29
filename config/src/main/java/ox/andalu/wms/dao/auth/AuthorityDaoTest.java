package ox.andalu.wms.dao.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import ox.andalu.wms.domain.auth.Authority;
import ox.andalu.wms.service.auth.AuthorityService;

@ContextConfiguration(locations = { "classpath*:spring.xml" })
public class AuthorityDaoTest  extends AbstractJUnit4SpringContextTests {
	@Autowired
	private AuthorityService authorityService;

	@Test
	public void create() throws Exception {
		Authority authority=new Authority("菜单配置1");
		
		//authorityService.createAuthority(authority);
	}
	@Test
	public void load() throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", "菜单配置%");
		
		List<Authority> list=authorityService.loadAuthorities(map);
		if(list!=null){
			for(Authority each:list){
				System.out.println(each.toString());
			}
		}
		
	}
}
