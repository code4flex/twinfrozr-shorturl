package com.twinfrozr.shorturl.restful.domain;

import com.twinfrozr.shorturl.restful.controller.vo.UrlVo;

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
     * @param urlVo
     * @return
     */
    public String genUrl(UrlVo urlVo);
}
