package com.mytrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrader.model.StockSignals;
import com.mytrader.model.StockSignalsRepository;

@Service
public class StockSignalsService {
	
	@Autowired
	StockSignalsRepository stockSignalsRepository;
	

	public List<StockSignals> findAll() {
		return stockSignalsRepository.findAll();
	}
	
}
