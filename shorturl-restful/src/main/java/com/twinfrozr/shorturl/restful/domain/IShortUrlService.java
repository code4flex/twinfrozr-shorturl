package com.twinfrozr.shorturl.restful.domain;

import com.twinfrozr.shorturl.restful.controller.command.UrlCommand;

public interface IShortUrlService {

    /**
     * 还原短链
     * @param deCode
     * @return
     */
    public String queryDeCode(String deCode);

    /**
     * 生成短链
     *
     * @param command
     * @return
     */
    public String genUrl(UrlCommand command);
}
