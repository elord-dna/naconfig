package com.naconfig.old;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 可以刷新，但是第一次会稍慢（可能有1-3s）反应比@refreshscope要慢
 * 好像和refreshScope一样快
 */
//@Component
public class LoadValueConfig implements EnvironmentAware {
    public static Environment env;
    public static String getEnv(String key) {
        return env.getProperty(key);
    }
    public static String getProperty(String key) {
        return env.getProperty(key);
    }
    @Override
    public void setEnvironment(Environment environment) {
        LoadValueConfig.env = environment;
    }

    public static List<String> getAsList(String key) {
        return env.getProperty(key, List.class);
    }
}
