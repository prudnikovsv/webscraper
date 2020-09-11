package com.gh.prudnikovv.webscraper.controller;

import com.gh.prudnikovv.webscraper.service.scraper.HtmlScraper;
import com.gh.prudnikovv.webscraper.service.scraper.MultipleSourceScraper;
import com.gh.prudnikovv.webscraper.service.scraper.ScrapeResult;
import com.gh.prudnikovv.webscraper.service.scraper.parser.specific.HtmlAirportParser;
import com.gh.prudnikovv.webscraper.service.scraper.source.MultipleSource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gh.prudnikovv.webscraper.common.Urls.AIRPORTS_TABLE_PAGES;

@RestController
@RequestMapping("/scrape")
@RequiredArgsConstructor
public class ScrapingController {

	@GetMapping("/airports")
	public ScrapeResult scrapeTable() {
		return new MultipleSourceScraper<>(new HtmlScraper(new HtmlAirportParser()), true)
			.scrape(MultipleSource.of(AIRPORTS_TABLE_PAGES));
	}
}
