package com.gaya.citizen.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaya.citizen.bean.OtpBean;

@Repository
public interface OtpRepository extends CrudRepository<OtpBean, Integer> {

	        List<OtpBean>   findAll();
	         
	          long count();
}
