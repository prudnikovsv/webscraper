package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.exception.WebScrapingException;
import com.gh.prudnikovv.webscraper.service.scraper.parser.HtmlParser;
import com.gh.prudnikovv.webscraper.service.scraper.source.SimpleSource;
import com.gh.prudnikovv.webscraper.service.scraper.source.Source;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HtmlScraper<O> extends AbstractScraper<Document, O> {

	public HtmlScraper(HtmlParser<O> parser, Source<?> source) {
		super(parser, source);
	}

	@Override
	public O scrape() {
		if (!(getSource() instanceof SimpleSource)) {
			throw new WebScrapingException(String.format("Html scraper do not support source type = %s",
				getSource().getClass()));
		}

		SimpleSource source = (SimpleSource) getSource();
		return getParser().parse(silentDocumentRequest(source.getValue()));
	}

	private Document silentDocumentRequest(String url) {
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new WebScrapingException(String.format("Failed to fetch document from %s", url), e);
		}
	}
}