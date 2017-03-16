package com.dee.profiler.config;

/**
 * Created by yangyu on 2017/3/16.
 */
public class ProfFilter {

    private static final String PKG = "com/seeyon/v3x/dee/adapter";

    private static final String FLOW = "com/seeyon/v3x/dee/context/Flow";

    private static final String FlOW_EXECUTE_DESC = "(Lcom/seeyon/v3x/dee/Document;Lcom/seeyon/v3x/dee/TransformContext;Lcom/seeyon/v3x/dee/Parameters;Ljava/lang/String;)Lcom/seeyon/v3x/dee/Document;";

    public static final String METHOD_NAME = "execute";

    private static final String StrStyle = "[%s] was injected";

    public static boolean isAdapter(String className) {
        if (className.startsWith(PKG)){
            System.out.println(String.format(StrStyle,className));
            return true;
        }
        return false;
    }

    public static boolean isFlow(String className) {
        if (FLOW.equals(className)){
            System.out.println(String.format(StrStyle,className));
            return true;
        }
        return false;
    }

    public static boolean isFlowExecute(String name, String desc){
        if (METHOD_NAME.equals(name)&&FlOW_EXECUTE_DESC.equals(desc)){
            System.out.println(String.format("Flow.[%s] was injected",name));
            return true;
        }
        return false;
    }

    public static boolean isIgnore(String className){
        return IgnoreClass.contains(className);
    }
}
