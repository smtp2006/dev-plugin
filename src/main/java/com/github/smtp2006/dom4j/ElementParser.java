/**
 * 
 */
package com.github.smtp2006.dom4j;

import java.beans.PropertyDescriptor;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.smtp2006.bean.validate.ClassValidator;
import com.github.smtp2006.bean.validate.Slf4jLoggerUtil;

/**
 * @author hua.wanghuawh
 * 
 */
public class ElementParser {
    // ------------------------------------------------------ Static Variables
    private static final Logger logger = LoggerFactory.getLogger(ElementParser.class);
    /**
     * @param element
     * @return
     * @throws Exception
     */
    public static Object parseElement(Element element) throws Exception {
        // parse attributes and newInstance by 'class' attribute
        Object instance = parseAttributes(element);

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
                            parseElement(childElement, value, recursive);
                        BeanUtils.setProperty(instance, pd.getName(), value);
                    }
                } catch (Exception e) {
                    Slf4jLoggerUtil.exception(logger, "getPropertyDescriptor", e);
                }

            }

        }
        return instance;
    }

    /**
     * @param element
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object parseAttributes(Element element) throws Exception {

        Object instance = null;

        String classAttribute = element.attributeValue("class");
        if (StringUtils.isNotBlank(classAttribute)) {
            instance = Class.forName(classAttribute).newInstance();
            List<Element> attributes = element.attributes();
            for (int i = 0; i < attributes.size(); i++) {
                Attribute attribute = (Attribute) attributes.get(i);
                if ("class".equals(attribute.getName()))
                    continue;
                try {
                    BeanUtils.setProperty(instance, attribute.getName(), attribute.getData());
                } catch (Exception e) {
                    Slf4jLoggerUtil.exception(logger, "BeanUtils.setProperty", e);
                }
            }
            return instance;
        }
        throw new RuntimeException("class attribute required");

    }
}
