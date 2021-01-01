package io.trustbirungi.seedTracingApi.dto;

import java.util.Map;

import lombok.Data;

@Data
public class TechDiffusionAnalysisDto {
	Map<String, Integer> trainingOrgTraineesCount;
	double farmersWhoTrainedOthersPercent;
	double farmersWhoTrainedOtherGroupsPercent;
	double femaleTrainedFarmersPercent;
	double maleTrainedFarmersPercent;
	double trainedFarmersThatTrainedOtherFarmersPercent;
	Map<Integer, Integer> trainedFarmersRankings;
	Map<String, Integer> trainedFarmersDistricts;
	Map<String, Integer> trainedGroupsDistricts;
}
