package com.dee.profiler.log;

import com.dee.profiler.manager.Manager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by yangyu on 2017/3/16.
 */
public class Logger {

    private final ArrayList<String> content = new ArrayList();

    private final Stack<Map> timeStack = new Stack();

    private Date beginTime;

    private static final String style = "%s.%s耗时:%dms\n";

    private static final Object isWrite = new Object();

    private String name="";

    public Logger(){
        this.beginTime = new Date();
    }

    public void start(){
        StackTraceElement stack = Thread.currentThread().getStackTrace()[3];
        Map map = new HashMap();
        map.put("className",stack.getClassName());
        map.put("methodName",stack.getMethodName());
        map.put("startTime",System.currentTimeMillis());
        timeStack.push(map);
    }

    public void end(){
        Map map = timeStack.pop();
        long time = System.currentTimeMillis()-(long)map.get("startTime");
        content.add(String.format(style,map.get("className"),map.get("methodName"),time));
    }

    public void write(){

        synchronized (isWrite){
            try(FileWriter fw = new FileWriter(Manager.logPath,true)){
                StringBuilder sb = new StringBuilder(String.format("[%s]任务开始时间为[%s]\n",name,beginTime.toString()));
                sb.append(String.format("执行线程名称：[%s]\n",Thread.currentThread().getName()));
                for (String str : content){
                    sb.append(str);
                }
                fw.write(sb.append("\n").toString());
                fw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
