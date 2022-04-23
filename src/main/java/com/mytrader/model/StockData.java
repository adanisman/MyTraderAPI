package com.mytrader.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class StockData {
	@Id
	@GeneratedValue
	private long id;
	private String symbol;
	private Timestamp date;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
	private BigDecimal volume;
	
	public StockData(String symbol, Timestamp date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close,
			BigDecimal volume) {
		super();
		this.symbol = symbol;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}
	

	
}
