package com.barclays.TradeStore.domain;

public class TradeStoreRequest {
	private String tradeId;
	private int version;
	private String counter_part_Id;
	private String book_id;
	private String maturity_date;
	private boolean expired;

	public TradeStoreRequest(String tradeId, int version, String counter_part_Id, String book_id, String maturity_date,
			boolean expired) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counter_part_Id = counter_part_Id;
		this.book_id = book_id;
		this.maturity_date = maturity_date;
		this.expired = expired;
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

	public String getMaturity_date() {
		return maturity_date;
	}

	public void setMaturity_date(String maturity_date) {
		this.maturity_date = maturity_date;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

}
