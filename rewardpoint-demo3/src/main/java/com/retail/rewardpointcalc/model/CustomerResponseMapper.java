package com.retail.rewardpointcalc.model;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retail.rewardpointcalc.entity.Customer;
import com.retail.rewardpointcalc.service.RewardPointCalcService;

@Component
public class CustomerResponseMapper {
	
	
	@Autowired
	 RewardPointCalcService rewardPointCalcService; 
	
	@Autowired
	private TransactionResponseMapper getTransactionMapper;
	
	
	
	public CustomerResponseMapper(){
		System.out.println("rewardPointCalcService in CustomerResponseMapper :"+rewardPointCalcService);
	}

	@Autowired
public	CustomerResponseMapper(RewardPointCalcService rewardPointCalcService){
	if(rewardPointCalcService!=null) {
		System.out.println("rewardPointCalcService in CustomerResponseMapper :"+rewardPointCalcService);
	}
		       this.rewardPointCalcService=rewardPointCalcService;
	}
	
   
	
	public static CustomerResponse mapToCustomerResponse(Customer customer, CustomerResponse customerResponse) {
		customerResponse.setCustomerId(customer.getCustomerId());
		customerResponse.setCustomerName(customer.getCustomerName());
		customerResponse.setCreated_at(customer.getCreated_at());
		customerResponse.setCreated_by(customer.getCreated_by());
		customerResponse.setAddress(customer.getAddress());
		customerResponse.setEmailID(customer.getEmailID());
		customerResponse.setPhone(customer.getPhone());
		customerResponse.setUpdated_at(customer.getUpdated_at());
		customerResponse.setUpdated_by(customer.getUpdated_by());
		

		customerResponse.setTransList(CustomerResponseMapper.mapToTransactionResList(customer.getTransActionList(),
				customerResponse.getTransList().get()));
		return customerResponse;
	}

	public static Optional<List<TransactionResponse>> mapToTransactionResList(
			List<com.retail.rewardpointcalc.entity.Transaction> transactionList,
			List<TransactionResponse> listTransResp) {

		if (transactionList != null) {
			transactionList.stream().forEach(transaction -> {
				listTransResp.add(

						TransactionResponseMapper.mapToTransactionResponse(transaction, new TransactionResponse()));
			});
		}

		return Optional.ofNullable(listTransResp);
	}
	
	public   CustomerResponse mapToCustomerTransactionResponse(CustomerTransactionRequest customer, CustomerResponse customerResponse) { 
	customerResponse.setCustomerId(Integer.parseInt(customer.getCustomerId()));
	customerResponse.setCustomerName(customer.getCustomerName());
	
	customerResponse.setAddress(customer.getAddress());
	customerResponse.setEmailID(customer.getEmailID());
	customerResponse.setPhone(Integer.parseInt(customer.getPhone()));
	
	customerResponse.setTransList(mapToTransactionResList1(customer.getTransActionList(),
			customerResponse.getTransList().get()));
	return customerResponse;
}
	
	public   Optional<List<TransactionResponse>> mapToTransactionResList1(
			List<com.retail.rewardpointcalc.model.TransactionRequest> transactionList,
			List<TransactionResponse> listTransResp) {
		
		//TransactionResponseMapper transactionResponseMapper = new TransactionResponseMapper(rewardPointCalcService);
		
		//TransactionResponseMapper transactionResponseMapper = new TransactionResponseMapper();

		if (transactionList != null) {
			
			 // Getting ListIterator
	      
	        
			transactionList.stream().forEach(transaction -> {
				
				listTransResp.add(

						getTransactionMapper.mapToTransactionResponse1(transaction, new TransactionResponse()));
			});
		}

		return Optional.ofNullable(listTransResp);
	}
	
	

}
