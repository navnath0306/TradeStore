package com.barclays.TradeStore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barclays.TradeStore.dao.Trade;
import com.barclays.TradeStore.domain.TradeStoreRequest;

@Service
public interface TradeService {
	
	public List<Trade> findByTradeId(String trade_id);
	public Trade storeTrade(TradeStoreRequest tradeStoreRequest);

}
