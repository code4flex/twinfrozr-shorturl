package com.twinfrozr.shorturl.common.core.controller;

import com.twinfrozr.shorturl.common.core.domain.ResponseResult;
import com.twinfrozr.shorturl.common.utils.DateUtils;
import com.twinfrozr.shorturl.common.utils.ServletUtils;
import com.twinfrozr.shorturl.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;

/**
 * BaseController
 * 
 * @author marvin
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 获取request
     */
    public HttpServletRequest getRequest()
    {
        return ServletUtils.getRequest();
    }

    /**
     * 获取response
     */
    public HttpServletResponse getResponse()
    {
        return ServletUtils.getResponse();
    }

    /**
     * 获取session
     */
    public HttpSession getSession()
    {
        return getRequest().getSession();
    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected ResponseResult Response(int rows)
    {
        return rows > 0 ? success() : error();
    }

    /**
     * 响应返回结果
     * 
     * @param result 结果
     * @return 操作结果
     */
    protected ResponseResult Response(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * 返回成功
     */
    public ResponseResult success()
    {
        return ResponseResult.success();
    }

    /**
     * 返回失败消息
     */
    public ResponseResult error()
    {
        return ResponseResult.error();
    }

    /**
     * 返回成功消息
     */
    public ResponseResult success(String message)
    {
        return ResponseResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public ResponseResult error(String message)
    {
        return ResponseResult.error(message);
    }

    /**
     * 返回错误码消息
     */
    public ResponseResult error(ResponseResult.Type type, String message)
    {
        return new ResponseResult(type, message);
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }

    public void redirect(HttpServletResponse response,String url) throws IOException {
        response.sendRedirect(url);
    }
}
