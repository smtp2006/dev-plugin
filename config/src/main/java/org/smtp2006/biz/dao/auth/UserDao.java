package org.smtp2006.biz.dao.auth;

import java.util.List;

import org.smtp2006.biz.model.auth.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao {
    /**
     * @param user
     * @return
     */
    User create(User user);

    /**
     * @param user
     * @return
     */
    List<User> read(User user);

    /**
     * @param user
     * @return
     */
    User update(User user);

    /**
     * @param user
     * @return
     */
    User delete(User user);
}
