package com.twinfrozr.shorturl.restful.domain;

/**
 *  生成短链接口
 *
 * @author mavin
 */
public interface IShortUrl<T> {

    /**
     * 生成短链
     *
     * @param url
     * @return
     */
    public String genUrl(String url);
}
