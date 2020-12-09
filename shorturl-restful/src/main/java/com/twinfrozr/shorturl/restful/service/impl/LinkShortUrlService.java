package com.twinfrozr.shorturl.restful.service.impl;

import com.twinfrozr.shorturl.common.Validator.Validator;
import com.twinfrozr.shorturl.common.exception.constants.CustomerErrorConstants;
import com.twinfrozr.shorturl.restful.controller.command.GenType;
import com.twinfrozr.shorturl.restful.service.ILinkShortUrlService;
import com.twinfrozr.shorturl.restful.domain.entity.LinkShortUrl;
import com.twinfrozr.shorturl.restful.mapper.LinkShortUrlMapper;
import com.twinfrozr.shorturl.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 短链接 Service业务层处理
 * 
 * @author marvin
 * @date 2020-2-04
 */
@Service
public class LinkShortUrlService implements ILinkShortUrlService
{
    @Resource
    private LinkShortUrlMapper linkShortUrlMapper;

    /**
     * 根据id 查询
     * 
     * @param id
     * @return 短链
     */
    public LinkShortUrl queryLinkShortUrlById(Long id)
    {

        return linkShortUrlMapper.selectLinkShortUrlById(id);
    }

    /**
     * 根据短链码查询
     *
     * @param surl
     * @return
     */
    public String queryLinkShortUrlBySUrl(String surl) {

        LinkShortUrl linkShortUrl = linkShortUrlMapper.selectLinkShortUrlBySUrl(surl);

        Validator.notNull(linkShortUrl,CustomerErrorConstants.SHORTURL_REQUEST_DECODE_NOT_EXIST);

        return linkShortUrl.getlUrl();
    }

    /**
     * 新增短链
     * 
     * @param linkShortUrl
     * @return 结果
     */
    public int addLinkShortUrl(LinkShortUrl linkShortUrl)
    {
        linkShortUrl.setCreateTime(DateUtils.nowTime());
        return linkShortUrlMapper.insertLinkShortUrl(linkShortUrl);
    }

    /**
     *
     * @param surl
     * @return
     */
    public int existShortUrl(String surl) {

        return linkShortUrlMapper.selectLinkShortUrlByExist(surl);
    }

    /**
     *  新增短链
     *
     * @param url
     * @param surl
     * @return
     */
    public int addLinkShortUrl(String url,String surl)
    {
        LinkShortUrl linkShortUrl = new LinkShortUrl();
        linkShortUrl.setCreateTime(DateUtils.nowTime());
        linkShortUrl.setlUrl(url);
        linkShortUrl.setsUrl(surl);

        return linkShortUrlMapper.insertLinkShortUrl(linkShortUrl);
    }

}
