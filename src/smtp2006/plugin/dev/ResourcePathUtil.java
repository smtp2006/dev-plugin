package smtp2006.plugin.dev;

import java.util.TreeSet;

import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @format Eclipse format:http://maven.apache.org/developers/maven-eclipse-codestyle.xml
 * @Email hua.wanghuawh@alibaba-inc.com
 * @Date 2014年7月12日 下午12:58:50
 * @Class ResourcePathUtil.java
 */
public class ResourcePathUtil
{
    public static ClassConfig getPathStartsFromProjectRoot( StructuredSelection structuredSelection )
    {
        ClassConfig config = new ClassConfig();
        if ( structuredSelection.getFirstElement() instanceof org.eclipse.jdt.internal.core.CompilationUnit )
        {
            // ----------------------------------------
            // package explorer
            // ----------------------------------------
            org.eclipse.jdt.internal.core.CompilationUnit comUnit =
                (org.eclipse.jdt.internal.core.CompilationUnit) structuredSelection.getFirstElement();

            try
            {
                config.setName( comUnit.getElementName() );
                comUnit.getClassFile();
                config.setPkg( comUnit.getPackageDeclarations()[0].getElementName() );
                config.setProject( comUnit.getJavaProject().getElementName() );
                config.setSrc( comUnit.getPackageFragmentRoot().getResource().getFullPath().toString() );
                config.setTarget( comUnit.getJavaProject().getOutputLocation().toString() );
                config.setWorkspace( comUnit.getJavaProject().getProject().getWorkspace().getRoot().getLocation().toString() );
                IImportDeclaration[] importDecs = comUnit.getImports();
                config.setContent( new String( comUnit.getContents() ) );
                if ( importDecs != null )
                {
                    for ( IImportDeclaration dec : importDecs )
                    {
                        config.addImport( dec.getElementName() );
                    }
                }
            }
            catch ( Exception e )
            {
                throw new RuntimeException( e );
            }

        }
        return config;
    }

    public static class ClassConfig
    {
        private String name;

        private String pkg;

        private String project;

        private String src;

        private String target;

        private String workspace;

        private String content;

        private TreeSet<String> imports = new TreeSet<String>();

        /**
         * @return the name
         */
        public String getName()
        {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName( String name )
        {
            this.name = name;
        }

        /**
         * @return the pkg
         */
        public String getPkg()
        {
            return pkg;
        }

        /**
         * @param pkg the pkg to set
         */
        public void setPkg( String pkg )
        {
            this.pkg = pkg;
        }

        /**
         * @return the project
         */
        public String getProject()
        {
            return project;
        }

        /**
         * @param project the project to set
         */
        public void setProject( String project )
        {
            this.project = project;
        }

        /**
         * @return the src
         */
        public String getSrc()
        {
            return src;
        }

        /**
         * @param src the src to set
         */
        public void setSrc( String src )
        {
            this.src = src;
        }

        /**
         * @return the workspace
         */
        public String getWorkspace()
        {
            return workspace;
        }

        /**
         * @param workspace the workspace to set
         */
        public void setWorkspace( String workspace )
        {
            this.workspace = workspace;
        }

        /**
         * @return the target
         */
        public String getTarget()
        {
            return target;
        }

        /**
         * @param target the target to set
         */
        public void setTarget( String target )
        {
            this.target = target;
        }

        /**
         * @return the imports
         */
        public TreeSet<String> getImports()
        {
            return imports;
        }

        /**
         * @param imports the imports to set
         */
        public void addImport( String importClass )
        {
            this.imports.add( importClass );
        }

        /**
         * @return the content
         */
        public String getContent()
        {
            return content;
        }

        /**
         * @param content the content to set
         */
        public void setContent( String content )
        {
            this.content = content;
        }

    }
}
