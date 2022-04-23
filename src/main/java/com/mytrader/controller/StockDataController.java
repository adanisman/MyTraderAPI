package com.mytrader.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytrader.model.StockInfo;
import com.mytrader.service.StockDataService;
import com.mytrader.service.StockInfoService;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@RestController
public class StockDataController {
	private static final Logger log = LoggerFactory.getLogger(StockController.class);
	@Autowired
	StockDataService stockDataService;
	@Autowired
	StockInfoService stockInfoService;
	private StockInfo stockInfo;
	
	
	
	@RequestMapping("/api/download")
	public String downloadData() throws IOException {

		List<StockInfo> stockInfoList = stockInfoService.findAll();
		
/*
		String[] symbols = new String [stockInfoList.size()];
		for (int i=0;i<stockInfoList.size();i++) {
			stockInfo = stockInfoList.get(i);
			symbols[i]=stockInfo.getSymbol();
		}
	*/	
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.YEAR, -1); // from 1 year
		stockInfoList.forEach(stockInfo -> {
	
			Stock stock;
			try {
				stock = YahooFinance.get(stockInfo.getSymbol());
				System.out.println("symbol:"+stockInfo.getSymbol());
				if (stock != null) {
					List<HistoricalQuote> stockHist = stock.getHistory(from, to, Interval.DAILY);
					stockHist.forEach(quote -> {
					//System.out.println("symbol:"+ quote.getDate()+" Open:" + quote.getOpen());
					});
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
		});

		
		
 
	 
		return "Ok";
	}
	
}
