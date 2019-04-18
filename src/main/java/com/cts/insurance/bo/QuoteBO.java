package com.cts.insurance.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cts.insurance.dao.LocationDAO;
import com.cts.insurance.dao.QuoteDAO;
import com.cts.insurance.model.Quote;

public class QuoteBO {
	QuoteDAO qd;

	public QuoteBO() {
		qd = new QuoteDAO();
		
	}
	public Integer createQuote(Quote quote) throws SQLException, ClassNotFoundException, IOException {
	
		Integer qId = qd.createQuote(quote);

		return qId;

	}

	public Quote getQuoteByQuoteId(int quoteId) throws ClassNotFoundException, IOException, SQLException {
		Quote q = new Quote();
		QuoteDAO qd = new QuoteDAO();
		q = qd.getQuoteByQuoteId(quoteId);

		return q;
	}

	public List<Quote> getQuoteByUserId(int userId) throws ClassNotFoundException, IOException, SQLException {
		QuoteDAO qd = new QuoteDAO();
		List<Quote> quoteList;
		quoteList = qd.getQuoteByUserId(userId);

		return quoteList;

	}
}
