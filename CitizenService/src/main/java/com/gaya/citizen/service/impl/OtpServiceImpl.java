package com.gaya.citizen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaya.citizen.bean.OtpBean;
import com.gaya.citizen.repositories.OtpRepository;
import com.gaya.citizen.service.OtpService;

@Service
public class OtpServiceImpl implements OtpService{

	    @Autowired
	  private OtpRepository otpRepository;
	
	@Override
	public List<OtpBean> getAllOtp() {
		
		return otpRepository.findAll();
	}

	@Override
	public OtpBean saveOtp(OtpBean otp) {
	
		return  otpRepository.save(otp);
		
	}

	@Override
	public int count() {
	    return (int)otpRepository.count();
		
	}

}
