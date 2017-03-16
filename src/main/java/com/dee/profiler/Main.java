package com.dee.profiler;

import com.dee.profiler.instrument.ProfTransformer;
import com.dee.profiler.manager.Manager;

import java.lang.instrument.Instrumentation;

/**
 * Created by yangyu on 2017/3/16.
 */
public class Main {

    public static void premain(String args, Instrumentation inst) {
        System.out.println("premain is starting..........");
        Manager.getInstance().init();
        inst.addTransformer(new ProfTransformer());
    }
}
