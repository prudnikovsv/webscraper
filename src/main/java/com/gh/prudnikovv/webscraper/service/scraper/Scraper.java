package com.gh.prudnikovv.webscraper.service.scraper;

public interface Scraper {

	<T> T scrape(ScrapingConfig scrapingConfig);
}
