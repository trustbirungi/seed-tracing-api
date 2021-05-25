package io.trustbirungi.seedTracingApi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import io.trustbirungi.seedTracingApi.repository.SeedMultipliersRepository;
import org.springframework.stereotype.Service;

@Service
public class SeedMultipliersServiceImpl implements SeedMultipliersService{
	private final SeedMultipliersRepository seedMultipliersRepository;

	public SeedMultipliersServiceImpl(
			SeedMultipliersRepository seedMultipliersRepository) {
		this.seedMultipliersRepository = seedMultipliersRepository;
	}

	/**
	 * @return a list of all seed multipliers.
	 */
	@Override
	public List<SeedMultipliers> getSeedMultipliers() {
		return (List<SeedMultipliers>) seedMultipliersRepository.findAll();
	}

	/**
	 * @return the percent of seed multipliers who are male.
	 */
	@Override
	public double getMalePercent() {
		double maleCount = seedMultipliersRepository.getMaleMultipliersCount();
		double femaleCount =
				seedMultipliersRepository.getFemaleMultipliersCount();
		double malePercent = (maleCount/(maleCount + femaleCount)) * 100;

		return malePercent;
	}

	/**
	 * @return the percent of seed multipliers who are female.
	 */
	@Override
	public double getFemalePercent() {
		double maleCount = seedMultipliersRepository.getMaleMultipliersCount();
		double femaleCount =
				seedMultipliersRepository.getFemaleMultipliersCount();
		double femalePercent = (femaleCount/(maleCount + femaleCount)) * 100;

		return femalePercent;
	}

	/**
	 * @return the average age of male seed multipliers.
	 */
	@Override
	public int getMaleAverageAge() {
		return (int) Math.round(seedMultipliersRepository.getMaleAverageAge());
	}

	/**
	 * @return the average age of female seed multipliers.
	 */
	@Override
	public int getFemaleAverageAge() {
		return (int) Math.round(seedMultipliersRepository.getFemaleAverageAge());
	}

	/**
	 * @return the median age of male seed multipliers.
	 */
	@Override
	public int getMaleMedianAge() {
		List<Integer> maleMultipliersAges = seedMultipliersRepository.getMaleMultipliersAges();

		int size = maleMultipliersAges.size();

		Collections.sort(maleMultipliersAges);
		return Math.round((maleMultipliersAges.get(size/2) + maleMultipliersAges.get((size - 1)/2)) / 2);
	}

	/**
	 * @return the median age of female seed multipliers.
	 */
	@Override
	public int getFemaleMedianAge() {
		List<Integer> femaleMultipliersAges =
				seedMultipliersRepository.getFemaleMultipliersAges();

		int size = femaleMultipliersAges.size();

		Collections.sort(femaleMultipliersAges);
		return Math.round((femaleMultipliersAges.get(size/2) + femaleMultipliersAges.get((size - 1)/2)) / 2);
	}

	/**
	 * @return the map of age cohorts of the seed multipliers.
	 */
	@Override
	public Map<String, Integer> getAgeCohorts() {
		List<Integer> multipliersAges = seedMultipliersRepository.getMultipliersAges();

		Map<String, Integer> ageCohorts = new TreeMap<>();
		ageCohorts.put("18 - 29", 0);
		ageCohorts.put("30 - 39", 0);
		ageCohorts.put("40 - 49", 0);
		ageCohorts.put("50 - 59", 0);
		ageCohorts.put("60 - 69", 0);
		ageCohorts.put("70 - 79", 0);
		ageCohorts.put("80 - 89", 0);
		ageCohorts.put("90 - 99", 0);


		for(Integer age : multipliersAges) {
			if(age >= 18 && age <= 29) {
				ageCohorts.put("18 - 29", ageCohorts.get("18 - 29") + 1);
			} else if(age >= 30 && age <= 39) {
				ageCohorts.put("30 - 39", ageCohorts.get("30 - 39") + 1);
			} else if(age >= 40 && age <= 49) {
				ageCohorts.put("40 - 49", ageCohorts.get("40 - 49") + 1);
			} else if(age >= 50 && age <= 59) {
				ageCohorts.put("50 - 59", ageCohorts.get("50 - 59") + 1);
			} else if(age >= 60 && age <= 69) {
				ageCohorts.put("60 - 69", ageCohorts.get("60 - 69") + 1);
			} else if(age >= 70 && age <= 79) {
				ageCohorts.put("70 - 79", ageCohorts.get("70 - 79") + 1);
			} else if(age >= 80 && age <= 89) {
				ageCohorts.put("80 - 89", ageCohorts.get("80 - 89") + 1);
			} else if(age >= 90 && age <= 99) {
				ageCohorts.put("90 - 99", ageCohorts.get("90 - 99") + 1);
			}
		}

		return ageCohorts;
	}

