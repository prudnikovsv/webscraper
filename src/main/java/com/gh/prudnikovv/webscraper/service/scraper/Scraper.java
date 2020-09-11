package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import com.gh.prudnikovv.webscraper.service.scraper.source.Source;

public interface Scraper<I> {

	ScrapeResult scrape(Source<?> source);

	Parser<I, ScrapeResult> getParser();
}
