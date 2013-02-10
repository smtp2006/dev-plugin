package org.smtp2006.biz.dao.system;

import java.util.List;

import org.smtp2006.biz.model.system.Menu;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hua.wanghuawh
 * 
 */
@Transactional
public interface MenuDao {
    /**
     * @param menu
     * @return
     */
    Integer create(Menu menu);
    /**
     * @param menu
     * @return
     */
    List<Menu> read(Menu menu);
    /**
     * @param menu
     * @return
     */
    Menu update(Menu menu);
    /**
     * @param menu
     * @return
     */
    Menu delete(Menu menu);
}
