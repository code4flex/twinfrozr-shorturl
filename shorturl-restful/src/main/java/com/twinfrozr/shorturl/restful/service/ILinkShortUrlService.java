package com.twinfrozr.shorturl.restful.service;


import com.twinfrozr.shorturl.restful.controller.command.GenType;
import com.twinfrozr.shorturl.restful.domain.entity.LinkShortUrl;

/**
 * 短链 Service接口
 * 
 * @author marvin
 */
public interface ILinkShortUrlService 
{
    /**
     * 根据短链码查询
     *
     * @param url
     * @return
     */
    public String queryLinkShortUrlBySUrl(String url);

    /**
     * 根据短链码查询短链是否存在
     *
     * @param surl
     * @return
     */
    public int existShortUrl(String surl);

    /**
     * 新增
     * 
     * @param linkShortUrl
     * @return 结果
     */
    public int addLinkShortUrl(LinkShortUrl linkShortUrl);

    /**
     * 新增
     *
     * @param url
     * @return 结果
     */
    public int addLinkShortUrl(String url,String surl);

}
