package org.smtp2006.biz.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class Messages {
    @Autowired
    private ResourceBundleMessageSource messageSource;
    public static String REQUIRED = "argument.required";
    public static String FORMAT_ERROR = "argument.format.error";

    public final String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, code + ">" + StringUtils.join(args, "."), null);
    }
}
