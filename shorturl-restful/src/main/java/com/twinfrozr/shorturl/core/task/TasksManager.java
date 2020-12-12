package com.twinfrozr.shorturl.core.task;

import com.twinfrozr.shorturl.common.spring.SpringUtils;
import com.twinfrozr.shorturl.common.utils.Threads;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 异步任务管理器
 *
 * @author mavin
 */
public class TasksManager {

    /**
     * 延迟10毫秒
     */
    private final int OPERATE_DELAY_TIME = 10;

    /**
     * 异步任务调度线程池
     */
    private ScheduledExecutorService executor = SpringUtils.getBean("scheduledExecutorService");

    private TasksManager(){}

    private static TasksManager me = new TasksManager();

    public static TasksManager me()
    {
        return me;
    }

    /**
     * process task
     *
     * @param task 任务
     */
    public void execute(TimerTask task)
    {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

    /**
     * shutdown task
     */
    public void shutdown()
    {
        Threads.shutdownAndAwaitTermination(executor);
    }
}
