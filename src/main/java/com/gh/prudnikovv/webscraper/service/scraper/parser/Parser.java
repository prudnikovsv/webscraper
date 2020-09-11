package com.gh.prudnikovv.webscraper.service.scraper.parser;

public interface Parser<I, O> {

	O parse(I input);
}
