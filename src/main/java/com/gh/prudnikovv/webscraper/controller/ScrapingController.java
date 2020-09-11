package com.gh.prudnikovv.webscraper.controller;

import com.gh.prudnikovv.webscraper.service.scraper.HtmlScraper;
import com.gh.prudnikovv.webscraper.service.scraper.MultipleSourceScraper;
import com.gh.prudnikovv.webscraper.service.scraper.ScrapeResult;
import com.gh.prudnikovv.webscraper.service.scraper.parser.specific.HtmlAirportParser;
import com.gh.prudnikovv.webscraper.service.scraper.source.MultipleSource;
import com.gh.prudnikovv.webscraper.service.scraper.source.SimpleSource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

import static com.gh.prudnikovv.webscraper.common.Urls.AIRPORTS_TABLE_PAGES;

@RestController
@RequestMapping("/scrape")
@RequiredArgsConstructor
public class ScrapingController {

	@GetMapping("/airports")
	public ScrapeResult scrapeTable() {
		return new MultipleSourceScraper<>(new HtmlScraper(new HtmlAirportParser()))
			.scrape(gitMultiple());
	}

	@GetMapping("/airport")
	public ScrapeResult scrapeTable2() {
		return new HtmlScraper(new HtmlAirportParser()).scrape(gitSimple());
	}

	private SimpleSource gitSimple() {
		return SimpleSource.of(new LinkedList<>(AIRPORTS_TABLE_PAGES).getFirst());
	}

	private MultipleSource gitMultiple() {
		return MultipleSource.of(AIRPORTS_TABLE_PAGES);
	}
}
