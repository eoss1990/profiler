package com.dee.profiler.config;

import com.dee.profiler.log.Logger;

/**
 * Created by yangyu on 2017/3/16.
 */
public class LoggerThreadLocal extends ThreadLocal<Logger>{

    @Override
    protected Logger initialValue() {
        return new Logger();
    }
}
