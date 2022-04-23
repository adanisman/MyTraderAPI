package com.mytrader;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@SpringBootApplication
@ComponentScan("com.mytrader")
public class MyTraderApiApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(MyTraderApiApplication.class, args);
		System.out.println("started...");
		

		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.YEAR, -1); // from 1 year ago
/*
		Stock google = YahooFinance.get("TSLA");
		List<HistoricalQuote> googleHistQuotes = google.getHistory(from, to, Interval.DAILY);
 
	      for(int i = 0 ; i < googleHistQuotes.size() ; i++){
	    	  HistoricalQuote quote = (HistoricalQuote) googleHistQuotes.get(i);
	    	  System.out.println("Date:"+ quote.getDate()+" Open:" + quote.getOpen());
	    	 }
	     
	      
	   String[] symbols = new String[] {"INTC", "BABA", "TSLA", "MSFT", "PYPL"};
	   Map<String, Stock> stocks = YahooFinance.get(symbols,from, to, Interval.DAILY );

	   Stock TSLA = stocks.get("TSLA");
	   List<HistoricalQuote> googleHistQuotes = TSLA.getHistory(from, to, Interval.DAILY);
	   
	      for(int i = 0 ; i < googleHistQuotes.size() ; i++){
	    	  HistoricalQuote quote = (HistoricalQuote) googleHistQuotes.get(i);
	    	  System.out.println("Date:"+ quote.getDate()+" Open:" + quote.getOpen());
	    	 }
	  */  
	}
	
	

}
