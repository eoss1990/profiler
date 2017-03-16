package com.dee.profiler.log;

import com.dee.profiler.config.LoggerThreadLocal;

/**
 * Created by yangyu on 2017/3/16.
 */
public class LoggerManager {

    private static final LoggerThreadLocal THREAD_LOCAL = new LoggerThreadLocal();

    public static void start(){
        THREAD_LOCAL.get().start();
    }

    public static void end(){
        THREAD_LOCAL.get().end();
    }

    public static void write(){
        THREAD_LOCAL.get().write();
        THREAD_LOCAL.remove();
    }

    public static void setName(String name){
        THREAD_LOCAL.get().setName(name);
    }
}
