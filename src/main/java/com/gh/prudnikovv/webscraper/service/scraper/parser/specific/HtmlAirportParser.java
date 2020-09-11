package com.gh.prudnikovv.webscraper.service.scraper.parser.specific;

import com.gh.prudnikovv.webscraper.service.scraper.ScrapeResult;
import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class HtmlAirportParser implements Parser<Document, ScrapeResult> {

	@Override
	public ScrapeResult parse(Document input) {
		return ScrapeResult.of(input.title());
	}
}
