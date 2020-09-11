package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import com.gh.prudnikovv.webscraper.service.scraper.source.Source;
import lombok.Getter;

@Getter
abstract class AbstractScraper<I, O> implements Scraper<I, O> {

	private final Parser<I, O> parser;
	private final Source<?> source;


	public AbstractScraper(Parser<I, O> parser, Source<?> source) {
		this.parser = parser;
		this.source = source;
	}
}
