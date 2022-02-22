package com.cognizant.NetWorthMicroService.Controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.NetWorthMicroService.Model.MutualFundNAV;


@FeignClient(name="Microservice-2")
public interface MutualFundDetailsFeignProxy {
	
	@GetMapping("/dailyAllMutualFundNav")
	public List<MutualFundNAV> getAllMututalFunds();
	
	@GetMapping("/dailyMutualFundNav/name/{mutualFundName}")
	public MutualFundNAV getMutualDetails(@PathVariable(value="mutualFundName") String mutualFundName);
	
	@GetMapping("/dailyMutualFundNav/{mutualFundIdList}")
	public List<Double> getMutualDetailsById(@PathVariable(value="mutualFundIdList") List<String> mutualFundId);

}
