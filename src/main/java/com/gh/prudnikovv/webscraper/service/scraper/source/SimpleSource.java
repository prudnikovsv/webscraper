package com.gh.prudnikovv.webscraper.service.scraper.source;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class SimpleSource extends AbstractSource <String> {

	private final String source;


	public SimpleSource(SourceType type, String source) {
		super(type);
		this.source = source;
	}
}
