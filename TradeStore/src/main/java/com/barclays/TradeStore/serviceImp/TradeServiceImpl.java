package com.barclays.TradeStore.serviceImp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.TradeStore.dao.Trade;
import com.barclays.TradeStore.domain.TradeStoreRequest;
import com.barclays.TradeStore.repository.TradeRepository;
import com.barclays.TradeStore.service.TradeService;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository repository;

	@Override
	public Trade storeTrade(TradeStoreRequest tradeStoreRequest) {
		Trade responseTrade = null;
		String str_date = tradeStoreRequest.getMaturity_date();
		DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		Date date = null;
		try {
			date = formatter.parse(str_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Trade> existing_trade = findByTradeId(tradeStoreRequest.getTradeId());
		int version = 0;
		if (!existing_trade.isEmpty()) {
			version = existing_trade.stream().map(Trade::getVersion).max(Comparator.naturalOrder()).get();
		}
		if (version > tradeStoreRequest.getVersion()) {
			System.out.println("Trade Rejected, lower verion of the trade in not allowed");
			return null;
		}
		if ((Date.from(Instant.now()).compareTo(date) != 1)) {
			Trade trade = new Trade(tradeStoreRequest.getTradeId(), tradeStoreRequest.getVersion(),
					tradeStoreRequest.getCounter_part_Id(), tradeStoreRequest.getBook_id(), date,
					Date.from(Instant.now()), tradeStoreRequest.isExpired());

			responseTrade = repository.save(trade);
		} else {
			System.out.println("Maturity date should be greater than todays date");
			return null;
		}
		return responseTrade;

	}

	@Override
	public List<Trade> findByTradeId(String trade_id) {
		return repository.findByTradeId(trade_id);
	}

}
