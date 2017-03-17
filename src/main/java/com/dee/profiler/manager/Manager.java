package com.dee.profiler.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yangyu on 2017/3/16.
 */
public class Manager {

    private static final String CONFIG_FILE_NAME = "profile.properties";

    public static String logPath;

    private Manager() {
    }

    private static Manager manager = new Manager();

    public static Manager getInstance() {
        return manager;
    }

    public void init() {
        String configUrl = System.getProperty(CONFIG_FILE_NAME);
        if (configUrl == null || "".equals(configUrl))
            throw new RuntimeException(String.format("配置文件路径:%s错误", configUrl));

        Properties p = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(configUrl);
            p.load(in);
            logPath = p.getProperty("logPath");

        } catch (Exception e) {
            throw new RuntimeException(String.format("配置文件读取错误%s", configUrl));
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
