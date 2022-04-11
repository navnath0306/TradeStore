package com.barclays.TradeStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.TradeStore.dao.Trade;

public interface TradeRepository extends JpaRepository<Trade, Integer>{
	List<Trade> findByTradeId(String tradeId);
}
