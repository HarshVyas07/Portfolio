package com.cognizant.NetWorthMicroService.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.NetWorthMicroService.Model.NetWorth;
import com.cognizant.NetWorthMicroService.Repository.NetWorthRepository;

@Service
public class NetWorthServiceImpl implements NetWorthService {

	@Autowired
	private NetWorthRepository netWorthRepository;
	
	@Transactional
	public List<NetWorth> getAllAssetForPortfolio(int id) {
		return netWorthRepository.findByPortfolioIdOrderByAssetName(id);
	}
	
		

}