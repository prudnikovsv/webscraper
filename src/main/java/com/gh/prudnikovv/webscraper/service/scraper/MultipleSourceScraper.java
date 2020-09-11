package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.exception.WebScrapingException;
import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import com.gh.prudnikovv.webscraper.service.scraper.source.MultipleSource;
import com.gh.prudnikovv.webscraper.service.scraper.source.Source;

import java.util.stream.Collectors;

public class MultipleSourceScraper<I> implements Scraper<I> {

	private final Scraper<I> scraper;
	private final boolean isAsync;


	public MultipleSourceScraper(Scraper<I> scraper) {
		this(scraper, false);
	}

	public MultipleSourceScraper(Scraper<I> scraper, boolean isAsync) {
		this.scraper = scraper;
		this.isAsync = isAsync;
	}

	@Override
	public ScrapeResult scrape(Source<?> source) {
		if (!(source instanceof MultipleSource)) {
			throw new WebScrapingException(String.format("MultipleSourceScrapeAdapter do not support source type = %s",
				source.getClass()));
		}

		MultipleSource mSource = (MultipleSource) source;
		return ScrapeResult.of(mSource.getValue()
			.stream()
			.map(scraper::scrape)
			.map(ScrapeResult::getValue)
			.collect(Collectors.toList()));
	}

	@Override
	public Parser<I, ScrapeResult> getParser() {
		return scraper.getParser();
	}
}
