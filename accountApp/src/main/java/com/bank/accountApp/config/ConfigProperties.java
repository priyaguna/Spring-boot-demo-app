package com.bank.accountApp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "custom")
public class ConfigProperties {
    private String bankName;
    private String cardName;
}
