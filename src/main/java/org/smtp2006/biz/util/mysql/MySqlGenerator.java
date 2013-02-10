package org.smtp2006.biz.util.mysql;

import org.smtp2006.biz.util.SqlGenerator;

public class MySqlGenerator implements SqlGenerator {

    @Override
    public String describe(Class<?> klass) {
        StringBuffer sb = new StringBuffer();
        return sb.toString();
    }

}
