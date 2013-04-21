/**
 * 
 */
package com.github.smtp2006.bean.validate.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.github.smtp2006.bean.validate.ClassValidator;
import com.github.smtp2006.bean.validate.PropertyValidator;
import com.github.smtp2006.bean.validate.rule.Rule;
import com.github.smtp2006.bean.validate.rule.RuleChain;

/**
 * @author hua.wanghuawh
 * 
 */
public class ClassValidatorBeanDefinitionParser extends AbstractBeanDefinitionParser {
    // ------------------------------------------------------ Static Variables
    private static final Logger logger = LoggerFactory.getLogger(ClassValidatorBeanDefinitionParser.class);
    /**
     * Cache Rule instance as singleton
     */
    private static final Map<Class<?>, Rule> rulesCache = new ConcurrentHashMap<Class<?>, Rule>();
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.beans.factory.xml.AbstractBeanDefinitionParser#
     * parseInternal(org.w3c.dom.Element,
     * org.springframework.beans.factory.xml.ParserContext)
     */
    @Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder beanDefBuilder = BeanDefinitionBuilder.genericBeanDefinition(ClassValidator.class);
        parseAttributes(element, parserContext, beanDefBuilder);
        parseChildElements(element, parserContext, beanDefBuilder);
        return beanDefBuilder.getBeanDefinition();
    }

    /**
     * @param element
     * @param parserContext
     * @param beanDefBuilder
     * @return
     */
    private BeanDefinitionBuilder parseAttributes(Element element, ParserContext parserContext,
            BeanDefinitionBuilder beanDefBuilder) {
        NamedNodeMap attributes = element.getAttributes();
        if (attributes != null && attributes.getLength() > 0) {
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attribute = attributes.item(i);
                logger.debug(element.getLocalName() + ".{} = {}", attribute.getLocalName(), attribute.getNodeValue());
                beanDefBuilder.addPropertyValue(attribute.getLocalName(), attribute.getNodeValue());
            }
        }
        return beanDefBuilder;
    }

    /**
     * @param element
     * @param parserContext
     * @param beanDefBuilder
     * @return
     */
    private BeanDefinitionBuilder parseChildElements(Element element, ParserContext parserContext,
            BeanDefinitionBuilder beanDefBuilder) {
        NodeList childElements = element.getChildNodes();
        if (childElements != null && childElements.getLength() > 0) {
            for (int i = 0; i < childElements.getLength(); i++) {
                Node childElement = childElements.item(i);
                logger.debug(element.getLocalName() + ".{}", childElement.getLocalName());
                if (childElement.getNodeType() == Node.ELEMENT_NODE) {
                    // parse ClassValidator.propertyValidators
                    if ("propertyValidators".equals(childElement.getLocalName())) {
                        parsePropertyValidators(childElement, parserContext, beanDefBuilder);
                    }
                }

            }
        }

        return beanDefBuilder;
    }

    private BeanDefinitionBuilder parsePropertyValidators(Node childElement, ParserContext parserContext,
            BeanDefinitionBuilder beanDefBuilder) {
        List<PropertyValidator> propertyValidators = new ArrayList<PropertyValidator>();

        NodeList propertyValidatorElements = childElement.getChildNodes();
        if (propertyValidatorElements != null && propertyValidatorElements.getLength() > 0) {
            for (int i = 0; i < propertyValidatorElements.getLength(); i++) {
                Node propertyValidatorElement = propertyValidatorElements.item(i);
                logger.debug(childElement.getLocalName() + ".{}", propertyValidatorElement.getLocalName());
                if (propertyValidatorElement.getNodeType() == Node.ELEMENT_NODE) {
                    // parse
                    // ClassValidator.propertyValidators.List<PropertyValidator>
                    if ("propertyValidator".equals(childElement.getLocalName())) {
                        propertyValidators.add(parsePropertyValidator(propertyValidatorElement));
                    }
                }

            }
        }

        beanDefBuilder.addPropertyValue(childElement.getLocalName(), propertyValidators);
        return beanDefBuilder;
    }

    private PropertyValidator parsePropertyValidator(Node propertyValidatorElement) {
        PropertyValidator propertyValidator = new PropertyValidator();
        propertyValidator.setProperty(propertyValidatorElement.getAttributes().getNamedItem("name").getLocalName());

        NodeList ruleChainElements = propertyValidatorElement.getChildNodes();
        if (ruleChainElements != null && ruleChainElements.getLength() > 0) {
            for (int i = 0; i < ruleChainElements.getLength(); i++) {
                Node ruleChainElement = ruleChainElements.item(i);
                if (ruleChainElement.getNodeType() == Node.ELEMENT_NODE) {
                    // parse
                    // ClassValidator.propertyValidators.List<PropertyValidator>
                    if ("ruleChain".equals(ruleChainElement.getLocalName())) {
                        propertyValidator.setRuleChain(parseRuleChain(ruleChainElement));
                    }
                }

            }
        }

        return propertyValidator;
    }

    @SuppressWarnings("rawtypes")
    private RuleChain parseRuleChain(Node ruleChainElement) {
        RuleChain ruleChain = new RuleChain();

        NodeList ruleElements = ruleChainElement.getChildNodes();
        if (ruleChainElement != null && ruleElements.getLength() > 0) {
            for (int i = 0; i < ruleElements.getLength(); i++) {
                Node ruleElement = ruleElements.item(i);
                if (ruleElement.getNodeType() == Node.ELEMENT_NODE) {
                    if ("rule".equals(ruleChainElement.getLocalName())) {
                        String ruleClass = ruleElement.getAttributes().getNamedItem("class").getLocalName();
                        logger.debug("ruleClass = {}", ruleClass);
                        Rule rule = rulesCache.get(ruleElement.getAttributes().getNamedItem("class").getLocalName());
                        if (rule == null) {
                            try {
                                Class ruleKlass = Class.forName(ruleClass);
                                rule = (Rule) ruleKlass.newInstance();
                                rulesCache.put(ruleKlass, rule);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                        ruleChain.addRule(rule);
                    }
                }

            }
        }

        return ruleChain;
    }
}
