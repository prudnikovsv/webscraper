package com.gh.prudnikovv.webscraper.service.scraper.parser.specific;

import com.gh.prudnikovv.webscraper.service.scraper.parser.HtmlParser;
import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class HtmlAirportParser extends HtmlParser<String> {

	@Override
	public String parse(Document input) {
		return input.title();
	}
}
