package com.twinfrozr.shorturl.restful.domain.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 短链访问记录对象 log_record
 * 
 * @author marvin
 * @date 2020-12-11
 */
public class LogRecord extends BaseEntity
{
    private static final long serialVersionUID = -1037816038691644915L;

    /** id */
    private Long id;

    /** IP地址 */
    private String ip;

    /** 请求地点 */
    private String location;

    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String os;

    /** 请求URL */
    private String url;

    /** 短链码 */
    private String sUrl;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return location;
    }
    public void setBrowser(String browser)
    {
        this.browser = browser;
    }

    public String getBrowser()
    {
        return browser;
    }
    public void setOs(String os)
    {
        this.os = os;
    }

    public String getOs()
    {
        return os;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
    public void setsUrl(String sUrl)
    {
        this.sUrl = sUrl;
    }

    public String getsUrl()
    {
        return sUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("ip", getIp())
                .append("location", getLocation())
                .append("browser", getBrowser())
                .append("os", getOs())
                .append("url", getUrl())
                .append("sUrl", getsUrl())
                .append("createTime", getCreateTime())
                .toString();
    }
}
