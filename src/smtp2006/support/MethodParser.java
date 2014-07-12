/**
 * Copyright (c) 2014.
 */
package smtp2006.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @format Eclipse format:http://maven.apache.org/developers/maven-eclipse-codestyle.xml
 * @Email hua.wanghuawh@alibaba-inc.com
 * @Date 2014年7月12日 下午4:42:42
 * @Class PackageParser.java
 */
public class MethodParser
{
    public static Pattern pattern = Pattern.compile( "\\s*public\\s+" + "(static\\s+)?" + "([^\\s]+)\\s+"
        + "([^\\s]+)\\s*" + "\\(" + ".*" );

    public String invoke( String line )
    {
        Matcher matcher = pattern.matcher( line );
        if ( matcher.find() )
        {
            return matcher.group( 3 );
        }
        return null;
    }

    public static void main( String[] args )
    {
        System.err.println( "'public String invoke( String line )'="
            + new MethodParser().invoke( "public String invoke( String line )" ) );
        System.err.println( "'public static String invoke( String line )'="
            + new MethodParser().invoke( "public static String invoke( String line )" ) );

    }
}
