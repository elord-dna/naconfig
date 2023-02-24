package com.naconfig.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.naconfig.config.MyAntiNacoConfig;
import com.naconfig.config.MyNacoConfig;
import com.naconfig.config.MyNacosValueConfig;
import com.naconfig.config.MyRefreshScopeConfig;
import com.naconfig.dubbo.IDealService;
import com.naconfig.old.LoadValueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
//@RefreshScope
//@NacosPropertySource(groupId = "abc", dataId = "abc", type = ConfigType.YAML, autoRefreshed = true)
public class TestController {
    @NacosValue(value = "${aval}", autoRefreshed = true)
    private String aval;
    @Value("${vlist}")
    private List<String> alist;
    @Value("${vset}")
    private Set<String> aset;
    @Value("#{'${vlist}'.split(',')}")
    private List<String> blist;
    @Value("${cat}")
    private String aString;

    @Autowired
    private IDealService dealService;

    @Autowired
    private MyNacoConfig naco;
    @Autowired
    private MyAntiNacoConfig antiNaco;
    @Autowired
    private MyNacosValueConfig nacosValueConfig;
    @Autowired
    private MyRefreshScopeConfig refreshScopeConfig;

    @RequestMapping("/test")
    public Object test() {
        return "test";
    }
    @RequestMapping("/get")
//    @Log
    public String get() {
        return aval;
    }

    @RequestMapping("val")
    public String val() {
        return naco.getAval();
    }
    @RequestMapping("antiVal")
    public String antiVal() {
        return antiNaco.getAval();
    }

    @RequestMapping("nvc")
    public Object nvc() {
        Map<String, String> map = new HashMap<>();
        map.put("@Value", nacosValueConfig.getAval());
        map.put("@NacosValue", nacosValueConfig.getNaval());
        map.put("EnvironmentAware", LoadValueConfig.getProperty("aval"));
        map.put("@NacosConfigurationProperties", naco.getAval());
        map.put("@RefreshScope", refreshScopeConfig.getAval());
        return map;
    }
    @RequestMapping("fresh")
    public Object fresh() {
        return refreshScopeConfig.getAval();
    }

    @RequestMapping("/listTest")
    public Map<String, Object> listTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("alist", alist);
        map.put("aset", aset);
        map.put("blist", blist);
        map.put("aString", aString);
        return map;
    }

    @RequestMapping("/deal")
    public String deal() {
        return dealService.sayDeal();
    }

    public void setAval(String aval) {
        this.aval = aval;
    }
}
