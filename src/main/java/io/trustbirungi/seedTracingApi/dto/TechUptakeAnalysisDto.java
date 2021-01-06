package io.trustbirungi.seedTracingApi.dto;

import java.util.Map;

import lombok.Data;

@Data
public class TechUptakeAnalysisDto {
	Map<String, Integer> plantingMaterialsFrequency;
	Map<String, Integer> plantingVarietiesFrequency;
	Map<String, Integer> bananaVarietiesFrequency;
	Map<String, Integer> potatoVarietiesFrequency;
	Map<String, Integer> plantingTechFrequency;
	int averageBananaPlantingMaterialsProduced;
	int medianBananaPlantingMaterialsProduced;
	int averagePotatoPlantingMaterialsProduced;
	int medianPotatoPlantingMaterialsProduced;
	int averageNumberOfProductionTimes;
	int medianNumberOfProductionTimes;
	int averageIndividualBuyersQuantityPerSeason;
	int medianIndividualBuyersQuantityPerSeason;
	int femaleBuyersAverageAge;
	int femaleBuyersMedianAge;
	int maleBuyersAverageAge;
	int maleBuyersMedianAge;
	Map<String, Integer> sellingPointsFrequency;
	int averageAnnualProductionCapacity;
	int medianAnnualProductionCapacity;
	int averageAnnualProductionSold;
	int medianAnnualProductionSold;
	int averageAnnualProductionGivenAway;
	int medianAnnualProductionGivenAway;
	int averageAnnualProductionLost;
	int medianAnnualProductionLost;
	int averageCurrentPlantingMaterialsStock;
	int medianCurrentPlantingMaterialsStock;
}
