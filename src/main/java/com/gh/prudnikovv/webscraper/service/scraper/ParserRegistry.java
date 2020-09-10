package com.gh.prudnikovv.webscraper.service.scraper;

import com.gh.prudnikovv.webscraper.service.scraper.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Component
@SuppressWarnings("unchecked")
public final class ParserRegistry {

	private final Map<Class<? extends Parser>, ? extends Parser> registry;


	@Autowired
	public ParserRegistry(Collection<Parser> parsers) {
		registry = parsers.stream()
			.collect(toMap(Parser::getClass, identity()));
	}

	public Parser findParser(Class<? extends Parser> parserType) {
		return Optional.ofNullable(registry.get(parserType))
			.orElseThrow(() -> new RuntimeException(String.format(
				"Parsert with type =  %s, was not found.", parserType)));
	}
}
