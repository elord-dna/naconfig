package com.naconfig.task;

import com.naconfig.config.MyRefreshScopeConfig;
import com.naconfig.old.LoadValueConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
//@RefreshScope
public class LazyTask {
    private static final Logger logger = LoggerFactory.getLogger(LazyTask.class);

    @Value("${aval}")
    private String aval;
    @Autowired
    private MyRefreshScopeConfig config;

    @Scheduled(cron = "${cron}")
    public void taskRun() {
        System.out.println(new Date());
        logger.info(config.getAval());
        logger.error(LoadValueConfig.getProperty("aval"));
    }

}
