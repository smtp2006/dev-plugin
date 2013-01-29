package org.smtp2006.biz.service.system.impl;

import java.sql.SQLException;

import org.junit.Test;
import org.smtp2006.SpringTest;
import org.smtp2006.biz.model.system.Menu;
import org.smtp2006.biz.service.ValidateFailException;
import org.smtp2006.biz.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

public class MenuServiceImplTest extends SpringTest {
    @Autowired
    @Qualifier(value = "menuService")
    MenuService menuService;

    @Test
    public void testMenuServiceNotNull() throws SQLException {
        Assert.notNull(menuService);
    }

    @Test
    public void testMenuServiceCreateMenu() throws SQLException, ValidateFailException {
        Assert.notNull(menuService);

        Menu systemMenu = new Menu();
        systemMenu.setCode("M1_MAN_SYSTEM");
        systemMenu.setDescription("系统管理");
        systemMenu.setDisplayOrder(1);
        systemMenu.setIsLeaf(false);
        systemMenu.setName("系统管理");
        systemMenu.setLevel(1);
        systemMenu.setStatus(1);

        systemMenu = menuService.createMenu(systemMenu);
        System.out.println("Id=" + systemMenu.getId());
        Assert.notNull(systemMenu.getId());

    }
}
