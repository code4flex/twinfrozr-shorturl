package com.twinfrozr.shorturl.core.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * 自定义destroy管理
 *
 * @author marvin
 */
@Component
public class ShutdownManager {

    private static final Logger logger = LoggerFactory.getLogger(ShutdownManager.class);

    @PreDestroy
    public void destroy() {

        try {
            logger.info("====关闭后台任务任务线程池====");
            TasksManager.me().shutdown();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
    }
}
