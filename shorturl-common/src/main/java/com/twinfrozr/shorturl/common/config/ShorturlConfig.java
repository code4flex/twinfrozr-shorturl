package com.twinfrozr.shorturl.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Shorturl 配置
 * 
 * @author marvin
 */
@Component
@ConfigurationProperties(prefix = "shorturl")
public class ShorturlConfig
{
    /** name */
    private static String name;

    /** version */
    private static String version;

    /** shortPre */
    private static String shortPre;

    public static String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        ShorturlConfig.name = name;
    }

    public static String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        ShorturlConfig.version = version;
    }

    public static String getShortPre() { return shortPre; }

    public void setShortPre(String shortPre) { ShorturlConfig.shortPre = shortPre; }
}
