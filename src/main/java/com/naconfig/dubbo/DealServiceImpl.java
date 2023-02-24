package com.naconfig.dubbo;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Description:
 * @Auther: zlhuang9
 * @Date: 2023-02-09
 */
@DubboService
public class DealServiceImpl implements IDealService {
    @Override
    public String sayDeal() {
        return "Deal...";
    }
}
