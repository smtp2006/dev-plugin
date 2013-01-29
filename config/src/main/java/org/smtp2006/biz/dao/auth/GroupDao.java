package org.smtp2006.biz.dao.auth;

import java.util.List;

import org.smtp2006.biz.model.auth.Group;

public interface GroupDao {
    /**
     * @param group
     * @return
     */
    Group create(Group group);

    /**
     * @param group
     * @return
     */
    List<Group> read(Group group);

    /**
     * @param group
     * @return
     */
    Group update(Group group);

    /**
     * @param group
     * @return
     */
    Group delete(Group group);
}
