package io.trustbirungi.seedTracingApi.entity;

import jakarta.persistence.*;

import lombok.Data;

/**
 * SheetRange - An entity class that represents the sheet_range table in the
 * database.
 * This holds the sheet ranges used to determine resumption points when
 * fetching more data from the Google spreadsheets.
 */
@Data
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
