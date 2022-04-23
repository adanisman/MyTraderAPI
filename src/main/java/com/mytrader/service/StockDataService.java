package com.mytrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrader.model.StockDataRepository;
import com.mytrader.model.StockData;

@Service
public class StockDataService {
	@Autowired
	StockDataRepository stockDataRepository;
	
	public void save(StockData stockData) {
		stockDataRepository.save(stockData);
	}
}
