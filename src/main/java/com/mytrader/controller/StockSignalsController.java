package com.mytrader.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytrader.model.StockSignals;
import com.mytrader.service.StockSignalsService;

@RestController
public class StockSignalsController {
	private static final Logger log = LoggerFactory.getLogger(StockController.class);
	@Autowired
	StockSignalsService stockSignalsService;	
	

	@RequestMapping(value="/api/getSignals/{indicators}", method=RequestMethod.GET)
	public List<StockSignals> getSignalsData(@PathVariable List<String> indicators) throws IOException {
		
		List<StockSignals> stockSignalsListFiltered = new ArrayList();
		List<StockSignals> stockSignalsList = stockSignalsService.findAll();
		
	    Iterator iterator = stockSignalsList.iterator();
	    while(iterator.hasNext()) {
	        	StockSignals stockSignals =(StockSignals)iterator.next();
	        	for(String param : indicators) {
	    	        System.out.println("ind:" + param);
	    	        if(stockSignals.getSignal().equals(param)) {
	    	        	stockSignalsListFiltered.add(stockSignals);
	        	}

	        }
	     }

		
		

		stockSignalsListFiltered.forEach(stockSignals -> {
			System.out.println("symbol:"+stockSignals.getStock());
		});

		return stockSignalsListFiltered;
	}
	
}
