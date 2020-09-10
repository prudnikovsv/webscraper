package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.exception.ScraperResolveException;
import com.gh.prudnikovv.webscraper.service.scraper.source.SourceType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
@RequiredArgsConstructor
public final class ScraperResolver implements Scraper {

	@Qualifier("HtmlScraper")
	private final Scraper htmlScraper;


	@Override
	public <T> T scrape(ScrapingConfig scrapingConfig) {
		return resolve(scrapingConfig).scrape(scrapingConfig);
	}

	private Scraper resolve(ScrapingConfig config) {
		if (!SourceType.HTML.equals(config.getSource().getType())) {
			throw new ScraperResolveException(String.format("%s scraping type is not supported.",
				config.getSource().getType()));
		}

		return htmlScraper;
	}
}
