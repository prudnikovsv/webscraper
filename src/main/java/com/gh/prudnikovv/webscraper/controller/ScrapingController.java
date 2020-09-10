package com.gh.prudnikovv.webscraper.controller;

import com.gh.prudnikovv.webscraper.service.scraper.Scraper;
import com.gh.prudnikovv.webscraper.service.scraper.ScrapingConfig;
import com.gh.prudnikovv.webscraper.service.scraper.parser.HtmlAirportParser;
import com.gh.prudnikovv.webscraper.service.scraper.source.MultipleSource;
import com.gh.prudnikovv.webscraper.service.scraper.source.SimpleSource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static com.gh.prudnikovv.webscraper.common.Urls.AIRPORTS_TABLE_PAGES;
import static com.gh.prudnikovv.webscraper.service.scraper.source.SourceType.HTML;

@RestController
@RequestMapping("/scrape")
@RequiredArgsConstructor
public class ScrapingController {

	private final Scraper scraper;


	@GetMapping("/airports")
	public Object scrapeTable() {
		return scraper.scrape(ScrapingConfig.builder()
			.parser(HtmlAirportParser.class)
			.source(new MultipleSource(HTML, AIRPORTS_TABLE_PAGES.stream()
				.map(s -> new SimpleSource(HTML, s))
				.collect(Collectors.toUnmodifiableList())
			))
			.build());
	}
}
