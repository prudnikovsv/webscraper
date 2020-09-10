package com.gh.prudnikovv.webscraper.service.scraper.source;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
abstract class AbstractSource<T> implements Source<T> {

	private final SourceType type;
}
