package com.technoxander.controller;

import com.technoxander.model.VaultSecrets;
import com.technoxander.service.VaultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//@Validated
@RestController
@RequestMapping("vault-demo")
public class VaultController {

    @Autowired
    VaultService VaultService;
    @PostMapping( "/write-sercret" )
    public ResponseEntity<String> writeVaultSecrets(
            @RequestBody VaultSecrets vaultSecrets)throws Exception
    {
        log.info("writing  VaultSecrets object in vault");

        VaultService.writeKV(vaultSecrets);

        return ResponseEntity.ok().body( " VaultSecrets object written successfully" );
    }
}
