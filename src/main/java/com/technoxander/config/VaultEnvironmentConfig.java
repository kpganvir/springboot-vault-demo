package com.technoxander.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
@Data
@Configuration
@ConfigurationProperties(prefix = "vault.config")
public class VaultEnvironmentConfig {
    private URI uri;
    private String token;
}
