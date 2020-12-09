package com.twinfrozr.shorturl.common.exception.constants;

import com.twinfrozr.shorturl.common.exception.LocalError;

/**
 * 自定义异常信息
 *
 * @author marvin
 */
public enum  CustomerErrorConstants implements LocalError {


    /* 短链模块 */
    SHORTURL_REQUEST_URL_EMPTY("210130","URL 不可为空"),
    SHORTURL_REQUEST_DECODE_EMPTY("2101301","链接 不可为空"),
    SHORTURL_REQUEST_DECODE_NOT_EXIST("2101302","链接 无法访问"),
    SHORTURL_REQUEST_TYPE_IS_NULL("2101303","转换类型枚举不可为空"),

    PARMS_ERROR("888888","参数错误"),
    OTHER_ERROR("999999","其他错误");

    private String code;
    private String message;

    private CustomerErrorConstants(String code,String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "[" + code + "]" + message;
    }

}
