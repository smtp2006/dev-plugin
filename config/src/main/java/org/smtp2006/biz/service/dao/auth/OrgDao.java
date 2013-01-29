package ox.andalu.wms.dao.auth;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import ox.andalu.wms.domain.auth.Org;

@Transactional
public interface OrgDao {
	/**
	 * 创建
	 * 
	 * @param org
	 */
	void createOrg(Org org);

	/**
	 * 
	 * @param map
	 * @return
	 */
	List<Org> loadOrgs(Map<String, Object> map);

	/**
	 * @param map
	 * @return
	 */
	int countOrgs(Map<String, Object> map);

	void updateOrg(Org org);

	void updateOrgsStatus(Map<String, Object> map);

	void deleteOrgs(List<String> ids);
}
