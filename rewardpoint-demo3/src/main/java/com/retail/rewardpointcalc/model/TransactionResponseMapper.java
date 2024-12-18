package com.retail.rewardpointcalc.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retail.rewardpointcalc.entity.Transaction;
import com.retail.rewardpointcalc.service.RewardPointCalcService;

@Component
public class TransactionResponseMapper {
	int totalRewardPnt = 0;

	
	 @Autowired
	 private  RewardPointCalcService rewardPointCalcService;
	 
	 public TransactionResponseMapper(){
		 System.out.println("rewardPointCalcService in noarg Trans Const:"+rewardPointCalcService);
			if(this.rewardPointCalcService!=null) {
				System.out.println("rewardPointCalcService in noarg Trans Const:"+rewardPointCalcService);
			}
	 }
	 
		/*
		 * @Autowired TransactionResponseMapper(RewardPointCalcService
		 * rewardPointCalcService){ if(rewardPointCalcService!=null) {
		 * System.out.println("rewardPointCalcService :"+rewardPointCalcService); }
		 * this.rewardPointCalcService=rewardPointCalcService; }
		 */
	
	public static TransactionResponse mapToTransactionResponse(Transaction transaction,
			TransactionResponse transactionResponse) {

		transactionResponse.setCustomerId(Long.valueOf(transaction.getCustomerId()));
		transactionResponse.setRewardpoints(transaction.getRewardPoints());
		transactionResponse.setTransAmt(transaction.getTransAmt());
		transactionResponse.setTransDate(transaction.getTransDate());
		transactionResponse.setTransId(transaction.getTransId());

		return transactionResponse;
	}
	
	public  TransactionResponse mapToTransactionResponse1(TransactionRequest transaction,
			TransactionResponse transactionResponse) {
		

		transactionResponse.setCustomerId(Long.valueOf(transaction.getCustomerId()));
		try {
			try {
				transactionResponse.setRewardpoints(rewardPointCalcService.getCustomerRewardPoint(transaction.getTransAmt()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transactionResponse.setTransAmt(transaction.getTransAmt());
		transactionResponse.setTransDate(transaction.getTransDate());
		/*
		 * try { transactionResponse.setTransDate(convert(transaction.getTransDate()));
		 * } catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		transactionResponse.setTransId(transaction.getTransId());

		return transactionResponse;
	}
	
	  public  Date convert(String dateString) throws ParseException {
		    System.out.println("Given date is " + dateString);

		   // DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		    DateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		    
		    Date date = sdf.parse(dateString);

		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date));
		    System.out.println("yyyy-MM-dd formatted date : " + new SimpleDateFormat("yyyy-MM-dd").format(date));
		    date=  new Date(new SimpleDateFormat("yyyy-MM-dd").format(date));
		    return date;
		  }
	  
	  
	  public  Date convert(Date date) throws ParseException {
		    System.out.println("Given date is " + date);

		   // DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		    DateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		    
		   // Date date = sdf.parse(dateString);

		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date));
		    System.out.println("yyyy-MM-dd formatted date : " + new SimpleDateFormat("yyyy-MM-dd").format(date));
		    
		    new SimpleDateFormat("yyyy-MM-dd").format(date).toString();
		  new SimpleDateFormat("yyyy-MM-dd").format(date);
		    return new Date( new SimpleDateFormat("yyyy-MM-dd").format(date));
		  }
	  
			/*
			 * Date convertToString(Date dateValue) {
			 * 
			 * dateValue.toString(); String dateTimeString = dateValue.toString();
			 * 
			 * DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
			 * LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);.
			 * 
			 * 
			 * return new Date(dateTime.toString());
			 * 
			 * 
			 * }
			 */

}
