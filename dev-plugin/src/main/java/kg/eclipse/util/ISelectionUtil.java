/**
 * 获取选中文件属性信息.
 */
package kg.eclipse.util;

import org.eclipse.jface.viewers.ISelection;

/**
 * @author whua smtp2006@126.com
 * @version 2014年8月10日上午11:30:24
 */
public abstract class ISelectionUtil {

    public static JavaInfo parseJavaInfo(ISelection selection) {
        JavaInfo javaInfo = new JavaInfo();
        return javaInfo;
    }
}
