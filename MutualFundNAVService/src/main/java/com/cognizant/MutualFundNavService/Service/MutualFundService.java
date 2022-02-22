package com.cognizant.MutualFundNavService.Service;

import java.util.List;
import com.cognizant.MutualFundNavService.Model.MutualFund;

public interface MutualFundService {
	public List<MutualFund> getAllMutualFund();
	public MutualFund getMutualFundByName(String mutualFundName);
	public List<Double> getMutualFundByIdList(List<String> mutualFundIdList);
	public Boolean isSessionValid(String token);
}
