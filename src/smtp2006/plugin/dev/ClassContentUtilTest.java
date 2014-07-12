/**
 * Copyright (c) 2014.
 */
package smtp2006.plugin.dev;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import smtp2006.plugin.dev.ClassContentUtil.ClassMeta;

/**
 * @format Eclipse format:http://maven.apache.org/developers/maven-eclipse-codestyle.xml
 * @Email hua.wanghuawh@alibaba-inc.com
 * @Date 2014年7月12日 下午3:05:29
 * @Class ClassContentUtilTest.java
 */
public class ClassContentUtilTest
{

    /**
     * @param args
     * @throws Exception
     */
    public static void main( String[] args )
        throws Exception
    {
        String file =
            "D:/git_code2/smartcloud/smartcloud-biz-obd/src/main/java/com/yunos/smartcloud/obd/domain/ObdLocation.java";
        StringBuilder sb = new StringBuilder();
        InputStreamReader reader = new InputStreamReader( new FileInputStream( new File( file ) ) );
        int c = -1;
        while ( ( c = reader.read() ) != -1 )
        {
            sb.append( (char) ( c ) );
        }
        reader.close();
        System.out.println( sb.toString() );

        ClassMeta meta = ClassContentUtil.parse( sb.toString() );
        System.err.println( meta.getLines() );
        System.err.println( meta.getFields() );
        System.err.println( meta.getMethods() );
    }

}
