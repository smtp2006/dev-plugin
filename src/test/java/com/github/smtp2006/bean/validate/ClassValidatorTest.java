/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
 */
package com.github.smtp2006.bean.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void testValidate() {
        ClassValidator<User> cv = init_ClassValidator();
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
                System.out.print("\t" + rule.format() + ";");
            }
            System.out.println();
        }
    }
}
