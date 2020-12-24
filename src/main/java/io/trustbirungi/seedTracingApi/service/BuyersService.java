package io.trustbirungi.seedTracingApi.service;

import java.util.List;
import java.util.Map;

import io.trustbirungi.seedTracingApi.entity.Buyers;

public interface BuyersService {

	/**
	 *
	 * @return a list of all buyers
	 */
	List<Buyers> getBuyers();

	/**
	 *
	 * @return the percent of buyers who are male
	 */
	double getMaleBuyersPercent();

	/**
	 *
	 * @return the percent of buyers who are female
	 */
	double getFemaleBuyersPercent();

	/**
	 *
	 * @return the average age of male buyers
	 */
	int getMaleBuyersAverageAge();

	/**
	 *
	 * @return the average age of female buyers
	 */
	int getFemaleBuyersAverageAge();

	/**
	 *
	 * @return the median age of male buyers
	 */
	int getMaleBuyersMedianAge();

	/**
	 *
	 * @return the median age of female buyers
	 */
	int getFemaleBuyersMedianAge();

	/**
	 *
	 * @return the age cohorts and the number of buyers in each age cohort
	 */
	Map<String, Integer> getAgeCohorts();

	/**
	 *
	 * @return the districts of the buyers
	 */
	Map<String, Integer> getBuyersDistricts();

	/**
	 *
	 * @return the average number of planting materials bought
	 */
	int getBoughtPlantingMaterialsAverageQuantity();

	/**
	 *
	 * @return the median number of planting materials bought
	 */
	int getBoughtPlantingMaterialsMedianQuantity();

	/**
	 *
	 * @return the average number of planting materials that survived
	 */
	int getSurvivedPlantingMaterialsAverageQuantity();

	/**
	 *
	 * @return the median number of planting materials that survived
	 */
	int getSurvivedPlantingMaterialsMedianQuantity();

	/**
	 *
	 * @return the average number of planting materials that got damaged
	 */
	int getDamagedPlantingMaterialsAverageQuantity();

	/**
	 *
	 * @return the median number of planting materials that got damaged
	 */
	int getDamagedPlantingMaterialsMedianQuantity();

}
