package com.gaya.citizen.service;

import java.util.List;

import com.gaya.citizen.bean.OtpBean;

public interface OtpService {

	public List<OtpBean> getAllOtp();

	public OtpBean saveOtp(OtpBean otp);
	
	
	public int count();	
}
