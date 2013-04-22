/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
 */
package com.github.smtp2006.bean.validate;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Assert;
import org.junit.Test;

import com.github.smtp2006.bean.validate.rule.Rule;
import com.github.smtp2006.bean.validate.rule.RuleChain;
import com.github.smtp2006.bean.validate.rule.impl.NotNullRule;

/**
 * @author wanghua
 * @version 2013-4-21 下午11:44:19
 * 
 */
public class ClassValidatorTest {
    @Test
    public void testValidate() throws IOException, JAXBException {
        ClassValidator<User> cv = init_ClassValidator();
        JAXBContext context = JAXBContext.newInstance(ClassValidator.class, NotNullRule.class);
        try {
            Marshaller marshal = context.createMarshaller();
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshal.marshal(cv, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = new User();
        // user.name is null, validate failure
        Map<String, List<Rule>> failures = cv.validate(user);

        Assert.assertNotNull(failures);
        result_Post(failures);

        // user.name is not null, validate success;
        user.setName("hello");
        failures = cv.validate(user);
        Assert.assertNull(failures);
        result_Post(failures);

        System.out.println(ClassValidatorFactory.validate(user));
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
                System.out.print("\t" + new MessageFormat(rule.format()).format(new Object[] { "name" }) + ";");
            }
            System.out.println();
        }
    }
}
