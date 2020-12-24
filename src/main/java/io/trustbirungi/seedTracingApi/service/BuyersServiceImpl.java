package io.trustbirungi.seedTracingApi.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.trustbirungi.seedTracingApi.entity.Buyers;
import io.trustbirungi.seedTracingApi.repository.BuyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyersServiceImpl implements BuyersService {
	@Autowired
	private BuyersRepository buyersRepository;

	public List<Buyers> getBuyers() {
		return (List<Buyers>) buyersRepository.findAll();
	}

	/**
	 * @return the percent of buyers who are male
	 */
	@Override
	public double getMaleBuyersPercent() {
		double totalBuyers =
				buyersRepository.getMaleBuyersCount() + buyersRepository.getFemaleBuyersCount();

		double maleBuyersPercent =
				(buyersRepository.getMaleBuyersCount() / totalBuyers) * 100;

		return maleBuyersPercent;
	}

	/**
	 * @return the percent of buyers who are female
	 */
	@Override
	public double getFemaleBuyersPercent() {
		double totalBuyers =
				buyersRepository.getMaleBuyersCount() + buyersRepository.getFemaleBuyersCount();

		double femaleBuyersPercent =
				(buyersRepository.getFemaleBuyersCount() / totalBuyers) * 100;

		return femaleBuyersPercent;
	}

	/**
	 * @return the average age of male buyers
	 */
	@Override
	public int getMaleBuyersAverageAge() {
		return Math.round(buyersRepository.getMaleBuyersAverageAge());
	}

	/**
	 * @return the average age of female buyers
	 */
	@Override
	public int getFemaleBuyersAverageAge() {
		return Math.round(buyersRepository.getFemaleBuyersAverageAge());
	}

	/**
	 * @return the median age of male buyers
	 */
	@Override
	public int getMaleBuyersMedianAge() {
		List<Integer> maleBuyersAges = buyersRepository.getMaleBuyersAges();

		int size = maleBuyersAges.size();

		Collections.sort(maleBuyersAges);
		return Math.round((maleBuyersAges.get(size/2) + maleBuyersAges.get((size - 1)/2)) / 2);
	}

	/**
	 * @return the median age of female buyers
	 */
	@Override
	public int getFemaleBuyersMedianAge() {
		List<Integer> femaleBuyersAges = buyersRepository.getFemaleBuyersAges();

		int size = femaleBuyersAges.size();

		Collections.sort(femaleBuyersAges);
		return Math.round((femaleBuyersAges.get(size/2) + femaleBuyersAges.get((size - 1)/2)) / 2);
	}

	/**
	 * @return the age cohorts and the number of buyers in each age cohort
	 */
	@Override
	public Map<String, Integer> getAgeCohorts() {
		List<Integer> buyersAges = buyersRepository.getBuyersAges();

		Map<String, Integer> ageCohorts = new HashMap<>();
		ageCohorts.put("18 - 29", 0);
		ageCohorts.put("30 - 39", 0);
		ageCohorts.put("40 - 49", 0);
		ageCohorts.put("50 - 59", 0);
		ageCohorts.put("60 - 69", 0);
		ageCohorts.put("70 - 79", 0);
		ageCohorts.put("80 - 89", 0);
		ageCohorts.put("90 - 99", 0);


		for(Integer age : buyersAges) {
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
	 * @return the districts of the buyers
	 */
	@Override
	public Map<String, Integer> getBuyersDistricts() {
		List<String> districtList = buyersRepository.getBuyersDistricts();

		Map<String, Integer> districtMap = new HashMap<>();

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
	 * @return the average number of planting materials bought
	 */
	@Override
	public int getBoughtPlantingMaterialsAverageQuantity() {
		return 0;
	}

	/**
	 * @return the median number of planting materials bought
	 */
	@Override
	public int getBoughtPlantingMaterialsMedianQuantity() {
		return 0;
	}

	/**
	 * @return the average number of planting materials that survived
	 */
	@Override
	public int getSurvivedPlantingMaterialsAverageQuantity() {
		return 0;
	}

	/**
	 * @return the median number of planting materials that survived
	 */
	@Override
	public int getSurvivedPlantingMaterialsMedianQuantity() {
		return 0;
	}

	/**
	 * @return the average number of planting materials that got damaged
	 */
	@Override
	public int getDamagedPlantingMaterialsAverageQuantity() {
		return 0;
	}

	/**
	 * @return the median number of planting materials that got damaged
	 */
	@Override
	public int getDamagedPlantingMaterialsMedianQuantity() {
		return 0;
	}

}
