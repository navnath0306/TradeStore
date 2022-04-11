package com.barclays.TradeStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.TradeStore.dao.Trade;
import com.barclays.TradeStore.domain.TradeStoreRequest;
import com.barclays.TradeStore.service.TradeService;

@RestController
public class TradeStoreController {
	@Autowired
	private TradeService tradeService;

	@PostMapping("/storetrade")
	public Trade storeTrade(@RequestBody TradeStoreRequest tradeStoreRequest) {
		return tradeService.storeTrade(tradeStoreRequest);
	}

}
