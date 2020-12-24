package io.trustbirungi.seedTracingApi.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class BuyersAnalysisDto {
	double maleBuyersPercent;
	double femaleBuyersPercent;
	int maleBuyersAverageAge;
	int femaleBuyersAverageAge;
	int maleBuyersMedianAge;
	int femaleBuyersMedianAge;
	Map<String, Integer> ageCohorts;
	Map<String, Integer> buyersDistricts;
}
