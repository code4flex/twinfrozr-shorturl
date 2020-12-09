package com.twinfrozr.shorturl.restful.controller;

import com.twinfrozr.shorturl.common.core.controller.BaseController;
import com.twinfrozr.shorturl.common.core.domain.ResponseResult;
import com.twinfrozr.shorturl.restful.controller.vo.UrlVo;
import com.twinfrozr.shorturl.restful.domain.IShortUrlService;
import io.swagger.annotations.*;
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
@Api(tags = "短链接口")
@Controller
public class UrlsController extends BaseController {

    @Resource
    private IShortUrlService shortUrlService;

    /**
     *
     * @param urlVo
     * @return
     */
    @ApiOperation("生成短链")
    @ApiImplicitParam(name = "urlVo", value = "请求参数视图对象", dataType = "UrlVo")
    @ApiResponses({
            @ApiResponse(code=0,message="生成成功"),
            @ApiResponse(code=210130,message="URL 不可为空"),
            @ApiResponse(code = 2101303,message = "转换类型枚举不可为空")
    })
    @PostMapping("/urls")
    @ResponseBody
    public ResponseResult doUrls(@RequestBody UrlVo urlVo){

        return success(shortUrlService.genUrl(urlVo));
    }

}
