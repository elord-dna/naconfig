package com.naconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class MyRefreshScopeConfig {
    @Value("${aval}")
    private String aval;

    public String getAval() {
        return aval;
    }

    public void setAval(String aval) {
        this.aval = aval;
    }
}
