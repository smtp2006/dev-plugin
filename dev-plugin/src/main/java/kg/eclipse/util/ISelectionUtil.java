/**
 * 获取选中文件属性信息.
 */
package kg.eclipse.util;

import kg.eclipse.support.java.JavaInfo;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.core.PackageDeclaration;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.CompilationUnitElementInfo;
import org.eclipse.jdt.internal.core.SourceField;
import org.eclipse.jdt.internal.core.SourceFieldElementInfo;
import org.eclipse.jdt.internal.core.SourceMethod;
import org.eclipse.jdt.internal.core.SourceType;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;

/**
 * @author whua smtp2006@126.com
 * @version 2014年8月10日上午11:30:24
 */
public abstract class ISelectionUtil
{

    public static JavaInfo parseJavaInfo( ISelection selection )
    {
        JavaInfo javaInfo = new JavaInfo();
        try
        {
            if ( selection instanceof TreeSelection )
            {
                TreeSelection ts = (TreeSelection) selection;
                Object firstElement = ts.getFirstElement();
                if ( firstElement instanceof CompilationUnit )
                {
                    CompilationUnit comUnit = (CompilationUnit) firstElement;
                    CompilationUnitElementInfo eleInfo = (CompilationUnitElementInfo) comUnit.getElementInfo();

                    PackageDeclaration pkgDec = (PackageDeclaration) eleInfo.getChildren()[0];
                    javaInfo.setPackageName( pkgDec.getElementName() );
                    
                    SourceType sourceType = (SourceType) eleInfo.getChildren()[1];
                    for ( IJavaElement javaEle : sourceType.getChildren() ) {
                        if ( javaEle instanceof SourceField) {
                            SourceField sourceField = (SourceField) javaEle;
                            SourceFieldElementInfo sourceEleInfo = (SourceFieldElementInfo) sourceField.getElementInfo();
                            javaInfo.addField( sourceField.getElementName(), new String(sourceEleInfo.getTypeName()));
                        } else if ( javaEle instanceof SourceMethod) {
                            SourceMethod sourceMethod = (SourceMethod) javaEle;
                            sourceMethod.getElementName();
                        }
                    }
                }
            }
        }
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
        return javaInfo;
    }
}
