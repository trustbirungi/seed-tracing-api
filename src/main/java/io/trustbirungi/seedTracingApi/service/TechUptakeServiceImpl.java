package io.trustbirungi.seedTracingApi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import io.trustbirungi.seedTracingApi.repository.TechUptakeRepository;
import org.springframework.stereotype.Service;

@Service
public class TechUptakeServiceImpl implements TechUptakeService {
	TechUptakeRepository techUptakeRepository;

	public TechUptakeServiceImpl(TechUptakeRepository techUptakeRepository) {
		this.techUptakeRepository = techUptakeRepository;
	}

	@Override
	public List<SeedMultipliers> getSeedMultipliers() {
		return (List<SeedMultipliers>) techUptakeRepository.findAll();
	}

	@Override
	public Map<String, Integer> getPlantingMaterialsFrequency() {
		List<String> plantingMaterialsList =
				techUptakeRepository.getPlantingMaterials();

		List<String> sanitizedPlantingMaterials = new ArrayList<>();

		for(String plantingMaterial : plantingMaterialsList) {
			String[] splitArray = plantingMaterial.split("\\s+");

			for(String plantingMaterialType : splitArray){
				sanitizedPlantingMaterials.add(plantingMaterialType);
			}
		}

		Map<String, Integer> plantingMaterialsMap = new TreeMap<>();

		for(String plantingMaterial : sanitizedPlantingMaterials) {
			plantingMaterial = plantingMaterial.toLowerCase();

			if(plantingMaterialsMap.containsKey(plantingMaterial)) {
				plantingMaterialsMap.put(plantingMaterial, plantingMaterialsMap.get(plantingMaterial) + 1);
			} else {
				plantingMaterialsMap.put(plantingMaterial, 1);
			}
		}

		return plantingMaterialsMap;
	}

	@Override
	public Map<String, Integer> getPlantingVarietiesFrequency() {
		List<String> plantingVarietiesList =
				techUptakeRepository.getPlantingVarieties();

		List<String> sanitizedPlantingVarities = new ArrayList<>();

		for(String plantingVariety : plantingVarietiesList) {
			String[] splitArray = plantingVariety.split("\\s+");

			for(String plantingVarietyType : splitArray){
				sanitizedPlantingVarities.add(plantingVarietyType);
			}
		}

		Map<String, Integer> plantingVarietiesMap = new TreeMap<>();

		for(String sanitizedPlantingVariety : sanitizedPlantingVarities) {
			sanitizedPlantingVariety = sanitizedPlantingVariety.toLowerCase();

			if(plantingVarietiesMap.containsKey(sanitizedPlantingVariety)) {
				plantingVarietiesMap.put(sanitizedPlantingVariety, plantingVarietiesMap.get(sanitizedPlantingVariety) + 1);
			} else {
				plantingVarietiesMap.put(sanitizedPlantingVariety, 1);
			}
		}

		return plantingVarietiesMap;
	}

	@Override
	public Map<String, Integer> getBananaVarietiesFrequency() {
		List<String> presetBananaVarieties =
				techUptakeRepository.getPlantingVarieties();
		List<String> otherBananaVarieties =
				techUptakeRepository.getOtherBananaVarieties();

		presetBananaVarieties.removeIf(variety -> !variety.contains("banana"));

		Map<String, Integer> bananaVarietiesFrequencyMap = new TreeMap<>();

		List<String> bananaVarietiesComboList = new ArrayList<>();
		bananaVarietiesComboList.addAll(presetBananaVarieties);
		bananaVarietiesComboList.addAll(otherBananaVarieties);

		List<String> sanitizedBananaVarieties = new ArrayList<>();

		for(String bVariety : bananaVarietiesComboList) {
			if(bVariety == null) {
				continue;
			}

			String[] splitArray = bVariety.split("\\s+");

			for(String bananaVarietyType : splitArray){
				sanitizedBananaVarieties.add(bananaVarietyType);
			}
		}

		for(String bananaVariety : sanitizedBananaVarieties) {
			if(bananaVariety == null) {
				continue;
			}

			if(bananaVarietiesFrequencyMap.containsKey(bananaVariety)) {
				bananaVarietiesFrequencyMap.put(bananaVariety,
						bananaVarietiesFrequencyMap.get(bananaVariety) + 1);
			} else {
				bananaVarietiesFrequencyMap.put(bananaVariety, 1);
			}
		}

		return bananaVarietiesFrequencyMap;
	}

