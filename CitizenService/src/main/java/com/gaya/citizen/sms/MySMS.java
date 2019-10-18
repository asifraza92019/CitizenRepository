package com.gaya.citizen.sms;

import com.clxcommunications.xms.ApiConnection;
import com.clxcommunications.xms.ClxApi;
import com.clxcommunications.xms.api.MtBatchTextSmsResult;
import com.gaya.citizen.otp.GenerateOtp;

public class MySMS {

	public  String sendSms() {
		GenerateOtp generateOtp = new GenerateOtp(); 
		 String otp= generateOtp.generateOtp(); 
		
		try (ApiConnection conn = ApiConnection.builder()
		.servicePlanId("0e0f1befe92b48568f3db746120cbba4")
		.token("3dd4f95c28d44cfab9656b21bbedfae3")
		       .start()) {
				MtBatchTextSmsResult batch = conn.createBatch(
				ClxApi.batchTextSms()
				.sender("919262869002")
				.addRecipient("918252089308")
				.body("Namaskar!! "+ otp + "is your one time password")
				.build());

				System.out.println("Successfully sent batch " + batch.id());
				
				return "success" +batch.id();
		} 
	catch (Exception e) {
				System.out.println("Batch send failed: " + e.getMessage());
				return "fail";
		}
}
}
