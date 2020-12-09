package com.twinfrozr.shorturl.common.exception.constants;

import com.twinfrozr.shorturl.common.exception.LocalError;

public enum CommonServerErrorConstants implements LocalError {

    HTTP_300("301","多种选择"),HTTP_301("301","永久移动"),HTTP_302("302","临时移动"),
    HTTP_303("303","查看其他地址"),HTTP_304("304","未修改"),HTTP_305("305","使用代理"),
    HTTP_306("306","已经被废弃的HTTP状态码"),HTTP_307("307","使用GET请求，临时重定向。"),
    HTTP_400("400", "错误的请求"), HTTP_404("404", "资源未找到"), HTTP_405("405", "方法不允许"), HTTP_406(
            "406", "未接受的媒体类型"), HTTP_415("415", "不支持的媒体类型"), SERVER_INNER_ERROR(
            "500", "服务器内部错误");

    private String code;
    private String message;

    private CommonServerErrorConstants(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String toString() {
        return "[" + code + "] " + message;
    }
}