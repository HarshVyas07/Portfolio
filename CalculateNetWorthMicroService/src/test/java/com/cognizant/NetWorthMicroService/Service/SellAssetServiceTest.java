package com.cognizant.NetWorthMicroService.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.NetWorthMicroService.Repository.NetWorthRepository;

//import static org.mockito.Mockito.when;  
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
class SellAssetServiceTest {
	
	@Mock
	NetWorthRepository repository;
	
//	@Mock
//	AuthClient authClient;

	@InjectMocks
	SellAssetService sellAssetService;

	/*@Test
	void testDeleteStockAssetWithUnits() {
		Map<String, Integer> idList=new HashMap<>();
		idList.put("ABC", 5);
		when(repository.findByPortfolioidAndAssetidAndType(0,"ABC","Share")).thenReturn(new Asset());
		sellAssetService.deleteStockAssetWithUnits(0, idList);
	}

*/
	@Test
	void testDeleteMutualFundAssetWithUnits() {
		//fail("Not yet implemented");
	}

	@Test
	void testIsSessionValid() {
		//fail("Not yet implemented");
	}

}
