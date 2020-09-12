package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.exception.WebScrapingException;
import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import com.gh.prudnikovv.webscraper.service.scraper.source.MultipleSource;
import com.gh.prudnikovv.webscraper.service.scraper.source.Source;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class MultipleSourceScraper<I> implements Scraper<I> {

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

		// Consider to use custom thread pool!
		MultipleSource mSource = (MultipleSource) source;
		Stream<Object> objectStream = mSource.getValue()
			.stream()
			.map(scraper::scrape)
			.map(ScrapeResult::getData);

		if (isAsync) {
			objectStream = objectStream.parallel();
		}

		return ScrapeResult.of(objectStream.collect(Collectors.toList()));
	}

	@Override
	public Parser<I, ScrapeResult> getParser() {
		return scraper.getParser();
	}
}
