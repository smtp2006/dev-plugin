package org.smtp2006.biz.service.system.impl;

import java.util.List;

import org.smtp2006.biz.model.auth.User;
import org.smtp2006.biz.model.system.Menu;
import org.smtp2006.biz.service.Messages;
import org.smtp2006.biz.service.ValidateFailException;
import org.smtp2006.biz.service.system.MenuServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component(value = "menuServiceValidator")
public class MenuServiceValidatorImpl implements MenuServiceValidator {
    @Autowired
    Messages messages;

    @Override
    public List<Menu> getTopMenusOfUser(User user) throws ValidateFailException {
        try {
            Assert.notNull(user, messages.getMessage(Messages.REQUIRED, new Object[] { "User[id]" }));
            Assert.notNull(user.getId(), messages.getMessage(Messages.REQUIRED, new Object[] { "User[id]" }));
            Assert.isTrue(user.getId() > 0, messages.getMessage(Messages.FORMAT_ERROR, new Object[] { "User[id]" }));
        } catch (IllegalArgumentException e) {
            throw new ValidateFailException(e.getMessage());
        }
        return null;
    }

    @Override
    public Menu createMenu(Menu menu) throws ValidateFailException {
        try {
            Assert.isTrue(StringUtils.hasLength(menu.getCode()),
                    messages.getMessage(Messages.REQUIRED, new Object[] { "Menu[code]" }));
            Assert.isTrue(StringUtils.hasLength(menu.getName()),
                    messages.getMessage(Messages.REQUIRED, new Object[] { "Menu[name]" }));
            Assert.isTrue(menu.getDisplayOrder() >= 0,
                    messages.getMessage(Messages.FORMAT_ERROR, new Object[] { "Menu[displayOrder]" }));
            Assert.isTrue(menu.getLevel() >= 0, messages.getMessage(Messages.FORMAT_ERROR, new Object[] { "Menu[level]" }));
            Assert.isTrue(menu.getParentId() == null || menu.getParentId() >= 0,
                    messages.getMessage(Messages.FORMAT_ERROR, new Object[] { "Menu[parentId]" }));
            Assert.isTrue(menu.getStatus() >= 0, messages.getMessage(Messages.FORMAT_ERROR, new Object[] { "Menu[status]" }));
        } catch (IllegalArgumentException e) {
            throw new ValidateFailException(e.getMessage());
        }
        return menu;
    }

}
