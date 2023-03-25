package com.vaultdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class VaultdemoApplication {



	public static void main( String[] args )
	{
		SpringApplication.run( VaultdemoApplication.class, args );
		setVault();
	}

   private static void setVault()
   {

	   VaultEndpoint endpoint =VaultEndpoint.create("localhost", 8200);
	  endpoint.setScheme("http");
	   VaultTemplate vaultTemplate = new VaultTemplate(endpoint,
			   new TokenAuthentication("hvs.xlmDmcPmuRY7HHDKvO0mk3oV"));


//	   VaultResponseSupport<VaultSecrets> config=
////			   vaultTemplate.read("secret/application", VaultSecrets.class);
//        String data="mysql";
//
//			   vaultTemplate.write("secret/application", Collections.singletonMap("key3", "dev3"));
//	    VaultResponseSupport<Map> config=vaultTemplate.read("secret/application", Map.class);


	 // System.out.println(config.getData().get("key"));
	//   System.out.println("val is "+val);

	   Map<String, Object> secretData1 = new HashMap<>();
	   secretData1.put("username1", "myUsername");
	   secretData1.put("password1", "myPassword");

	   Map<String, Object> secretData2 = new HashMap<>();
	   secretData2.put("username2", "myUsername");
	   secretData2.put("password2", "myPassword");

	  VaultOperations vaultOperations=vaultTemplate;
	   VaultKeyValueOperations operations =
			   vaultOperations.opsForKeyValue("secret/application", VaultKeyValueOperationsSupport.KeyValueBackend.unversioned());

	   operations.put("key", secretData1);

	   operations.put("key2", secretData2);

	   VaultResponseSupport<Map> person = operations.get("key", Map.class);
	   VaultResponseSupport<Map> person2 = operations.get("key2", Map.class);
	   System.out.println("val is "+person.getData());
	   System.out.println("val is "+person2.getData());
   }
}
