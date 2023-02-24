package com.naconfig.config;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@NacosConfigurationProperties(dataId = "abc.yml", groupId = "abc", type = ConfigType.YAML, autoRefreshed = true)
@Configuration
public class MyAntiNacoConfig {
    private String aval;

    public String getAval() {
        return aval;
    }

    public void setAval(String aval) {
        this.aval = aval;
    }
}
