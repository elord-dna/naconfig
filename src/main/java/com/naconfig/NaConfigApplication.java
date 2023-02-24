package com.naconfig;

import com.naconfig.old.LoadValueConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
//@EnableNacosConfig
//@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
@EnableDubbo
@Import(value = {LoadValueConfig.class})
public class NaConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(NaConfigApplication.class);
    }
}
