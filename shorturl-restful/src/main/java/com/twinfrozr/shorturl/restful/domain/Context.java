package com.twinfrozr.shorturl.restful.domain;

/**
 *  策略控制类
 * @param <T>
 */
public class Context<T> {

    private IShortUrl<T> shortUrl;

    public Context(IShortUrl<T> shortUrl){
        this.shortUrl = shortUrl;
    }

    public String genUrl(String url){

        return shortUrl.genUrl(url);
    }
}
