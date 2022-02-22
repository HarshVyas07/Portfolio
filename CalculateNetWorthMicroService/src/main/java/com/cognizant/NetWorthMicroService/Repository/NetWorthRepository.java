package com.cognizant.NetWorthMicroService.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.NetWorthMicroService.Model.NetWorth;

public interface NetWorthRepository extends JpaRepository<NetWorth, Integer> {
	public List<NetWorth> findByPortfolioIdOrderByAssetName(int id);
	
	public NetWorth findByPortfolioIdAndAssetNameAndType(int portfolioId, String assetName, String type);

}
