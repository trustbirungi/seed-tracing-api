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

	public void setPlantingMaterialsFrequency(Map<String, Integer> plantingMaterialsFrequency) {
		this.plantingMaterialsFrequency = plantingMaterialsFrequency;
	}

	public void setPlantingVarietiesFrequency(Map<String, Integer> plantingVarietiesFrequency) {
		this.plantingVarietiesFrequency = plantingVarietiesFrequency;
	}

	public void setBananaVarietiesFrequency(Map<String, Integer> bananaVarietiesFrequency) {
		this.bananaVarietiesFrequency = bananaVarietiesFrequency;
	}

	public void setPotatoVarietiesFrequency(Map<String, Integer> potatoVarietiesFrequency) {
		this.potatoVarietiesFrequency = potatoVarietiesFrequency;
	}

	public void setPlantingTechFrequency(Map<String, Integer> plantingTechFrequency) {
		this.plantingTechFrequency = plantingTechFrequency;
	}

	public void setAverageBananaPlantingMaterialsProduced(int averageBananaPlantingMaterialsProduced) {
		this.averageBananaPlantingMaterialsProduced = averageBananaPlantingMaterialsProduced;
	}

	public void setMedianBananaPlantingMaterialsProduced(int medianBananaPlantingMaterialsProduced) {
		this.medianBananaPlantingMaterialsProduced = medianBananaPlantingMaterialsProduced;
	}

	public void setAveragePotatoPlantingMaterialsProduced(int averagePotatoPlantingMaterialsProduced) {
		this.averagePotatoPlantingMaterialsProduced = averagePotatoPlantingMaterialsProduced;
	}

	public void setMedianPotatoPlantingMaterialsProduced(int medianPotatoPlantingMaterialsProduced) {
		this.medianPotatoPlantingMaterialsProduced = medianPotatoPlantingMaterialsProduced;
	}

	public void setAverageNumberOfProductionTimes(int averageNumberOfProductionTimes) {
		this.averageNumberOfProductionTimes = averageNumberOfProductionTimes;
	}

	public void setMedianNumberOfProductionTimes(int medianNumberOfProductionTimes) {
		this.medianNumberOfProductionTimes = medianNumberOfProductionTimes;
	}

	public void setAverageIndividualBuyersQuantityPerSeason(int averageIndividualBuyersQuantityPerSeason) {
		this.averageIndividualBuyersQuantityPerSeason = averageIndividualBuyersQuantityPerSeason;
	}

	public void setMedianIndividualBuyersQuantityPerSeason(int medianIndividualBuyersQuantityPerSeason) {
		this.medianIndividualBuyersQuantityPerSeason = medianIndividualBuyersQuantityPerSeason;
	}

	public void setFemaleBuyersAverageAge(int femaleBuyersAverageAge) {
		this.femaleBuyersAverageAge = femaleBuyersAverageAge;
	}

	public void setFemaleBuyersMedianAge(int femaleBuyersMedianAge) {
		this.femaleBuyersMedianAge = femaleBuyersMedianAge;
	}

	public void setMaleBuyersAverageAge(int maleBuyersAverageAge) {
		this.maleBuyersAverageAge = maleBuyersAverageAge;
	}

	public void setMaleBuyersMedianAge(int maleBuyersMedianAge) {
		this.maleBuyersMedianAge = maleBuyersMedianAge;
	}

	public void setSellingPointsFrequency(Map<String, Integer> sellingPointsFrequency) {
		this.sellingPointsFrequency = sellingPointsFrequency;
	}

	public void setAverageAnnualProductionCapacity(int averageAnnualProductionCapacity) {
		this.averageAnnualProductionCapacity = averageAnnualProductionCapacity;
	}

	public void setMedianAnnualProductionCapacity(int medianAnnualProductionCapacity) {
		this.medianAnnualProductionCapacity = medianAnnualProductionCapacity;
	}

	public void setAverageAnnualProductionSold(int averageAnnualProductionSold) {
		this.averageAnnualProductionSold = averageAnnualProductionSold;
	}

	public void setMedianAnnualProductionSold(int medianAnnualProductionSold) {
		this.medianAnnualProductionSold = medianAnnualProductionSold;
	}

	public void setAverageAnnualProductionGivenAway(int averageAnnualProductionGivenAway) {
		this.averageAnnualProductionGivenAway = averageAnnualProductionGivenAway;
	}

	public void setMedianAnnualProductionGivenAway(int medianAnnualProductionGivenAway) {
		this.medianAnnualProductionGivenAway = medianAnnualProductionGivenAway;
	}

	public void setAverageAnnualProductionLost(int averageAnnualProductionLost) {
		this.averageAnnualProductionLost = averageAnnualProductionLost;
	}

	public void setMedianAnnualProductionLost(int medianAnnualProductionLost) {
		this.medianAnnualProductionLost = medianAnnualProductionLost;
	}

	public void setAverageCurrentPlantingMaterialsStock(int averageCurrentPlantingMaterialsStock) {
		this.averageCurrentPlantingMaterialsStock = averageCurrentPlantingMaterialsStock;
	}

	public void setMedianCurrentPlantingMaterialsStock(int medianCurrentPlantingMaterialsStock) {
		this.medianCurrentPlantingMaterialsStock = medianCurrentPlantingMaterialsStock;
	}

	public Map<String, Integer> getPlantingMaterialsFrequency() {
		return plantingMaterialsFrequency;
	}

	public Map<String, Integer> getPlantingVarietiesFrequency() {
		return plantingVarietiesFrequency;
	}

	public Map<String, Integer> getBananaVarietiesFrequency() {
		return bananaVarietiesFrequency;
	}

	public Map<String, Integer> getPotatoVarietiesFrequency() {
		return potatoVarietiesFrequency;
	}

	public Map<String, Integer> getPlantingTechFrequency() {
		return plantingTechFrequency;
	}

	public int getAverageBananaPlantingMaterialsProduced() {
		return averageBananaPlantingMaterialsProduced;
	}

	public int getMedianBananaPlantingMaterialsProduced() {
		return medianBananaPlantingMaterialsProduced;
	}

	public int getAveragePotatoPlantingMaterialsProduced() {
		return averagePotatoPlantingMaterialsProduced;
	}

	public int getMedianPotatoPlantingMaterialsProduced() {
		return medianPotatoPlantingMaterialsProduced;
	}

	public int getAverageNumberOfProductionTimes() {
		return averageNumberOfProductionTimes;
	}

	public int getMedianNumberOfProductionTimes() {
		return medianNumberOfProductionTimes;
	}

	public int getAverageIndividualBuyersQuantityPerSeason() {
		return averageIndividualBuyersQuantityPerSeason;
	}

	public int getMedianIndividualBuyersQuantityPerSeason() {
		return medianIndividualBuyersQuantityPerSeason;
	}

	public int getFemaleBuyersAverageAge() {
		return femaleBuyersAverageAge;
	}

	public int getFemaleBuyersMedianAge() {
		return femaleBuyersMedianAge;
	}

	public int getMaleBuyersAverageAge() {
		return maleBuyersAverageAge;
	}

	public int getMaleBuyersMedianAge() {
		return maleBuyersMedianAge;
	}

	public Map<String, Integer> getSellingPointsFrequency() {
		return sellingPointsFrequency;
	}

	public int getAverageAnnualProductionCapacity() {
		return averageAnnualProductionCapacity;
	}

	public int getMedianAnnualProductionCapacity() {
		return medianAnnualProductionCapacity;
	}

	public int getAverageAnnualProductionSold() {
		return averageAnnualProductionSold;
	}

	public int getMedianAnnualProductionSold() {
		return medianAnnualProductionSold;
	}

	public int getAverageAnnualProductionGivenAway() {
		return averageAnnualProductionGivenAway;
	}

	public int getMedianAnnualProductionGivenAway() {
		return medianAnnualProductionGivenAway;
	}

	public int getAverageAnnualProductionLost() {
		return averageAnnualProductionLost;
	}

	public int getMedianAnnualProductionLost() {
		return medianAnnualProductionLost;
	}

	public int getAverageCurrentPlantingMaterialsStock() {
		return averageCurrentPlantingMaterialsStock;
	}

	public int getMedianCurrentPlantingMaterialsStock() {
		return medianCurrentPlantingMaterialsStock;
	}
}
