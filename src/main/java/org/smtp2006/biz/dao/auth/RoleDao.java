package org.smtp2006.biz.dao.auth;

import java.util.List;

import org.smtp2006.biz.model.auth.Role;

public interface RoleDao {
    /**
     * @param role
     * @return
     */
    Role create(Role role);

    /**
     * @param role
     * @return
     */
    List<Role> read(Role role);

    /**
     * @param role
     * @return
     */
    Role update(Role role);

    /**
     * @param role
     * @return
     */
    Role delete(Role role);
}
