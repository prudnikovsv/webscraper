package com.gh.prudnikovv.webscraper.service.scraper.source;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor(staticName = "of")
public class SimpleSource extends AbstractSource<String> {

	private final String value;
}
