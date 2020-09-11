package com.gh.prudnikovv.webscraper.service.scraper.source;

import lombok.*;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@ToString
@EqualsAndHashCode(callSuper = true)
public class MultipleSource extends AbstractSource<Set<SimpleSource>> {

	private final Set<SimpleSource> sources;


	private MultipleSource(Collection<String> sources) {
		this.sources = sources.stream()
			.map(SimpleSource::of)
			.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleSource> getValue() {
		return sources;
	}

	public static MultipleSource of(Collection<String> sources) {
		return new MultipleSource(sources);
	}
}
