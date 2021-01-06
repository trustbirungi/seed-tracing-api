package io.trustbirungi.seedTracingApi.service;

import java.util.List;
import java.util.Map;

import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;

public interface TechUptakeService {
	List<SeedMultipliers> getSeedMultipliers();
	Map<String, Integer> getPlantingMaterialsFrequency();
	Map<String, Integer> getPlantingVarietiesFrequency();
	Map<String, Integer> getBananaVarietiesFrequency();
	Map<String, Integer> getPotatoVarietiesFrequency();
	Map<String, Integer> getPlantingTechFrequency();
	int getAverageBananaPlantingMaterialsProduced();
	int getMedianBananaPlantingMaterialsProduced();
	int getAveragePotatoPlantingMaterialsProduced();
	int getMedianPotatoPlantingMaterialsProduced();
	int getAverageNumberOfProductionTimes();
	int getMedianNumberOfProductionTimes();
	int getAverageIndividualBuyersQuantityPerSeason();
	int getMedianIndividualBuyersQuantityPerSeason();
	int getFemaleBuyersAverageAge();
	int getFemaleBuyersMedianAge();
	int getMaleBuyersAverageAge();
	int getMaleBuyersMedianAge();
	Map<String, Integer> getSellingPointsFrequency();
	int getAverageAnnualProductionCapacity();
	int getMedianAnnualProductionCapacity();
	int getAverageAnnualProductionSold();
	int getMedianAnnualProductionSold();
	int getAverageAnnualProductionGivenAway();
	int getMedianAnnualProductionGivenAway();
	int getAverageAnnualProductionLost();
	int getMedianAnnualProductionLost();
	int getAverageCurrentPlantingMaterialsStock();
	int getMedianCurrentPlantingMaterialsStock();
}
