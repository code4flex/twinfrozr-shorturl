package com.twinfrozr.shorturl.common.exception;

/**
 * 本地异常接口
 *
 * @author Marvin
 */
public interface LocalError {
	
    public String getCode();

    public String getMessage();
}
