package com.twinfrozr.shorturl.core.task;

import com.twinfrozr.shorturl.common.spring.SpringUtils;
import com.twinfrozr.shorturl.common.utils.IpUtils;
import com.twinfrozr.shorturl.common.utils.ServletUtils;
import com.twinfrozr.shorturl.restful.domain.entity.LogRecord;
import com.twinfrozr.shorturl.restful.service.impl.LogRecordService;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * 异步任务
 *
 * @author marvin
 * @date 2020-22-11
 */
public class AsyncTasks {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTasks.class);

    /**
     * 短链访问记录异步处理
     *
     * @param deCode
     * @param url
     * @return
     */
    public static TimerTask logRecordHandler(final String deCode, final String url)
    {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IpUtils.getHostIp();
        return new TimerTask()
        {
            @Override
            public void run()
            {
                String location = IpUtils.getLocation(ip);
                String os = userAgent.getOperatingSystem().getName();
                String browser = userAgent.getBrowser().getName();

                LogRecord logRecord = new LogRecord();
                logRecord.setIp(ip);
                logRecord.setLocation(location);
                logRecord.setBrowser(browser);
                logRecord.setOs(os);
                logRecord.setUrl(url);
                logRecord.setsUrl(deCode);

                SpringUtils.getBean(LogRecordService.class).insertLogRecord(logRecord);
            }
        };
    }
}
