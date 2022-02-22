package com.cognizant.NetWorthMicroService.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.NetWorthMicroService.Controller.AuthClient;
import com.cognizant.NetWorthMicroService.Model.AuthResponse;
import com.cognizant.NetWorthMicroService.Model.NetWorth;
import com.cognizant.NetWorthMicroService.Repository.NetWorthRepository;

@Service
public class SellAssetService {
	
	@Autowired
	private NetWorthRepository repository;
	
	@Autowired
	private AuthClient authClient;
	
	public void deleteStockAssetWithUnits(int portfolioId,Map<String,Integer> idList) {
		for(String id:idList.keySet()) {
		NetWorth a = repository.findByPortfolioIdAndAssetNameAndType(portfolioId,id,"Share");
		int units=a.getUnits()-idList.get(id);
		if(units>0) {
			a.setUnits(units);
			repository.save(a);
		}
		else {
			repository.delete(a);
		}
		}
	}
	
	public void deleteMutualFundAssetWithUnits(int portfolioId,Map<String, Integer> mfIdList) {
		for(String id:mfIdList.keySet()) {
			NetWorth a = repository.findByPortfolioIdAndAssetNameAndType(portfolioId,id,"MF");
			int units=a.getUnits()-mfIdList.get(id);
			if(units>0) {
				a.setUnits(units);
				repository.save(a);
			}
			else {
				repository.delete(a);
			}
			}
	}
	
	public Boolean isSessionValid(String token) {
		try {
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		} 
		return true;
	}
	

}
