package io.trustbirungi.seedTracingApi.dto;

import java.util.Map;

import lombok.Data;

@Data
public class SeedMultipliersAnalysisDto {
	double malePercent;
	double femalePercent;
	int maleAverageAge;
	int femaleAverageAge;
	int maleMedianAge;
	int femaleMedianAge;
	Map<String, Integer> maleAgeCohorts;
	Map<String, Integer> femaleAgeCohorts;
	double individualMultipliersPercent;
	double groupMultipliersPercent;
	int averageGroupSize;
	int medianGroupSize;
	int averageFemaleMembersPerGroup;
	int averageMaleMembersPerGroup;
	Map<String, Integer> multipliersDistricts;
	Map<String, Integer> plantingMaterialsFrequency;
	Map<String, Integer> plantingMaterialsVarietiesFrequency;
	Map<String, Integer> bananaPlantingVarietiesFrequency;
	Map<String, Integer> potatoPlantingVarietiesFrequency;
	Map<String, Integer> plantingMethodsFrequency;
}
