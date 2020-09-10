package com.gh.prudnikovv.webscraper.service.scraper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class HtmlScraper implements Scraper {


	@Override
	public String scrape(ScrapingConfig scrapingConfig) {

		// Get url
		// Get html resposne
		// Parse HTML
		// Find elements
		// Parse

		return "Hello world";
	}
}
