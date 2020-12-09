package com.twinfrozr.shorturl.restful.controller;

import com.twinfrozr.shorturl.common.core.controller.BaseController;
import com.twinfrozr.shorturl.common.core.domain.ResponseResult;
import com.twinfrozr.shorturl.restful.controller.command.UrlCommand;
import com.twinfrozr.shorturl.restful.domain.IShortUrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * urls Controller
 *
 * @author marvin
 */
@Controller
public class UrlsController extends BaseController {

    @Resource
    private IShortUrlService shortUrlService;

    /**
     *
     * @param cmd
     * @return
     */
    @PostMapping("/urls")
    @ResponseBody
    public ResponseResult doUrls(@RequestBody UrlCommand cmd){

        return success(shortUrlService.genUrl(cmd));
    }

}
