package io.trustbirungi.seedTracingApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SheetRange - An entity class that represents the sheet_range table in the
 * database.
 * This holds the sheet ranges used to determine resumption points when
 * fetching more data from the Google spreadsheets.
 */
@Entity
@Table(name = "sheet_range")
public class SheetRange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "previous_range")
	String previousRange;

	@Column(name = "current_range")
	String currentRange;
}
