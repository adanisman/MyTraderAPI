package com.mytrader.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class StockSignals {

    @Id
    @GeneratedValue
    private int id;
	private String date;
	private String stock;
	private String company;
	private String signal;
	private String type;
	private String link;
	private String source;
	private String period;
	
	public StockSignals(String date, String stock, String company, String signal, String type, String link,
			String source, String period) {
		super();
		this.date = date;
		this.stock = stock;
		this.company = company;
		this.signal = signal;
		this.type = type;
		this.link = link;
		this.source = source;
		this.period = period;
	}


}

 
 