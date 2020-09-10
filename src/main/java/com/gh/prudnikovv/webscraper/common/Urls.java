package com.gh.prudnikovv.webscraper.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class Urls {

	private static final String AIRPORTS_TABLE = "https://en.wikipedia.org/wiki/List_of_airports_by_IATA_airport_code:_";

	public static final Collection<String> AIRPORTS_TABLE_PAGES = List.of(
		AIRPORTS_TABLE + "A",
		AIRPORTS_TABLE + "B",
		AIRPORTS_TABLE + "C",
		AIRPORTS_TABLE + "D",
		AIRPORTS_TABLE + "E",
		AIRPORTS_TABLE + "F",
		AIRPORTS_TABLE + "G",
		AIRPORTS_TABLE + "H",
		AIRPORTS_TABLE + "I",
		AIRPORTS_TABLE + "J",
		AIRPORTS_TABLE + "K",
		AIRPORTS_TABLE + "L",
		AIRPORTS_TABLE + "M",
		AIRPORTS_TABLE + "N",
		AIRPORTS_TABLE + "O",
		AIRPORTS_TABLE + "P",
		AIRPORTS_TABLE + "Q",
		AIRPORTS_TABLE + "R",
		AIRPORTS_TABLE + "S",
		AIRPORTS_TABLE + "T",
		AIRPORTS_TABLE + "U",
		AIRPORTS_TABLE + "V",
		AIRPORTS_TABLE + "W",
		AIRPORTS_TABLE + "X",
		AIRPORTS_TABLE + "Y",
		AIRPORTS_TABLE + "Z");
}