	@Override
	public Map<String, Integer> getPotatoVarietiesFrequency() {
		List<String> presetPotatoVarieties =
				techUptakeRepository.getPlantingVarieties();
		List<String> otherPotatoVarieties =
				techUptakeRepository.getOtherPotatoVarieties();

		presetPotatoVarieties.removeIf(variety -> !variety.contains("potato"));

		Map<String, Integer> potatoVarietiesFrequencyMap = new TreeMap<>();

		List<String> potatoVarietiesComboList = new ArrayList<>();
		potatoVarietiesComboList.addAll(presetPotatoVarieties);
		potatoVarietiesComboList.addAll(otherPotatoVarieties);

		List<String> sanitizedPotatoVarieties = new ArrayList<>();

		for(String pVariety : potatoVarietiesComboList) {
			if(pVariety == null) {
				continue;
			}

			String[] splitArray = pVariety.split("\\s+");

			for(String potatoVarietyType : splitArray){
				sanitizedPotatoVarieties.add(potatoVarietyType);
			}
		}

		for(String potatoVariety : sanitizedPotatoVarieties) {
			if(potatoVariety == null) {
				continue;
			}

			if(potatoVarietiesFrequencyMap.containsKey(potatoVariety)) {
				potatoVarietiesFrequencyMap.put(potatoVariety,
						potatoVarietiesFrequencyMap.get(potatoVariety) + 1);
			} else {
				potatoVarietiesFrequencyMap.put(potatoVariety, 1);
			}
		}

		return potatoVarietiesFrequencyMap;
	}

	@Override
	public Map<String, Integer> getPlantingTechFrequency() {
		List<String> plantingTechList = new ArrayList<>();
		plantingTechList.addAll(techUptakeRepository.getPresetPlantingTech());
		plantingTechList.addAll(techUptakeRepository.getOtherPlantingTech());

		Map<String, Integer> plantingTechFrequencyMap = new TreeMap<>();

		for(String plantingTech : plantingTechList) {
			if(plantingTech == null) {
				continue;
			}

			plantingTech = plantingTech.toLowerCase();

			if(plantingTechFrequencyMap.containsKey(plantingTech)) {
				plantingTechFrequencyMap.put(plantingTech,
						plantingTechFrequencyMap.get(plantingTech) + 1);
			} else {
				plantingTechFrequencyMap.put(plantingTech, 1);
			}
		}


		return plantingTechFrequencyMap;
	}

	@Override
	public int getAverageBananaPlantingMaterialsProduced() {
		return (int) Math.round(techUptakeRepository.getAverageBananaPlantingMaterialsProduced());
	}

	@Override
	public int getMedianBananaPlantingMaterialsProduced() {
		List<Integer> bananaPlantingMaterialsProduced =
				techUptakeRepository.getBananaPlantingMaterialsProduced();
		int size = bananaPlantingMaterialsProduced.size();

		Collections.sort(bananaPlantingMaterialsProduced);


		return Math.round((bananaPlantingMaterialsProduced.get(size/2) + bananaPlantingMaterialsProduced.get((size - 1)/2)) / 2);
	}

	@Override
	public int getAveragePotatoPlantingMaterialsProduced() {
		return (int) Math.round(techUptakeRepository.getAveragePotatoPlantingMaterialsProduced());
	}

	@Override
	public int getMedianPotatoPlantingMaterialsProduced() {
		List<Integer> potatoPlantingMaterialsProduced =
				techUptakeRepository.getPotatoPlantingMaterialsProduced();
		int size = potatoPlantingMaterialsProduced.size();

		Collections.sort(potatoPlantingMaterialsProduced);


		return Math.round((potatoPlantingMaterialsProduced.get(size/2) + potatoPlantingMaterialsProduced.get((size - 1)/2)) / 2);
	}

	@Override
	public int getAverageNumberOfProductionTimes() {
		return (int) Math.round(techUptakeRepository.getAverageNumberOfProductionTimes());
	}

	@Override
	public int getMedianNumberOfProductionTimes() {
		List<Integer> productionTimes =
				techUptakeRepository.getProductionTimes();
		int size = productionTimes.size();

		Collections.sort(productionTimes);


		return Math.round((productionTimes.get(size/2) + productionTimes.get((size - 1)/2)) / 2);
	}

	@Override
	public int getAverageIndividualBuyersQuantityPerSeason() {
		return (int) Math.round(techUptakeRepository.getAverageIndividualBuyersQuantityPerSeason());
	}

	@Override
	public int getMedianIndividualBuyersQuantityPerSeason() {
		List<Integer> individualBuyersQuantityPerSeason =
				techUptakeRepository.getIndividualBuyersQuantityPerSeason();
		int size = individualBuyersQuantityPerSeason.size();

		Collections.sort(individualBuyersQuantityPerSeason);


		return Math.round((individualBuyersQuantityPerSeason.get(size/2) + individualBuyersQuantityPerSeason.get((size - 1)/2)) / 2);
	}

