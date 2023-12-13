package com.merchant;

import com.merchant.Authentication.Adminlogin;
import com.merchant.Service.AdminService.AdminImplimentation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.merchant")
public class MerchantRelationshipManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantRelationshipManagementApplication.class, args);

	}

}
