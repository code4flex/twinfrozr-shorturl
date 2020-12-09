package com.twinfrozr.shorturl.restful.domain;

import com.twinfrozr.shorturl.restful.controller.command.GenType;

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
