package github.smtp2006.utils.config;

import github.smtp2006.utils.BeanUtil;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置的工厂，通过该类的方法，加载配置，并返回指定类型的Java对象.
 * 
 * @author 王华
 * @version 2013年7月7日 上午11:02:42
 * 
 */
public abstract class ConfigFactory {
    private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);
    public static final String FILE_SUFFIX = ".properties";

    /**
     * 默认配置文件路径同Class路径
     * 
     * @param configClass
     * @return
     * @throws Exception
     */
    public static Object getConfig(String configClass) throws Exception {
        String configFile = configClass.replaceAll("\\.", "/") + FILE_SUFFIX;
        return getConfig(configFile, configClass, "");
    }

    /**
     * 
     * @param configFile
     * @param configClass
     * @return
     * @throws Exception
     */
    public static Object getConfig(String configFile, String configClass) throws Exception {
        return getConfig(configFile, configClass, "");
    }

    public static Object getConfig(String configFile, String configClass, String prefix) throws Exception {
        logger.info("configFile:{}", configFile);
        Class<?> klass = Class.forName(configClass);
        Object obj = klass.newInstance();
        Properties props = new Properties();
        props.load(ConfigFactory.class.getClassLoader().getResourceAsStream(configFile));
        BeanUtil.populate(obj, props, prefix);
        // 注入原配置文件.
        if (obj instanceof ConfigAware) {
            ((ConfigAware) obj).setConfig(props);
        }
        return obj;
    }

}
