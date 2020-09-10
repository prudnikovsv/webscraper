package com.gh.prudnikovv.webscraper.service.scraper.parser;

import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class HtmlAirportParser implements Parser <String, Document> {

	@Override
	public String parse(Document input) {
		return input.title();
	}
}
