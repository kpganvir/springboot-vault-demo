package com.technoxander.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.core.VaultTemplate;

@Slf4j
@Configuration
public class BeanConfig {

    @Autowired
    VaultEnvironmentConfig vaultConfig;
    @Bean
    @ConditionalOnMissingBean(VaultOperations.class)
    @ConditionalOnProperty(name = "spring.cloud.vault.enabled", matchIfMissing = true)
    public VaultTemplate vaultTemplate(){

        log.info("configuring getVaultTemplate bean starts");
        VaultEndpoint endpoint =VaultEndpoint.from(vaultConfig.getUri());
        endpoint.setScheme("http");
        VaultTemplate vaultTemplate = new VaultTemplate(endpoint,
                new TokenAuthentication(vaultConfig.getToken()));

        log.info("configuring getVaultTemplate bean end");
        return vaultTemplate;
    }

}
