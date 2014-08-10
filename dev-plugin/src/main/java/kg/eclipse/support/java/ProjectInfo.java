/**
 * Copyright (c) 2014.
 */
package kg.eclipse.support.java;

/**
 * @format Eclipse format:http://maven.apache.org/developers/maven-eclipse-codestyle.xml
 * @Email hua.wanghuawh@alibaba-inc.com
 * @Date 2014年8月10日 下午12:56:26
 * @Class ProjectInfo.java
 */
public class ProjectInfo
{
    private String name;

    private String srcPath;

    private String targetPath;

    /**
     * @return the name
     */
    public final String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName( String name )
    {
        this.name = name;
    }

    /**
     * @return the srcPath
     */
    public final String getSrcPath()
    {
        return srcPath;
    }

    /**
     * @param srcPath the srcPath to set
     */
    public final void setSrcPath( String srcPath )
    {
        this.srcPath = srcPath;
    }

    /**
     * @return the targetPath
     */
    public final String getTargetPath()
    {
        return targetPath;
    }

    /**
     * @param targetPath the targetPath to set
     */
    public final void setTargetPath( String targetPath )
    {
        this.targetPath = targetPath;
    }

}
