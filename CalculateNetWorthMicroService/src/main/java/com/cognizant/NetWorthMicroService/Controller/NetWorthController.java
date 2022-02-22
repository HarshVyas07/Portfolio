package com.cognizant.NetWorthMicroService.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.NetWorthMicroService.Model.DailySharePrice;
import com.cognizant.NetWorthMicroService.Model.MutualFundNAV;
import com.cognizant.NetWorthMicroService.Model.NetWorth;
import com.cognizant.NetWorthMicroService.Model.SellObjectMap;
import com.cognizant.NetWorthMicroService.Service.NetWorthService;
import com.cognizant.NetWorthMicroService.Service.SellAssetService;

@RestController
@RequestMapping("/NetWorth")
public class NetWorthController {
	
	@Autowired
	private ShareDetailsFiegnProxy proxy;

	@Autowired
	private MutualFundDetailsFeignProxy mutualFundProxy;

	@Autowired
	private NetWorthService netWorthService;
	
	@Autowired
	private SellAssetService sellService;
	
	@GetMapping("/dailySharePrices")
	public List<DailySharePrice> getAllSharePrices() {
		return proxy.findAll();
	}

	@GetMapping("/mutualfunds")
	public List<MutualFundNAV> getAllMutualFunds(@RequestHeader("Authorization") String token) {
		return mutualFundProxy.getAllMututalFunds();
	}

	@GetMapping("/GetAllAssets/{portfolioId}")
	public List<NetWorth> getAllAssets(@RequestHeader("Authorization") String token,@PathVariable(value = "portfolioId") int portfolioId) {
		return netWorthService.getAllAssetForPortfolio(portfolioId);
	}
	
	@GetMapping("/pershare/{stockName}")
	public DailySharePrice getStcokName(@RequestHeader("Authorization") String token,@PathVariable(value = "stockName") String stockName) {
		return proxy.finddailyShareByName(stockName);
	}
	
	
	@GetMapping("/calculateNetworth/{Id}")
	public double getAsset(@RequestHeader("Authorization") String token,@PathVariable(value = "Id") int Id) 
	{
		double netWorth = 0.0;
		int stockCounter = 0, mfCounter = 0;
		List<String> stockAssetList = new ArrayList<>();
		List<String> mutualFundAssetList = new ArrayList<>();
		List<Double> stockValueList = new ArrayList<>();
		List<Double> mutualFundValueList = new ArrayList<>();
		List<NetWorth> assets = netWorthService.getAllAssetForPortfolio(Id);
		for (NetWorth a : assets) {
			if (a.getType().equals("Share")) {
				stockAssetList.add(a.getAssetName()); 
			} else {
				mutualFundAssetList.add(a.getAssetName());
			}
		}
		if (!stockAssetList.isEmpty()) {
			stockValueList = proxy.finddailyShareById(stockAssetList); 
		}
		if (!mutualFundAssetList.isEmpty()) {
			mutualFundValueList = mutualFundProxy.getMutualDetailsById(mutualFundAssetList);
		}
		for (NetWorth a : assets) {
			if (a.getType().equals("Share")) {
				netWorth += a.getUnits() * stockValueList.get(stockCounter);
				stockCounter++;
			} else {
				netWorth += a.getUnits() * mutualFundValueList.get(mfCounter);
				mfCounter++;
			}
		}
		
		return netWorth;
	}
	@PostMapping("/SellAssets")
	public double calculateBalancePostSellPerStock(@RequestHeader("Authorization") String token,@RequestBody SellObjectMap sell) {
		System.out.println(sell.getStockIdList().toString());
		Map<String, Integer> stockIdList = sell.getStockIdList();
		Map<String, Integer> mfIdList = sell.getMfAssetList();
		System.out.println(stockIdList);
		System.out.println(mfIdList);
		if (!stockIdList.isEmpty()) {
			sellService.deleteStockAssetWithUnits(sell.getPid(), stockIdList);
		}
		if (!mfIdList.isEmpty()) {
			sellService.deleteMutualFundAssetWithUnits(sell.getPid(), mfIdList);
		}
		return getAsset(token,sell.getPid());
	}

}

 