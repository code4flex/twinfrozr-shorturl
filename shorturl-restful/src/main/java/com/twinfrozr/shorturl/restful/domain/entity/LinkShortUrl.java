package com.twinfrozr.shorturl.restful.domain.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 短链接对象 link_short_url
 * 
 * @author marvin
 * @date 2020-2-04
 */
public class LinkShortUrl
{
    private static final long serialVersionUID = -4373942421064284274L;

    /** id */
    private Long id;

    /** 长链 */
    private String lUrl;

    /** 短地址 */
    private String sUrl;

    /**
     * 创建时间
     */
    private int createTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setlUrl(String lUrl) 
    {
        this.lUrl = lUrl;
    }

    public String getlUrl() 
    {
        return lUrl;
    }

    public void setsUrl(String sUrl)
    {
        this.sUrl = sUrl;
    }

    public String getsUrl() 
    {
        return sUrl;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lUrl", getlUrl())
            .append("sUrl", getsUrl())
            .append("createTime", getCreateTime())
            .toString();
    }
}
