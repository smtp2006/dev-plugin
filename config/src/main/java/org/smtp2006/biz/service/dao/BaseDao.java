package org.smtp2006.biz.service.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hua.wanghuawh
 * 
 */
public abstract class BaseDao extends SqlSessionDaoSupport {
    protected static Logger logger = LoggerFactory.getLogger(BaseDao.class);
}
