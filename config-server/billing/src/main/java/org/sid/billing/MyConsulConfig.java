package org.sid.billing;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="token")
@Data
public class MyConsulConfig {

    private long accessTokenTimeout;
    private long refreshTokenTimeout;
}
