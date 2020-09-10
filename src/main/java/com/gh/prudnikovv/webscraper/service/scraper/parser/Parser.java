package com.gh.prudnikovv.webscraper.service.scraper.parser;

public interface Parser<O, I> {

	O parse(I input);
}
