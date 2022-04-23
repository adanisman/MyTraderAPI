package com.mytrader.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class StockInfo {
	@Id
	@GeneratedValue
	private long id;
	
	private String symbol;
	private String cname;
	public StockInfo(String symbol, String cname) {
		super();

		this.symbol = symbol;
		this.cname = cname;
	}

}
