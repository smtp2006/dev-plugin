package smtp2006.plugin.dev.popup.actions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import smtp2006.plugin.dev.ResourcePathUtil;
import smtp2006.plugin.dev.ResourcePathUtil.ClassConfig;

public class CreateTestCaseAction
    implements IObjectActionDelegate
{

    private ISelection selection;

    /**
     * Constructor for Action1.
     */
    public CreateTestCaseAction()
    {
        super();
    }

    /**
     * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
     */
    public void setActivePart( IAction action, IWorkbenchPart targetPart )
    {
    }

    /**
     * @see IActionDelegate#run(IAction)
     */
    public void run( IAction action )
    {
        ClassConfig config = getResourcePathForTargetClassFile();
        createFile( config );
    }

    /**
     * @see IActionDelegate#selectionChanged(IAction, ISelection)
     */
    public void selectionChanged( IAction action, ISelection selection )
    {
        this.selection = selection;
    }

    protected ClassConfig getResourcePathForTargetClassFile()
    {
        // path started from project root
        ClassConfig config = ResourcePathUtil.getPathStartsFromProjectRoot( (StructuredSelection) selection );
        return config;
    }

    protected void createFile( ClassConfig config )
    {
        String dir =
            config.getWorkspace() + config.getSrc().replaceFirst( "src", "test" )
                + "/" + config.getPkg().replace( ".", "/" );
        String name = config.getName().replace( ".java", "Test.java" );
        String className = config.getPkg() + "." + config.getName().replace( ".java", "" );

        File outputIOFile = new File( dir + "/" + name );
        try
        {
            new File( dir ).mkdirs();
            FileWriter fw = new FileWriter( outputIOFile );
            writeln( fw, "package " + config.getPkg() + ";" );

            for ( String importClas : config.getImports() )
            {
                writeln( fw, "import " + importClas + ";" );
            }
            writeln( fw, "import " + className + ";" );
            writeln( fw, "import org.junit.Test;" );
            writeln( fw, "public class " + name.replace( ".java", "" ) );
            writeln( fw, "{" );
            writeBody( fw, config, config.getContent() );
            writeln( fw, "}" );
            fw.close();
        }
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }

    }

    protected void writeBody( FileWriter fw, ClassConfig config, String content )
        throws Exception
    {
        writeln( fw, "\t@Test" );
        writeln( fw, "\tpublic void invoke()" );
        writeln( fw, "\t{" );
        writeln( fw, "\t}" );
    }

    protected void writeln( FileWriter fw, String str )
        throws IOException
    {
        fw.write( str + "\n" );
    }
}
