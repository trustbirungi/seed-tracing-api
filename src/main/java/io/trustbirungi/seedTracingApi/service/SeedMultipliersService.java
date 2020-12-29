package io.trustbirungi.seedTracingApi.service;

import java.util.List;
import java.util.Map;

import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;

public interface SeedMultipliersService {

	/**
	 *
	 * @return a list of all seed multipliers.
	 */
	List<SeedMultipliers> getSeedMultipliers();

	/**
	 *
	 * @return the percent of seed multipliers who are male.
	 */
	double getMalePercent();

	/**
	 *
	 * @return the percent of seed multipliers who are female.
	 */
	double getFemalePercent();

	/**
	 *
	 * @return the average age of male seed multipliers.
	 */
	int getMaleAverageAge();

	/**
	 *
	 * @return the average age of female seed multipliers.
	 */
	int getFemaleAverageAge();

	/**
	 *
	 * @return the median age of male seed multipliers.
	 */
	int getMaleMedianAge();

	/**
	 *
	 * @return the median age of female seed multipliers.
	 */
	int getFemaleMedianAge();

	/**
	 *
	 * @return the map of age cohorts of the seed multipliers.
	 */
	Map<String, Integer> getAgeCohorts();

	/**
	 *
	 * @return the map of age cohorts of the female seed multipliers.
	 */
	Map<String, Integer> getFemaleAgeCohorts();

	/**
	 *
	 * @return the map of age cohorts of the male seed multipliers.
	 */
	Map<String, Integer> getMaleAgeCohorts();

	/**
	 *
	 * @return the percentage of multipliers that produce as individuals.
	 */
	double getIndividualMultipliersPercent();

	/**
	 *
	 * @return the percentage of multipliers that produce as part of a group.
	 */
	double getGroupMultipliersPercent();

	/**
	 *
	 * @return the average number of members per group.
	 */
	int getAverageGroupSize();

	/**
	 *
	 * @return the median number of members per group.
	 */
	int getMedianGroupSize();

	/**
	 *
	 * @return the average number of women per group.
	 */
	int getAverageFemaleMembersPerGroup();

	/**
	 *
	 * @return the average number of men per group.
	 */
	int getAverageMaleMembersPerGroup();

	/**
	 *
	 * @return the districts of the multipliers and their frequencies.
	 */
	Map<String, Integer> getMultipliersDistricts();

	/**
	 *
	 * @return the frequency of usage of the different planting materials.
	 */
	Map<String, Integer> getPlantingMaterialsFrequency();

	/**
	 *
	 * @return the frequency of usage of the different varieties of planting
	 * materials.
	 */
	Map<String, Integer> getPlantingMaterialsVarietiesFrequency();

	/**
	 *
	 * @return the frequency of usage of the different varieties of banana
	 * planting materials.
	 */
	Map<String, Integer> getBananaVarietiesFrequency();

	/**
	 *
	 * @return the frequency of usage of the different varieties of
	 * sweet potato planting materials.
	 */
	Map<String, Integer> getPotatoVarietiesFrequency();

	/**
	 *
	 * @return the frequency of usage of the different planting methods.
	 */
	Map<String, Integer> getPlantingMethodsFrequency();


}
