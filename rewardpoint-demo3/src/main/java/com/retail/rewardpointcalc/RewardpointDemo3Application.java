package com.retail.rewardpointcalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.retail.rewardpointcalc.model.CustomerResponseMapper;
import com.retail.rewardpointcalc.model.TransactionResponseMapper;

@SpringBootApplication
public class RewardpointDemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(RewardpointDemo3Application.class, args);
	}

	
	@Bean
	public CustomerResponseMapper getCustomerMapper() {
		return new CustomerResponseMapper();
	}
	
	@Bean
	public TransactionResponseMapper getTransactionMapper() {
		return new TransactionResponseMapper();
	}
}
