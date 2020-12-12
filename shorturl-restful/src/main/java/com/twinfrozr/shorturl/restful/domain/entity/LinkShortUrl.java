package com.twinfrozr.shorturl.restful.domain.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 短链接对象 link_short_url
 *
 * @author marvin
 * @date 2020-2-04
 */
public class LinkShortUrl extends BaseEntity
{
    private static final long serialVersionUID = 3440882990711640377L;
    /** id */
    private Long id;

    /** 长链 */
    private String lUrl;

    /** 短地址 */
    private String sUrl;

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
