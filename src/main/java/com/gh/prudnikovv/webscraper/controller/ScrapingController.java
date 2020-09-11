package com.gh.prudnikovv.webscraper.controller;

import com.gh.prudnikovv.webscraper.service.scraper.HtmlScraper;
import com.gh.prudnikovv.webscraper.service.scraper.parser.specific.HtmlAirportParser;
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
	public Object scrapeTable() {
		return new HtmlScraper<>(new HtmlAirportParser(),
			SimpleSource.of(new LinkedList<>(AIRPORTS_TABLE_PAGES).getFirst())).scrape();
	}
}
