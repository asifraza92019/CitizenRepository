package com.gaya.citizen.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="otp_tab")
public class OtpBean {

	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	 @Column(name="otp")
	private String otp;

	public OtpBean() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "OtpBean [id=" + id + ", otp=" + otp + "]";
	}
	
	 
}
