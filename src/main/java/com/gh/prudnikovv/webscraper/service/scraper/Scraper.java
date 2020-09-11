package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import com.gh.prudnikovv.webscraper.service.scraper.source.Source;

public interface Scraper<I, O> {

	O scrape();

	Parser<I, O> getParser();

	Source<?> getSource();
}
