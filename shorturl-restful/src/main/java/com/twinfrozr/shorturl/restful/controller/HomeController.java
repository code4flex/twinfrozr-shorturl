package com.twinfrozr.shorturl.restful.controller;

import com.twinfrozr.shorturl.common.core.controller.BaseController;
import com.twinfrozr.shorturl.common.core.domain.ResponseResult;
import com.twinfrozr.shorturl.common.exception.constants.CommonServerErrorConstants;
import com.twinfrozr.shorturl.restful.domain.IShortUrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController extends BaseController {

    @Resource
    private IShortUrlService shortUrlService;

    /**
     * index
     *
     * @return
     */
    @GetMapping("/")
    @ResponseBody
    public ResponseResult index(){

        return success("hello");
    }

    /**
     * redirect
     * @param code
     * @return
     */
    @GetMapping("/a/{code}")
    public void index(@PathVariable String code, HttpServletResponse response) throws IOException {
        String url = shortUrlService.queryDeCode(code);

        response.setStatus(Integer.parseInt(CommonServerErrorConstants.HTTP_302.getCode()));
        redirect(response,url);
    }

}
