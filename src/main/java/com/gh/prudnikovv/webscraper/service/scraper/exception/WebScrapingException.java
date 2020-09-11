package com.gh.prudnikovv.webscraper.service.scraper.exception;

public final class WebScrapingException extends RuntimeException {

	public WebScrapingException(String message) {
		super(message);
	}

	public WebScrapingException(String message, Throwable cause) {
		super(message, cause);
	}
}
