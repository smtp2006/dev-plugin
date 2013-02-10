package org.smtp2006.biz.service.system;

import java.util.List;

import org.smtp2006.biz.model.auth.User;
import org.smtp2006.biz.model.system.Menu;
import org.smtp2006.biz.service.ValidateFailException;

public interface MenuService {
    List<Menu> getTopMenusOfUser(User user) throws ValidateFailException;

    Menu createMenu(Menu menu) throws ValidateFailException;
}
