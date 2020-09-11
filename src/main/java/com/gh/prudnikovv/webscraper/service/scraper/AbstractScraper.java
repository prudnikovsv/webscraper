package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import lombok.Getter;

@Getter
abstract class AbstractScraper<I> implements Scraper<I> {

	private final Parser<I, ScrapeResult> parser;


	public AbstractScraper(Parser<I, ScrapeResult> parser) {
		this.parser = parser;
	}
}
