package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import com.gh.prudnikovv.webscraper.service.scraper.source.Source;
import lombok.*;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class ScrapingConfig {

	@NonNull
	private final Source<?> source;

	@NonNull
	private final Class<? extends Parser> parser;

	private final boolean isAsyncScrape;
}
