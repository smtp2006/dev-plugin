/**
 * 
 */
package kg.eclipse.support.java;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author whua smtp2006@126.com
 * @version 2014年8月10日上午11:33:47
 */
public class JavaInfo
{
    private ProjectInfo projectInfo;

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
    private Collection<FieldInfo> fields = new ArrayList<FieldInfo>();

    /**
     * Getter & Setter.
     */

    /**
     * 返回包名.
     * 
     * @return 返回包名
     */
    public String getPackageName()
    {
        return packageName;
    }

    /**
     * set包名.
     * 
     * @param packageName 包名
     */
    public void setPackageName( String packageName )
    {
        this.packageName = packageName;
    }

    /**
     * 返回类名.
     * 
     * @return 返回类名
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * set类名.
     * 
     * @param className 类名
     */
    public void setClassName( String className )
    {
        this.className = className;
    }

    /**
     * 返回字段列表.
     * 
     * @return 返回字段列表
     */
    public Collection<FieldInfo> getFields()
    {
        return fields;
    }

    /**
     * 添加字段到列表.
     * 
     * @param field 字段
     */
    public void addField( String field, String type )
    {
        this.fields.add( new FieldInfo( field, type ) );
    }

    /**
     * @return the projectInfo
     */
    public final ProjectInfo getProjectInfo()
    {
        return projectInfo;
    }

    /**
     * @param projectInfo the projectInfo to set
     */
    public final void setProjectInfo( ProjectInfo projectInfo )
    {
        this.projectInfo = projectInfo;
    }

}
