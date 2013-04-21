/**
 * 
 */
package com.github.smtp2006.bean.validate.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author hua.wanghuawh
 * 
 */
public class BeanValidaeNamespaceHandler extends NamespaceHandlerSupport {
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.beans.factory.xml.NamespaceHandler#init()
     */
    @Override
    public void init() {
        registerBeanDefinitionParser("classValidator", new ClassValidatorBeanDefinitionParser());

    }
}
