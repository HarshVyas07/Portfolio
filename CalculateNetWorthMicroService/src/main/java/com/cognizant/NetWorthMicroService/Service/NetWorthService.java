package com.cognizant.NetWorthMicroService.Service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import com.cognizant.NetWorthMicroService.Model.DailySharePrice;
import com.cognizant.NetWorthMicroService.Model.MutualFundNAV;
import com.cognizant.NetWorthMicroService.Model.NetWorth;

public interface NetWorthService {
	public List<NetWorth> getAllAssetForPortfolio(int id);

	
}
