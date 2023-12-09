package org.sid.inventoryservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class inventoryController {
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    @Value("${inventory.params.a}")
    private String a;
    @Value("${inventory.params.b}")
    private String b;
    @GetMapping("/params")
    public Map<String, String> params(){
//        return Map.of("p1",p1);
        return Map.of("p1",p1,"p2",p2,"a",a,"b",b);
}
}
