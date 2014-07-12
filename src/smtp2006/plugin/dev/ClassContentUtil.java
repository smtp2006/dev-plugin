/**
 * Copyright (c) 2014.
 */
package smtp2006.plugin.dev;

import java.util.LinkedList;
import java.util.List;

/**
 * @format Eclipse format:http://maven.apache.org/developers/maven-eclipse-codestyle.xml
 * @Email hua.wanghuawh@alibaba-inc.com
 * @Date 2014年7月12日 下午3:00:35
 * @Class ClassContentUtil.java
 */
public abstract class ClassContentUtil
{
    public static ClassMeta parse( String content )
    {
        ClassMeta meta = new ClassMeta();
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < content.length(); i++ )
        {
            char c = content.charAt( i );
            if ( c == '\r' || c == '\n' )
            {
                meta.addLine( sb.toString() );
                parseLine( meta, sb.toString() );
                sb = new StringBuilder();
            }
            else
            {
                sb.append( c );
            }
        }
        return meta;
    }

    private static void parseLine( ClassMeta meta, String line )
    {
    }

    public static class ClassMeta
    {
        List<String> lines = new LinkedList<String>();

        List<String> fields = new LinkedList<String>();

        List<String> methods = new LinkedList<String>();

        /**
         * @return the fields
         */
        public List<String> getFields()
        {
            return fields;
        }

        public List<String> addField( String field )
        {
            fields.add( field );
            return fields;
        }

        /**
         * @return the methods
         */
        public List<String> getMethods()
        {
            return methods;
        }

        public List<String> addMethod( String method )
        {
            methods.add( method );
            return methods;
        }

        /**
         * @return the lines
         */
        public List<String> getLines()
        {
            return lines;
        }

        public List<String> addLine( String line )
        {
            lines.add( line );
            return lines;
        }
    }
}
