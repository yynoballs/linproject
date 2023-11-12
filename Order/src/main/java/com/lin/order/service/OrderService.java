package com.lin.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@FeignClient(value = "nacos-Lin-Core")
public interface OrderService {

    @PostMapping("base/test")
    String test();

}
