package com.naconfig.config;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Component;

//@ConfigurationProperties

/**
 * 这个是正常刷新 aval 的值
 */
@NacosConfigurationProperties(dataId = "abc.yml", groupId = "abc", type = ConfigType.YAML, autoRefreshed = true)
@Component
public class MyNacoConfig {
//    @NacosValue(value = "${aval}", autoRefreshed = true)
    private String aval;

    public String getAval() {
        return aval;
    }

    public void setAval(String aval) {
        this.aval = aval;
    }
}
