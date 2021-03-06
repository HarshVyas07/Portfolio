package com.cognizant.NetWorthMicroService.Controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.NetWorthMicroService.Model.DailySharePrice;


@FeignClient(name="Microservice-1")
public interface ShareDetailsFiegnProxy {
	
	@GetMapping("/dailyAllSharePrice")
	public List<DailySharePrice> findAll();
	
	@GetMapping("/dailySharePrice/byName/{shareName}")
	public DailySharePrice finddailyShareByName(@PathVariable(value="shareName") String shareName);
	
	@GetMapping("/dailySharePrice/{shareIdList}")
	public List<Double> finddailyShareById(@PathVariable(value="shareIdList")List<String> shareIdList);
}

