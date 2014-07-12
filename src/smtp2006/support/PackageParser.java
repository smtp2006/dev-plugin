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
public class PackageParser
{
    public static Pattern pattern = Pattern.compile( "\\s*package\\s+" + "([^\\s]+)" + "\\s*;" + ".*?" );

    public String invoke( String line )
    {
        Matcher matcherGroupingPackageName = pattern.matcher( line );
        if ( matcherGroupingPackageName.find() )
        {
            return matcherGroupingPackageName.group( 1 );
        }
        return null;
    }

    public static void main( String[] args )
    {
        System.err.println( new PackageParser().invoke( "package smtp2006.support;" ) );
    }
}
