package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.source.MultipleSource;
import com.gh.prudnikovv.webscraper.service.scraper.source.SimpleSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class HtmlScraper implements Scraper {

	private final ParserRegistry parserRegistry;


	// TODO Use separate class for single and multiple sources
	// TODO Deal with types
	@Override
	public Collection scrape(ScrapingConfig scrapingConfig) {
		MultipleSource source = (MultipleSource) scrapingConfig.getSource();

		return source.getSource()
			.stream()
			.map(SimpleSource::getSource)
			.map(this::silentDocumentRequest)
			.map(doc -> parserRegistry.findParser(scrapingConfig.getParser())
				.parse(doc))
			.collect(Collectors.toList());
	}

	private Document silentDocumentRequest(String url) {
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new RuntimeException(String.format("Failed to fetch document from %s", url), e);
		}
	}
}
