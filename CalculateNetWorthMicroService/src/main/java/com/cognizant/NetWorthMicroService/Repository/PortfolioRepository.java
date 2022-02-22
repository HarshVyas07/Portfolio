package com.cognizant.NetWorthMicroService.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.NetWorthMicroService.Model.Portfolio;


public interface PortfolioRepository extends JpaRepository<Portfolio,Integer>{

}
