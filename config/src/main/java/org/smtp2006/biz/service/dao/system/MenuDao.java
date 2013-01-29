package ox.andalu.wms.dao.system;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import ox.andalu.wms.domain.system.Menu;

@Transactional
public interface MenuDao {

	Integer createMenu(Menu menu);

	void updateMenu(Menu menu);

	void updateMenusStatus(Map<String, Object> map);

	void updateMenuLeaf(Map<String, Object> map);

	List<Menu> loadMenus(Map<String, Object> map);

	void updateMenuTree(Menu menu);
}
