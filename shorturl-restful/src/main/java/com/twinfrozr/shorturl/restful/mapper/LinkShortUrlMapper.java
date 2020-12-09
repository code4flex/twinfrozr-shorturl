package com.twinfrozr.shorturl.restful.mapper;


import com.twinfrozr.shorturl.restful.domain.entity.LinkShortUrl;

/**
 * 短链接Mapper接口
 * 
 * @author marvin
 * @date 2020-2-04
 */
public interface LinkShortUrlMapper 
{
    /**
     * 查询短链接
     * 
     * @param id ID
     * @return
     */
    public LinkShortUrl selectLinkShortUrlById(Long id);


    /**
     * 根据短链码查询
     *
     * @param surl
     * @return
     */
    public LinkShortUrl selectLinkShortUrlBySUrl(String surl);

    /**
     * 判断短链是否存在
     * @param surl
     * @return
     */
    public int selectLinkShortUrlByExist(String surl);

    /**
     * 新增短链接
     * 
     * @param linkShortUrl
     * @return 结果
     */
    public int insertLinkShortUrl(LinkShortUrl linkShortUrl);

}
