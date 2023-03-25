package com.technoxander.service;

import com.technoxander.model.VaultSecrets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultTransitOperations;

@Service
public class VaultService {


    private static final String VAULT_PATH = "secret/my-deb-credentials";
    @Autowired
    VaultTemplate vaultTemplate;
    private VaultKeyValueOperations keyValueOperations;
    private VaultTransitOperations transitOperations;

    private void init()
    {
        this.transitOperations = vaultTemplate.opsForTransit();
        this.keyValueOperations=  vaultTemplate.opsForKeyValue(VAULT_PATH, VaultKeyValueOperationsSupport.KeyValueBackend.unversioned());

    }
    public void writeKV(VaultSecrets vaultSecrets)
    {

    }
    public VaultSecrets readKV()
    {

    }

    public String writeTransit(String password)
    {

    }
    public String readTransit()
    {

    }

}
