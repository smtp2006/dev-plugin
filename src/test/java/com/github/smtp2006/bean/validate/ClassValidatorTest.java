/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
 */
package com.github.smtp2006.bean.validate;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBException;

import org.apache.commons.digester3.Digester;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.smtp2006.bean.validate.digester.SingletonObjectCreateRule;
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
    private static final Map<Class, Rule> rulesCache = new ConcurrentHashMap<Class, Rule>();

    /**
     * @throws IOException
     * @throws JAXBException
     */
    @Test
    public void testValidate() throws Exception {
        Digester digester = new Digester();
        // digester.setValidating(true);
        // push Map
        digester.push(new HashMap<String, ClassValidator>());
        // parse ClassValidator
        digester.addCallMethod("classValidator", "put", 2);
        digester.addCallParam("classValidator", 0, "name");

        digester.addObjectCreate("classValidator", ClassValidator.class);
        digester.addSetProperties("classValidator");

        // parse ClassValidator.List#propertyValidators
        digester.addObjectCreate("classValidator/propertyValidators", ArrayList.class);

        // parse ClassValidator.List#propertyValidators.propertyValidator
        digester.addObjectCreate("classValidator/propertyValidators/propertyValidator", PropertyValidator.class);
        digester.addCallMethod("classValidator/propertyValidators/propertyValidator/property", "setProperty", 0);
        
        digester.addObjectCreate("classValidator/propertyValidators/propertyValidator/ruleChain", RuleChain.class);
        
//        digester.addObjectCreate("classValidator/propertyValidators/propertyValidator/ruleChain/rules/rule", null, "class");
        digester.addRule( "classValidator/propertyValidators/propertyValidator/ruleChain/rules/rule", new SingletonObjectCreateRule(  ) );
        digester.addSetNext("classValidator/propertyValidators/propertyValidator/ruleChain/rules/rule", "addRule");
        digester.addSetNext("classValidator/propertyValidators/propertyValidator/ruleChain", "setRuleChain");

        digester.addSetNext("classValidator/propertyValidators/propertyValidator", "add");

        // parse ClassValidator.setPropertyValidators
        digester.addSetNext("classValidator/propertyValidators", "setPropertyValidators", List.class.getName());

        digester.addCallParam("classValidator", 1, true);
        URL url = ClassValidatorTest.class.getClassLoader().getResource("User.xml");
//        URL url = ClassValidatorTest.class.getClassLoader().getResource(User.class.getName().replace(".", "/")+".xml");
        Object foo = digester.parse(url);
        System.out.println(foo);
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
