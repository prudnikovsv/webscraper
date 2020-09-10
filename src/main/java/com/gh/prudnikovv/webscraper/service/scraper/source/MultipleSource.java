package com.gh.prudnikovv.webscraper.service.scraper.source;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;

// TODO Resolve HTML NESTED ISSUE!
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class MultipleSource extends AbstractSource<Collection<? extends SimpleSource>> {

	private final Collection<? extends SimpleSource> source;


	public MultipleSource(SourceType type, Collection<? extends SimpleSource> source) {
		super(type);
		this.source = source;
	}
}
