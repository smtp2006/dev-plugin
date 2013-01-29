package ox.andalu.wms.service.system;

import org.apache.struts2.json.JSONUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ox.andalu.wms.test.ATest;

public class MenuServiceTest extends ATest {
	@Autowired
	private MenuService menuService;
	
	@Test
	public void menutree() throws Exception {
		System.out.println(JSONUtil.serialize(menuService.menutree()));
	}
}