	/**
	 * @return the map of age cohorts of the female seed multipliers.
	 */
	@Override
	public Map<String, Integer> getFemaleAgeCohorts() {
		List<Integer> multipliersAges = seedMultipliersRepository.getFemaleMultipliersAges();

		Map<String, Integer> ageCohorts = new TreeMap<>();
		ageCohorts.put("18 - 29", 0);
		ageCohorts.put("30 - 39", 0);
		ageCohorts.put("40 - 49", 0);
		ageCohorts.put("50 - 59", 0);
		ageCohorts.put("60 - 69", 0);
		ageCohorts.put("70 - 79", 0);
		ageCohorts.put("80 - 89", 0);
		ageCohorts.put("90 - 99", 0);


		for(Integer age : multipliersAges) {
			if(age >= 18 && age <= 29) {
				ageCohorts.put("18 - 29", ageCohorts.get("18 - 29") + 1);
			} else if(age >= 30 && age <= 39) {
				ageCohorts.put("30 - 39", ageCohorts.get("30 - 39") + 1);
			} else if(age >= 40 && age <= 49) {
				ageCohorts.put("40 - 49", ageCohorts.get("40 - 49") + 1);
			} else if(age >= 50 && age <= 59) {
				ageCohorts.put("50 - 59", ageCohorts.get("50 - 59") + 1);
			} else if(age >= 60 && age <= 69) {
				ageCohorts.put("60 - 69", ageCohorts.get("60 - 69") + 1);
			} else if(age >= 70 && age <= 79) {
				ageCohorts.put("70 - 79", ageCohorts.get("70 - 79") + 1);
			} else if(age >= 80 && age <= 89) {
				ageCohorts.put("80 - 89", ageCohorts.get("80 - 89") + 1);
			} else if(age >= 90 && age <= 99) {
				ageCohorts.put("90 - 99", ageCohorts.get("90 - 99") + 1);
			}
		}

		return ageCohorts;
	}

	/**
	 * @return the map of age cohorts of the male seed multipliers.
	 */
	@Override
	public Map<String, Integer> getMaleAgeCohorts() {
		List<Integer> multipliersAges =
				seedMultipliersRepository.getMaleMultipliersAges();

		Map<String, Integer> ageCohorts = new TreeMap<>();
		ageCohorts.put("18 - 29", 0);
		ageCohorts.put("30 - 39", 0);
		ageCohorts.put("40 - 49", 0);
		ageCohorts.put("50 - 59", 0);
		ageCohorts.put("60 - 69", 0);
		ageCohorts.put("70 - 79", 0);
		ageCohorts.put("80 - 89", 0);
		ageCohorts.put("90 - 99", 0);


		for(Integer age : multipliersAges) {
			if(age >= 18 && age <= 29) {
				ageCohorts.put("18 - 29", ageCohorts.get("18 - 29") + 1);
			} else if(age >= 30 && age <= 39) {
				ageCohorts.put("30 - 39", ageCohorts.get("30 - 39") + 1);
			} else if(age >= 40 && age <= 49) {
				ageCohorts.put("40 - 49", ageCohorts.get("40 - 49") + 1);
			} else if(age >= 50 && age <= 59) {
				ageCohorts.put("50 - 59", ageCohorts.get("50 - 59") + 1);
			} else if(age >= 60 && age <= 69) {
				ageCohorts.put("60 - 69", ageCohorts.get("60 - 69") + 1);
			} else if(age >= 70 && age <= 79) {
				ageCohorts.put("70 - 79", ageCohorts.get("70 - 79") + 1);
			} else if(age >= 80 && age <= 89) {
				ageCohorts.put("80 - 89", ageCohorts.get("80 - 89") + 1);
			} else if(age >= 90 && age <= 99) {
				ageCohorts.put("90 - 99", ageCohorts.get("90 - 99") + 1);
			}
		}

		return ageCohorts;
	}

	/**
	 * @return the percentage of multipliers that produce as individuals.
	 */
	@Override
	public double getIndividualMultipliersPercent() {
		double individualMultipliers =
				seedMultipliersRepository.getIndividualMultipliersCount();
		double groupMultipliers =
				seedMultipliersRepository.getGroupMultipliersCount();


		return (individualMultipliers/(individualMultipliers + groupMultipliers)) * 100;
	}

	/**
	 * @return the percentage of multipliers that produce as part of a group.
	 */
	@Override
	public double getGroupMultipliersPercent() {
		double individualMultipliers =
				seedMultipliersRepository.getIndividualMultipliersCount();
		double groupMultipliers =
				seedMultipliersRepository.getGroupMultipliersCount();


		return (groupMultipliers/(individualMultipliers + groupMultipliers)) * 100;
	}

	/**
	 * @return the average number of members per group.
	 */
	@Override
	public int getAverageGroupSize() {
		return (int) Math.round(seedMultipliersRepository.getAverageGroupSize());
	}

	/**
	 * @return the median number of members per group.
	 */
	@Override
	public int getMedianGroupSize() {
		List<Integer> groupSizes = seedMultipliersRepository.getGroupSizes();
		int size = groupSizes.size();

		Collections.sort(groupSizes);


		return Math.round((groupSizes.get(size/2) + groupSizes.get((size - 1)/2)) / 2);
	}

