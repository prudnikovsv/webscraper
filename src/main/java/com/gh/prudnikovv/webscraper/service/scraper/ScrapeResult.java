package com.gh.prudnikovv.webscraper.service.scraper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class ScrapeResult {

	private final Object value;
}
