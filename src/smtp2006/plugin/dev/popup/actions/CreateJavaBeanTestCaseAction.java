package smtp2006.plugin.dev.popup.actions;

import java.io.FileWriter;

import smtp2006.plugin.dev.ResourcePathUtil.ClassConfig;

public class CreateJavaBeanTestCaseAction
    extends CreateTestCaseAction
{

    protected void writeBody( FileWriter fw, ClassConfig config, String content )
        throws Exception
    {
        super.writeBody( fw, config, content );
    }

}
