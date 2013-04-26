/**
 * https://github.com/smtp2006/bean-validate-plugin.git.
 */
package com.github.smtp2006.bean.validate.rule;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.smtp2006.bean.validate.rule.impl.NotNullRule;

/**
 * @author wanghua
 * @version 2013-4-26 下午11:02:51
 */
public class RuleChainTest {
    /**
     * 默认构造函数.
     */
    @Test
    public void RuleChain() {
        RuleChain rc = new RuleChain();
        assertNotNull(rc);
    }

    /**
     * @param rules 指定rules的构造函数
     */
    @Test
    public void RuleChain$Rules() {

        RuleChain rc = new RuleChain(null);
        assertNotNull(rc);
        assertNull(rc.getRules());

        rc.setRules(new ArrayList<Rule>());
        assertNotNull(rc);
        assertTrue(rc.getRules().isEmpty());

        rc = new RuleChain(new ArrayList<Rule>());
        assertNotNull(rc);
        assertTrue(rc.getRules().isEmpty());

        rc.addRule(new NotNullRule());
        assertTrue(rc.getRules().size() == 1);

    }

    @Test
    public void validate() {
        RuleChain rc = new RuleChain();

        rc.addRule(new NotNullRule());

        List<Rule> ruleFailures = rc.validate(null);
        assertNotNull(ruleFailures);

        assertTrue(ruleFailures.size() == 1);
        assertTrue(ruleFailures.get(0) instanceof NotNullRule);

    }
}
