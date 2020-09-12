package com.gh.prudnikovv.webscraper.service.scraper.parser.specific;

import com.gh.prudnikovv.webscraper.service.scraper.ScrapeResult;
import com.gh.prudnikovv.webscraper.service.scraper.exception.WebScrapingException;
import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

@Log4j2
@Service
public class HtmlAirportParser implements Parser<Document, ScrapeResult> {

	private static final int IATA_ID = 0;
	private static final int NAME_ID = 2;
	private static final int LOCATION_ID = 3;

	private static final String TD = "td";
	private static final String SUP = "sup";
	private static final String TABLE_SELECTOR = "table.wikitable tbody tr:not(.sortbottom)";


	@Override
	public ScrapeResult parse(Document document) {
		return ScrapeResult.of(document.select(TABLE_SELECTOR)
			.stream()
			.skip(1) // Skip head of table
			.map(this::mapChildElements)
			.filter(Objects::nonNull)
			.collect(toList()));
	}

	private AirportDto mapChildElements(Element element) {
		Elements childColumns = element.getElementsByTag(TD);
		return AirportDto.builder()
			.iata(childColumns.get(IATA_ID).text())
			.name(extractElementText(childColumns.get(NAME_ID)))
			.location(childColumns.get(LOCATION_ID).text())
			.build();
	}

	private String extractElementText(Element element) {
		return element.childNodes()
			.stream()
			.filter(e -> !SUP.equalsIgnoreCase(e.nodeName()))
			.map(this::getWholeText)
			.collect(joining());
	}

	private String getWholeText(Node node) {
		if (node instanceof TextNode) {
			return ((TextNode) node).getWholeText();
		} else if (node instanceof Element) {
			return ((Element) node).wholeText();
		} else {
			throw new WebScrapingException("Unsupported node type for text extraction" + node.toString());
		}
	}

	@Builder
	@Getter
	private static final class AirportDto {

		private final String iata;
		private final String name;
		private final String location;
	}
}
