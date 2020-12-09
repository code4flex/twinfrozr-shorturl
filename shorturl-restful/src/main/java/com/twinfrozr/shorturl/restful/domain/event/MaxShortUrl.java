package com.twinfrozr.shorturl.restful.domain.event;

import com.twinfrozr.shorturl.common.hash.HashUtil;
import com.twinfrozr.shorturl.restful.controller.command.GenType;
import com.twinfrozr.shorturl.restful.controller.command.UrlCommand;
import com.twinfrozr.shorturl.restful.domain.IShortUrl;

public class MaxShortUrl implements IShortUrl<String> {

    /**
     * 生成短链
     *
     * @param url
     * @return
     */
    public String genUrl(String url) {
        return HashUtil.compress128(url);
    }
}
