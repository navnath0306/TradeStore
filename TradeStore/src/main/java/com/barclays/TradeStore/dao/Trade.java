package com.barclays.TradeStore.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "Trade.findByTradeId", query = "SELECT * FROM trade WHERE TRADE_ID = ?", resultClass = Trade.class)
public class Trade {

	@Id
	@GeneratedValue
	private int id;

	private String tradeId;
	private int version;
	private String counter_part_Id;
	private String book_id;
	private Date maturity_date;
	private Date created_date;
	private boolean expired;

	public Trade() {
		
	}
	public Trade(String tradeId, int version, String counter_part_Id, String book_id, Date maturity_date,
			Date created_date, boolean expired) {
		this.tradeId = tradeId;
		this.version = version;
		this.counter_part_Id = counter_part_Id;
		this.book_id = book_id;
		this.maturity_date = maturity_date;
		this.created_date = created_date;
		this.expired = expired;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCounter_part_Id() {
		return counter_part_Id;
	}

	public void setCounter_part_Id(String counter_part_Id) {
		this.counter_part_Id = counter_part_Id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public Date getMaturity_date() {
		return maturity_date;
	}

	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

}
