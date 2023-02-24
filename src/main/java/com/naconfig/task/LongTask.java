package com.naconfig.task;

import com.naconfig.config.MyRefreshScopeConfig;
import com.naconfig.old.LoadValueConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class LongTask implements ApplicationListener<RefreshScopeRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(LongTask.class);

    @Value("${aval}")
    private String aval;

    @Autowired
    private MyRefreshScopeConfig config;


    @Scheduled(cron = "${cron}")
    public void taskRun() {
        logger.info(aval);
        logger.warn(config.getAval());
        logger.error(LoadValueConfig.getProperty("aval"));
        logger.info("list: {}", LoadValueConfig.getAsList("vlist"));
    }

    @Override
    public void onApplicationEvent(RefreshScopeRefreshedEvent refreshScopeRefreshedEvent) {
        logger.info("long task reload");
    }
}
