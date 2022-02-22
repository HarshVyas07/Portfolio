package com.cognizant.MutualFundNavService.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.MutualFundNavService.Controller.AuthClient;
import com.cognizant.MutualFundNavService.Model.AuthResponse;
import com.cognizant.MutualFundNavService.Model.MutualFund;
import com.cognizant.MutualFundNavService.Repository.MutualFundRepository;

@Service
public class MutualFundServiceImpl implements MutualFundService {
	@Autowired
	private MutualFundRepository mutualFundRepository;
	@Autowired
	private AuthClient authClient;

	@Transactional
	public List<MutualFund> getAllMutualFund() {
		return mutualFundRepository.findAll();
	}

	@Transactional
	public MutualFund getMutualFundByName(String mutualFundName) {
		return mutualFundRepository.findByMutualFundName(mutualFundName);
	}

	@Override
	public List<Double> getMutualFundByIdList(List<String> mutualFundIdList) {
		List<Double> mutualFundValueList = new ArrayList<>();
		List<MutualFund> ls = mutualFundRepository.findByMutualFundId(mutualFundIdList);
		for (MutualFund m : ls) {
			mutualFundValueList.add(m.getMutualFundValue());
		}
		return mutualFundValueList;
	}

	public Boolean isSessionValid(String token) {
		AuthResponse authResponse = authClient.getValidity(token);
		if (authResponse == null)
			throw new RuntimeException("Exception Thrown-Null Auth Response returned");

		return true;
	}

}
