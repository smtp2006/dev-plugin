/**
 * 
 */
package kg.eclipse.util;

import java.util.Collection;
import java.util.TreeSet;

/**
 * @author whua smtp2006@126.com
 * @version 2014年8月10日上午11:33:47
 */
public class JavaInfo {
    /**
     * 包名.
     */
    private String packageName;
    /**
     * 类名.
     */
    private String className;
    /**
     * 所有字段列表.
     */
    private Collection<String> fields = new TreeSet<String>();

    /**
     * Getter & Setter.
     */

    /**
     * 返回包名.
     * 
     * @return 返回包名
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * set包名.
     * 
     * @param packageName 包名
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * 返回类名.
     * 
     * @return 返回类名
     */
    public String getClassName() {
        return className;
    }

    /**
     * set类名.
     * 
     * @param className 类名
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 返回字段列表.
     * 
     * @return 返回字段列表
     */
    public Collection<String> getFields() {
        return fields;
    }

    /**
     * 添加字段到列表.
     * 
     * @param field 字段
     */
    public void addField(String field) {
        this.fields.add(field);
    }

}
