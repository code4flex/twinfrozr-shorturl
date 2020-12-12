package com.twinfrozr.shorturl.restful.service.impl;

import com.twinfrozr.shorturl.common.utils.DateUtils;
import com.twinfrozr.shorturl.restful.domain.entity.LogRecord;
import com.twinfrozr.shorturl.restful.mapper.LogRecordMapper;
import com.twinfrozr.shorturl.restful.service.ILogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短链访问记录Service业务层处理
 * 
 * @author marvin
 * @date 2020-12-11
 */
@Service
public class LogRecordService implements ILogRecordService
{
    @Autowired
    private LogRecordMapper logRecordMapper;

    /**
     * 新增短链访问记录
     * 
     * @param logRecord 短链访问记录
     * @return 结果
     */
    @Override
    public int insertLogRecord(LogRecord logRecord)
    {
        logRecord.setCreateTime(DateUtils.nowTime());
        return logRecordMapper.insertLogRecord(logRecord);
    }
}
