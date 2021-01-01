package io.trustbirungi.seedTracingApi.service;

import java.util.List;
import java.util.Map;

import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;

public interface TechDiffusionService {
	List<SeedMultipliers> getSeedMultipliers();
	Map<String, Integer> getTrainingOrgTraineesCount();
	double getFarmersWhoTrainedOthersPercent();
	double getFarmersWhoTrainedOtherGroupsPercent();
	double getFemaleTrainedFarmersPercent();
	double getMaleTrainedFarmersPercent();
	double getTrainedFarmersThatTrainedOtherFarmersPercent();
	Map<Integer, Integer> getTrainedFarmersRankings();
	Map<String, Integer> getTrainedFarmersDistricts();
	Map<String, Integer> getTrainedGroupsDistricts();
}
