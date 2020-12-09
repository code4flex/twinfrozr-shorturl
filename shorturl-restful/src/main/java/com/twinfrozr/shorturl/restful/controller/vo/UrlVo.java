package com.twinfrozr.shorturl.restful.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * urlVo
 *
 * @author marvin
 */
@ApiModel("请求参数视图对象")
public class UrlVo implements Serializable {

    @ApiModelProperty("需要转换的URL")
    private String url;
    @ApiModelProperty("转换类型枚举 type=MIN|MAX")
    private GenType type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GenType getType() {
        return type;
    }

    public void setType(GenType type) {
        this.type = type;
    }
}
