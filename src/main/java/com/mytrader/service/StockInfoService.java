package com.mytrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrader.model.StockInfo;
import com.mytrader.model.StockInfoRepository;

@Service
public class StockInfoService {
	
	@Autowired
	StockInfoRepository stockInfoRepository;
	
	public void save(StockInfo stockInfo) {
		stockInfoRepository.save(stockInfo);
	}
	public void saveAll(List<StockInfo> stockInfoList) {
		// TODO Auto-generated method stub
		stockInfoRepository.saveAllAndFlush(stockInfoList);
	}
	
	public List<StockInfo> findAll() {
		return stockInfoRepository.findAll();
	}
	
}
