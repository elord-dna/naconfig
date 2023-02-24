package com.naconfig.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class AllValue {
    @Value("${changed.value}")
    private String changedValue;

    public String getChangedValue() {
        return changedValue;
    }
}
