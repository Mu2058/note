package com.utils.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具类
 * @author luomj
 * @version 1.0
 * @description
 * @date 2019/07/18
 **/
@Component
public class ThreadUtils {
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            //线程池大小
            2,
            //最大线程数量
            5,
            //允许线程空闲时间
            10,
            //空闲时间单位
            TimeUnit.SECONDS,
            //缓存任务排队策略(链表实现队列,有界限)
            new LinkedBlockingDeque<>(1024),
            //handler拒绝策略,当线程池满了,缓存任务的阻塞队列也满了会使用拒绝策略(这里直接抛RejectedExecutionException异常)
            new ThreadPoolExecutor.AbortPolicy());

    public static void execution(Runnable runnable){
        threadPool.execute(runnable);
    }
}
