/**
 * https://github.com/smtp2006/bean-validate-plugin.git.
 */
package com.github.smtp2006.bean.validate.rule;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wanghua
 * @version 2013-4-19 下午11:27:53
 */
public class RuleChain {
    // ------------------------------------------------------ Static Variables

    /**
     * logger.
     */
    private static final Logger logger = LoggerFactory
            .getLogger(RuleChain.class);

    // ------------------------------------------------------ Instance Variables

    /**
     * 包含的多个Rule.
     */
    private List<Rule> rules;

    // ------------------------------------------------------ Constructor
    /**
     * 默认构造函数.
     */
    public RuleChain() {
    }

    /**
     * @param rules 指定rules的构造函数
     */
    public RuleChain(final List<Rule> rules) {
        super();
        this.rules = rules;
    }

    // ------------------------------------------------------ Getters & Setters
    /**
     * @return the rules
     */
    public List<Rule> getRules() {
        return rules;
    }

    /**
     * @param rules the rules to set
     */
    public void setRules(final List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * @param rule
     */
    public void addRule(Rule rule) {
        if (this.rules == null) {
            this.rules = new ArrayList<Rule>();
        }
        this.rules.add(rule);
    }

    // Validate value
    /**
     * @param value 校验指定对象.
     * @return 返回校验失败的List<Rule>
     */
    public List<Rule> validate(final Object value) {
        List<Rule> failures = null;
        if (rules != null && rules.size() > 0) {
            if (logger.isDebugEnabled()) {
                logger.debug("forEach({}) validate", rules.size());
            }

            for (int i = 0; i < rules.size(); i++) {
                // each rule validate
                Rule forEachRule = rules.get(i);
                boolean valReslut = forEachRule.validate(value);
                // if validate failure
                if (!valReslut) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("forEach({}) validate failure index[{}]",
                                rules.size(), i);
                    }

                    if (failures == null) {
                        failures = new ArrayList<Rule>();
                    }
                    failures.add(forEachRule);
                }
            }
        }
        return failures;
    }
}
