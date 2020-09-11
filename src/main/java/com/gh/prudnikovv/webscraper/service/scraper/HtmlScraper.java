package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.exception.WebScrapingException;
import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import com.gh.prudnikovv.webscraper.service.scraper.source.SimpleSource;
import com.gh.prudnikovv.webscraper.service.scraper.source.Source;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HtmlScraper extends AbstractScraper<Document> {

	public HtmlScraper(Parser<Document, ScrapeResult> parser) {
		super(parser);
	}

	@Override
	public ScrapeResult scrape(Source<?> source) {
		if (!(source instanceof SimpleSource)) {
			throw new WebScrapingException(String.format("Html scraper do not support source type = %s",
				source.getClass()));
		}

		SimpleSource sSource = (SimpleSource) source;
		return getParser().parse(silentDocumentRequest(sSource.getValue()));
	}

	private Document silentDocumentRequest(String url) {
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new WebScrapingException(String.format("Failed to fetch document from %s", url), e);
		}
	}
}