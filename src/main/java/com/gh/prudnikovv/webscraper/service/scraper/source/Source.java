package com.gh.prudnikovv.webscraper.service.scraper.source;

public interface Source <T> {

	SourceType getType();
	T getSource();
}