	/**
	 * @return the average number of women per group.
	 */
	@Override
	public int getAverageFemaleMembersPerGroup() {
		return (int) Math.round(seedMultipliersRepository.getAverageFemaleMembersPerGroup());
	}

	/**
	 * @return the average number of men per group.
	 */
	@Override
	public int getAverageMaleMembersPerGroup() {
		return (int) Math.round(seedMultipliersRepository.getAverageMaleMembersPerGroup());
	}

	/**
	 * @return the districts of the multipliers and their frequencies.
	 */
	@Override
	public Map<String, Integer> getMultipliersDistricts() {
		List<String> districtList =
				seedMultipliersRepository.getMultipliersDistricts();

		Map<String, Integer> districtMap = new TreeMap<>();

		for(String district : districtList) {
			district = district.toLowerCase();

			if(districtMap.containsKey(district)) {
				districtMap.put(district, districtMap.get(district) + 1);
			} else {
				districtMap.put(district, 1);
			}
		}

		return districtMap;
	}

	/**
	 * @return the frequency of usage of the different planting materials.
	 */
	@Override
	public Map<String, Integer> getPlantingMaterialsFrequency() {
		List<String> plantingMaterialsList =
				seedMultipliersRepository.getPlantingMaterials();

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

	/**
	 * @return the frequency of usage of the different varieties of planting
	 * materials.
	 */
	@Override
	public Map<String, Integer> getPlantingMaterialsVarietiesFrequency() {
		List<String> varietiesList =
				seedMultipliersRepository.getPlantingMaterialsVarieties();

		List<String> sanitizedVarieties = new ArrayList<>();

		for(String variety : varietiesList) {
			String[] splitArray = variety.split("\\s+");

			for(String varietyType : splitArray){
				sanitizedVarieties.add(varietyType);
			}
		}

		Map<String, Integer> plantingVarietiesMap = new TreeMap<>();

		for(String plantingVariety : sanitizedVarieties) {
			plantingVariety = plantingVariety.toLowerCase();

			if(plantingVarietiesMap.containsKey(plantingVariety)) {
				plantingVarietiesMap.put(plantingVariety, plantingVarietiesMap.get(plantingVariety) + 1);
			} else {
				plantingVarietiesMap.put(plantingVariety, 1);
			}
		}

		return plantingVarietiesMap;
	}

	/**
	 * @return the frequency of usage of the different varieties of banana
	 * planting materials.
	 */
	@Override
	public Map<String, Integer> getBananaVarietiesFrequency() {
		List<String> varietiesList =
				seedMultipliersRepository.getBananaPlantingMaterialsVarieties();

		List<String> sanitizedVarieties = new ArrayList<>();

		for(String variety : varietiesList) {
			String[] splitArray = variety.split("\\s+");

			for(String varietyType : splitArray){
				sanitizedVarieties.add(varietyType);
			}
		}

		Map<String, Integer> plantingVarietiesMap = new TreeMap<>();

		for(String plantingVariety : sanitizedVarieties) {
			plantingVariety = plantingVariety.toLowerCase();

			if(plantingVarietiesMap.containsKey(plantingVariety)) {
				plantingVarietiesMap.put(plantingVariety, plantingVarietiesMap.get(plantingVariety) + 1);
			} else {
				plantingVarietiesMap.put(plantingVariety, 1);
			}
		}

		return plantingVarietiesMap;
	}

	/**
	 * @return the frequency of usage of the different varieties of
	 * sweet potato planting materials.
	 */
	@Override
	public Map<String, Integer> getPotatoVarietiesFrequency() {
		List<String> varietiesList =
				seedMultipliersRepository.getPotatoPlantingMaterialsVarieties();

		List<String> sanitizedVarieties = new ArrayList<>();

		for(String variety : varietiesList) {
			String[] splitArray = variety.split("\\s+");

			for(String varietyType : splitArray){
				sanitizedVarieties.add(varietyType);
			}
		}

		Map<String, Integer> plantingVarietiesMap = new TreeMap<>();

		for(String plantingVariety : sanitizedVarieties) {
			plantingVariety = plantingVariety.toLowerCase();

			if(plantingVarietiesMap.containsKey(plantingVariety)) {
				plantingVarietiesMap.put(plantingVariety, plantingVarietiesMap.get(plantingVariety) + 1);
			} else {
				plantingVarietiesMap.put(plantingVariety, 1);
			}
		}

		return plantingVarietiesMap;
	}

	/**
	 * @return the frequency of usage of the different planting methods.
	 */
	@Override
	public Map<String, Integer> getPlantingMethodsFrequency() {
		List<String> plantingMethodsList =
				seedMultipliersRepository.getPlantingMethods();

		Map<String, Integer> plantingMethodsMap = new TreeMap<>();

		for(String plantingMethod : plantingMethodsList) {
			plantingMethod = plantingMethod.toLowerCase();

			if(plantingMethodsMap.containsKey(plantingMethod)) {
				plantingMethodsMap.put(plantingMethod, plantingMethodsMap.get(plantingMethod) + 1);
			} else {
				plantingMethodsMap.put(plantingMethod, 1);
			}
		}

		return plantingMethodsMap;
	}
}
