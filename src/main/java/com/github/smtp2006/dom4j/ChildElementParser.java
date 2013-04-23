/**
 * 
 */
package com.github.smtp2006.dom4j;

import java.beans.PropertyDescriptor;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.smtp2006.bean.validate.Slf4jLoggerUtil;

/**
 * @author hua.wanghuawh
 * 
 */
public class ChildElementParser {
    // ------------------------------------------------------ Static Variables
    private static final Logger logger = LoggerFactory.getLogger(ChildElementParser.class);
    public void parseChildElement(Element element, Object instance, boolean recursive) throws Exception {

        List<Element> childElements = element.elements();
        if (childElements != null) {
            for (int i = 0; i < childElements.size(); i++) {
                Element childElement = childElements.get(i);
                try {
                    PropertyDescriptor pd = BeanUtilsBean.getInstance().getPropertyUtils()
                            .getPropertyDescriptor(instance, childElement.getName());
                    if (pd != null) {
                        Object value = pd.getPropertyType().newInstance();
                        if (recursive)
                            parseChildElement(childElement, value, recursive);
                        BeanUtils.setProperty(instance, pd.getName(), value);
                    }
                } catch (Exception e) {
                    Slf4jLoggerUtil.exception(logger, "getPropertyDescriptor", e);
                }

            }

        }
    }
}
