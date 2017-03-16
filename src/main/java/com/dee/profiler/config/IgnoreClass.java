package com.dee.profiler.config;

import java.util.HashSet;

/**
 * Created by yangyu on 2017/3/16.
 */
public class IgnoreClass {

    private static final HashSet<String> ignoreClassSet = new HashSet();

    static {
        ignoreClassSet.add("com/seeyon/v3x/dee/adapter/AdapterWrapper");
    }

    public static boolean contains(String className){
        return ignoreClassSet.contains(className);
    }
}
