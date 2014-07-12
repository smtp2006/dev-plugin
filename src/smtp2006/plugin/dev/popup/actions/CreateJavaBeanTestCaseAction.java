package smtp2006.plugin.dev.popup.actions;

import java.io.FileWriter;

import smtp2006.plugin.dev.ResourcePathUtil.ClassConfig;
import smtp2006.support.ClassMetaUtil;
import smtp2006.support.ClassMetaUtil.ClassMeta;

public class CreateJavaBeanTestCaseAction
    extends CreateTestCaseAction
{

    protected void writeBody( FileWriter fw, ClassConfig config, String content )
        throws Exception
    {
        super.writeBody( fw, config, content );
        writeln( fw, "\n" );
        writeln( fw, "\n" );
        writeln( fw, "\t// Getter & setter Test" );
        writeln( fw, "\t@Test" );
        writeln( fw, "\tpublic void invoke_GetterAndSetter()" );
        writeln( fw, "\t{" );
        String beanName = config.getName().replace( ".java", "" );
        writeln( fw, "\t\t" + beanName + " target = new " + beanName + "();" );
        ClassMeta meta = ClassMetaUtil.parse( content );
        for ( String field : meta.getFields() )
        {
            writeln( fw, "\t\t" + "target.set" + Character.toUpperCase( field.charAt( 0 ) ) + field.substring( 1 )
                + "(null);" );
            writeln( fw,
                     "\t\t" + "org.junit.Assert.assertEquals(null, target.get"
                         + Character.toUpperCase( field.charAt( 0 ) ) + field.substring( 1 ) + "();" );
        }
        writeln( fw, "\t}" );
    }
}
