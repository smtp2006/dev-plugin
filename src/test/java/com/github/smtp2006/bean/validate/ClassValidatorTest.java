/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
 */
package com.github.smtp2006.bean.validate;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.smtp2006.bean.validate.rule.Rule;
import com.github.smtp2006.bean.validate.rule.RuleChain;
import com.github.smtp2006.bean.validate.rule.impl.NotNullRule;

/**
 * @author wanghua
 * @version 2013-4-21 下午11:44:19
 * 
 */
public class ClassValidatorTest {
    // ------------------------------------------------------ Static Variables
    private static final Logger logger = LoggerFactory.getLogger(ClassValidator.class);
    private void parseAttributes(Element element, Object instance) {
        List<Element> attributes = element.attributes();
        for (int i = 0; i < attributes.size(); i++) {
            Attribute attribute = (Attribute) attributes.get(i);
            try {
                BeanUtils.setProperty(instance, attribute.getName(), attribute.getData());
            } catch (Exception e) {
                Slf4jLoggerUtil.exception(logger, "BeanUtils.setProperty", e);
            }
        }
    }
    private void parseElement(Element element, Object instance, boolean recursive) throws Exception {
        parseAttributes(element, instance);
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
    }

    private void parseClassValidator(Element element, ClassValidator instance) throws Exception {
        parseAttributes(element, instance);
        List<Element> childElements = element.elements();
        if (childElements != null) {
            for (int i = 0; i < childElements.size(); i++) {
                Element childElement = childElements.get(i);
                if ("propertyValidators".equals(childElement.getName())) {
                    List<ClassValidator> propertyValidators = new ArrayList<ClassValidator>();

                    List<Element> propertyValidatorElements = childElement.elements();
                    if (propertyValidatorElements != null) {
                        for (int pi = 0; pi < childElements.size(); pi++) {
                            Element pvElement = propertyValidatorElements.get(pi);
                            if ("propertyValidator".equals(pvElement.getName())) {
                                ClassValidator cv = new ClassValidator();

                                parseElement(pvElement, cv, false);

                                propertyValidators.add(cv);
                            }
                        }

                    }
                    instance.setPropertyValidators(propertyValidators);
                }
            }

        }
    }
    Map<String, ClassValidator<?>> loadFromUrl(URL url) throws Exception {
        Map<String, ClassValidator<?>> ret = new HashMap<String, ClassValidator<?>>();

        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        Element classValidators = document.getRootElement();
        if ("classValidators".equals(classValidators.getName())) {
            List<Element> childElements = classValidators.elements();
            if (childElements != null) {
                for (int i = 0; i < childElements.size(); i++) {
                    Element childElement = childElements.get(i);
                    ClassValidator cv = new ClassValidator();
                    parseClassValidator(childElement, cv);
                    System.out.println(cv);
                }

            }
        }
        return ret;
    }
    /**
     * @throws IOException
     * @throws JAXBException
     */
    @Test
    public void testValidate() throws Exception {

        System.out.println(loadFromUrl(ClassValidatorTest.class.getClassLoader().getResources("User.xml").nextElement()));
        ClassValidator<User> cv = init_ClassValidator();
//        User user = new User();
//        // user.name is null, validate failure
//        Map<String, List<Rule>> failures = cv.validate(user);
//
//        Assert.assertNotNull(failures);
//        result_Post(failures);
//
//        // user.name is not null, validate success;
//        user.setName("hello");
//        failures = cv.validate(user);
//        Assert.assertNull(failures);
//        result_Post(failures);
//
//        System.out.println(ClassValidatorFactory.validate(user));
    }
    private ClassValidator<User> init_ClassValidator() {
        // init RuleChain-->PropertyValidator-->ClassValidator
        RuleChain rc = new RuleChain();
        rc.addRule(new NotNullRule());

        PropertyValidator pv = new PropertyValidator("name", rc);

        List<PropertyValidator> propertyValidators = new ArrayList<PropertyValidator>();
        propertyValidators.add(pv);

        ClassValidator<User> cv = new ClassValidator<User>(propertyValidators);

        return cv;
    }

    private void result_Post(Map<String, List<Rule>> failures) {
        if (failures == null) {
            return;
        }
        for (Map.Entry<String, List<Rule>> entry : failures.entrySet()) {
            System.out.println(entry.getKey() + " ==>");

            for (Rule rule : entry.getValue()) {
                System.out.print("\t" + new MessageFormat(rule.format()).format(new Object[]{"name"}) + ";");
            }
            System.out.println();
        }
    }
}
