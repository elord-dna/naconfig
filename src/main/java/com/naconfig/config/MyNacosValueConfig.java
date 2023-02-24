package com.naconfig.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 实际测试中，@NacosValue总是第二新的值
 */
//@NacosPropertySource(groupId = "abc", dataId = "abc", type = ConfigType.YAML, autoRefreshed = true)
@Component
public class MyNacosValueConfig {

    @Value("${aval}")
    private String aval;

    @NacosValue(value = "${aval}", autoRefreshed = true)
    private String naval;

    public String getAval() {
        return aval;
    }

    public void setAval(String aval) {
        this.aval = aval;
    }

    public String getNaval() {
        return naval;
    }

    public void setNaval(String naval) {
        this.naval = naval;
    }
}
