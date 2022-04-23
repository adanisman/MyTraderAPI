package com.mytrader.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mytrader.model.StockInfo;
import com.mytrader.service.StockInfoService;
import com.mytrader.shared.GenericResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StockController {

	private static final Logger log = LoggerFactory.getLogger(StockController.class);

	@Autowired
	StockInfoService stockInfoService;

	@RequestMapping("/api/data")
	public ArrayList<String> getData() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("A");
		l.add("C");
		return l;
	}

	@CrossOrigin
	@PostMapping("/api/ticker/create")
//	@ResponseStatus(HttpStatus.CREATED)
	public GenericResponse createStock(@RequestBody StockInfo stock) {
		log.info(stock.toString());
		stockInfoService.save(stock);
		return new GenericResponse("user created");

	}

	@RequestMapping(value = "/api/ticker/getFile", method = RequestMethod.POST)
	@ResponseBody
	public void getTickerFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
		String contentType = file.getContentType();
		String fileName = file.getOriginalFilename();
		log.info(fileName, contentType);

		BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
		CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
		
		

		Iterable<CSVRecord> csvRecords = csvParser.getRecords();
		/*
		for (CSVRecord csvRecord : csvRecords) {
			 System.out.println(csvRecord);
			 String symbol = csvRecord.get(0);
			 String cname = csvRecord.get(1);
			 StockInfo stockInfo = new StockInfo(symbol, cname);
			 //stockInfoService.save(stockInfo);
			 //log.info(cname);
		}
		
	*/	List<StockInfo> stockInfoList = new ArrayList<>();
		
		for (CSVRecord csvRecord : csvRecords) {
			
			 String symbol = csvRecord.get(0);
			 String cname = csvRecord.get(1);
			 stockInfoList.add(new StockInfo(symbol, cname));
			 //stockInfoService.save(stockInfo);
			 //log.info(cname);
		}

		stockInfoService.saveAll(stockInfoList);
		
			
		log.info("read is done");
	}
}
