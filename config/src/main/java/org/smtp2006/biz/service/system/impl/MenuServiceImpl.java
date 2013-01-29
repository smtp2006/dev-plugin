package org.smtp2006.biz.service.system.impl;

import java.util.List;

import org.smtp2006.biz.dao.system.MenuDao;
import org.smtp2006.biz.model.auth.User;
import org.smtp2006.biz.model.system.Menu;
import org.smtp2006.biz.service.ValidateFailException;
import org.smtp2006.biz.service.system.MenuService;
import org.smtp2006.biz.service.system.MenuServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuServiceValidator menuServiceValidator;
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getTopMenusOfUser(User user) throws ValidateFailException {
        if (menuServiceValidator != null) {
            menuServiceValidator.getTopMenusOfUser(user);
        }

        return null;
    }

    @Override
    public Menu createMenu(Menu menu) throws ValidateFailException {
        if (menuServiceValidator != null) {
            menuServiceValidator.createMenu(menu);
        }
        menuDao.create(menu);
        return menu;
    }

    public void setMenuServiceValidator(MenuServiceValidator menuServiceValidator) {
        this.menuServiceValidator = menuServiceValidator;
    }

}