	@Override
	public int getFemaleBuyersAverageAge() {
		return (int) Math.round(techUptakeRepository.getFemaleBuyersAverageAge());
	}

	@Override
	public int getFemaleBuyersMedianAge() {
		List<Integer> femaleBuyersAges =
				techUptakeRepository.getFemaleBuyersAges();
		int size = femaleBuyersAges.size();

		Collections.sort(femaleBuyersAges);


		return Math.round((femaleBuyersAges.get(size/2) + femaleBuyersAges.get((size - 1)/2)) / 2);
	}

	@Override
	public int getMaleBuyersAverageAge() {
		return (int) Math.round(techUptakeRepository.getMaleBuyersAverageAge());
	}

	@Override
	public int getMaleBuyersMedianAge() {
		List<Integer> maleBuyersAges =
				techUptakeRepository.getMaleBuyersAges();
		int size = maleBuyersAges.size();

		Collections.sort(maleBuyersAges);


		return Math.round((maleBuyersAges.get(size/2) + maleBuyersAges.get((size - 1)/2)) / 2);
	}

	@Override
	public Map<String, Integer> getSellingPointsFrequency() {
		List<String> sellingPoints = techUptakeRepository.getSellingPoints();

		Map<String, Integer> sellingPointsFrequencyMap = new TreeMap<>();

		for(String sellingPoint : sellingPoints) {
			sellingPoint = sellingPoint.toLowerCase();

			if(sellingPointsFrequencyMap.containsKey(sellingPoint)) {
				sellingPointsFrequencyMap.put(sellingPoint,
						sellingPointsFrequencyMap.get(sellingPoint) + 1);
			} else {
				sellingPointsFrequencyMap.put(sellingPoint, 1);
			}
		}


		return sellingPointsFrequencyMap;
	}

	@Override
	public int getAverageAnnualProductionCapacity() {
		return (int) Math.round(techUptakeRepository.getAverageAnnualProductionCapacity());
	}

	@Override
	public int getMedianAnnualProductionCapacity() {
		List<Integer> annualProductionCapacities =
				techUptakeRepository.getAnnualProductionCapacities();
		int size = annualProductionCapacities.size();

		Collections.sort(annualProductionCapacities);


		return Math.round((annualProductionCapacities.get(size/2) + annualProductionCapacities.get((size - 1)/2)) / 2);
	}

	@Override
	public int getAverageAnnualProductionSold() {
		return (int) Math.round(techUptakeRepository.getAverageAnnualProductionSold());
	}

	@Override
	public int getMedianAnnualProductionSold() {
		List<Integer> annualProductionSold =
				techUptakeRepository.getAnnualProductionSold();
		int size = annualProductionSold.size();

		Collections.sort(annualProductionSold);


		return Math.round((annualProductionSold.get(size/2) + annualProductionSold.get((size - 1)/2)) / 2);
	}

	@Override
	public int getAverageAnnualProductionGivenAway() {
		return (int) Math.round(techUptakeRepository.getAverageAnnualProductionGivenAway());
	}

	@Override
	public int getMedianAnnualProductionGivenAway() {
		List<Integer> annualProductionGivenAway =
				techUptakeRepository.getAnnualProductionGivenAway();
		int size = annualProductionGivenAway.size();

		Collections.sort(annualProductionGivenAway);


		return Math.round((annualProductionGivenAway.get(size/2) + annualProductionGivenAway.get((size - 1)/2)) / 2);
	}

	@Override
	public int getAverageAnnualProductionLost() {
		return (int) Math.round(techUptakeRepository.getAverageAnnualProductionLost());
	}

	@Override
	public int getMedianAnnualProductionLost() {
		List<Integer> annualProductionLost =
				techUptakeRepository.getAnnualProductionLost();
		int size = annualProductionLost.size();

		Collections.sort(annualProductionLost);


		return Math.round((annualProductionLost.get(size/2) + annualProductionLost.get((size - 1)/2)) / 2);
	}

	@Override
	public int getAverageCurrentPlantingMaterialsStock() {
		return (int) Math.round(techUptakeRepository.getAverageCurrentPlantingMaterialsStock());
	}

	@Override
	public int getMedianCurrentPlantingMaterialsStock() {
		List<Integer> currentPlantingMaterialsStock =
				techUptakeRepository.getCurrentPlantingMaterialsStock();
		int size = currentPlantingMaterialsStock.size();

		Collections.sort(currentPlantingMaterialsStock);


		return Math.round((currentPlantingMaterialsStock.get(size/2) + currentPlantingMaterialsStock.get((size - 1)/2)) / 2);
	}
}
