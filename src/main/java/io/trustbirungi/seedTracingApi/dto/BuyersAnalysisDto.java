package io.trustbirungi.seedTracingApi.dto;

import java.util.List;

import lombok.Data;

@Data
public class BuyersAnalysisDto {
	double maleBuyersPercent;
	double femaleBuyersPercent;
	double maleBuyersAverageAge;
	double femaleBuyersAverageAge;
	double maleBuyersMedianAge;
	double femaleBuyersMedianAge;
	List<List<Integer>> ageCohorts;
	List<String> locationCoordinates;
	double boughtPlantingMaterialsAverageQuantity;
	double boughtPlantingMaterialsMedianQuantity;
	double survivedPlantingMaterialsAverageQuantity;
	double survivedPlantingMaterialsMedianQuantity;
	double damagedPlantingMaterialsAverageQuantity;
	double damagedPlantingMaterialsMedianQuantity;
}
