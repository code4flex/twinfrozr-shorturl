package com.twinfrozr.shorturl.restful.domain.service;

import com.twinfrozr.shorturl.common.Validator.Validator;
import com.twinfrozr.shorturl.common.config.ShorturlConfig;
import com.twinfrozr.shorturl.common.exception.constants.CustomerErrorConstants;
import com.twinfrozr.shorturl.common.utils.StringUtils;
import com.twinfrozr.shorturl.restful.controller.command.GenType;
import com.twinfrozr.shorturl.restful.controller.command.UrlCommand;
import com.twinfrozr.shorturl.restful.domain.Context;
import com.twinfrozr.shorturl.restful.domain.IShortUrlService;
import com.twinfrozr.shorturl.restful.domain.event.MaxShortUrl;
import com.twinfrozr.shorturl.restful.domain.event.MinShortUrl;
import com.twinfrozr.shorturl.restful.service.ILinkShortUrlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 短链服务
 *
 * @author mavin
 */
@Service
public class ShortUrlService implements IShortUrlService {

    @Resource
    private ILinkShortUrlService linkShortUrlService;

    /**
     * 还原短链
     * @param deCode
     * @return
     */
    public String queryDeCode(String deCode){
        //链接无法访问，需替换为Error Page
        Validator.notEmpty(deCode, CustomerErrorConstants.SHORTURL_REQUEST_DECODE_NOT_EXIST);

        return linkShortUrlService.queryLinkShortUrlBySUrl(deCode);
    }

    /**
     * 生成短链
     *
     * @param command
     * @return
     */
    public String genUrl(UrlCommand command){

        Validator.notNull(command, CustomerErrorConstants.PARMS_ERROR);
        Validator.notEmpty(command.getUrl(), CustomerErrorConstants.SHORTURL_REQUEST_URL_EMPTY);

        String tmpCode = StringUtils.EMPTY;
        if(GenType.MIN == command.getType()){
            Context<String> context = new Context<String>(new MinShortUrl());
            tmpCode = context.genUrl(command.getUrl());
        }
        if(GenType.MAX == command.getType()){
            Context<String> context = new Context<String>(new MaxShortUrl());
            tmpCode = context.genUrl(command.getUrl());
        }

        if(linkShortUrlService.existShortUrl(tmpCode)<1) {
            linkShortUrlService.addLinkShortUrl(command.getUrl(),tmpCode);
        }

        return ShorturlConfig.getShortPre() +"a/"+tmpCode;
    }
}
