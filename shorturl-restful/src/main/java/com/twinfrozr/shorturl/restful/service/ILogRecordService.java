package com.twinfrozr.shorturl.restful.service;

import com.twinfrozr.shorturl.restful.domain.entity.LogRecord;

/**
 * 短链访问记录Service接口
 * 
 * @author marvin
 * @date 2020-12-11
 */
public interface ILogRecordService 
{
    /**
     * 新增短链访问记录
     * 
     * @param logRecord 短链访问记录
     * @return 结果
     */
    public int insertLogRecord(LogRecord logRecord);
}
