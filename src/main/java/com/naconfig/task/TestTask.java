package com.naconfig.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
//@RefreshScope
public class TestTask implements ApplicationListener<RefreshScopeRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(TestTask.class);

    @Value("${aval}")
    private String aval;

    @Scheduled(cron = "${cron}")
    public void taskRun() {
        logger.info(aval);
    }

    @Override
    public void onApplicationEvent(RefreshScopeRefreshedEvent refreshScopeRefreshedEvent) {
        logger.info("test task reload");
    }
}
