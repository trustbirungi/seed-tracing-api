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

	public void setTrainingOrgTraineesCount(Map<String, Integer> trainingOrgTraineesCount) {
		this.trainingOrgTraineesCount = trainingOrgTraineesCount;
	}

	public void setFarmersWhoTrainedOthersPercent(double farmersWhoTrainedOthersPercent) {
		this.farmersWhoTrainedOthersPercent = farmersWhoTrainedOthersPercent;
	}

	public void setFarmersWhoTrainedOtherGroupsPercent(double farmersWhoTrainedOtherGroupsPercent) {
		this.farmersWhoTrainedOtherGroupsPercent = farmersWhoTrainedOtherGroupsPercent;
	}

	public void setFemaleTrainedFarmersPercent(double femaleTrainedFarmersPercent) {
		this.femaleTrainedFarmersPercent = femaleTrainedFarmersPercent;
	}

	public void setMaleTrainedFarmersPercent(double maleTrainedFarmersPercent) {
		this.maleTrainedFarmersPercent = maleTrainedFarmersPercent;
	}

	public void setTrainedFarmersThatTrainedOtherFarmersPercent(double trainedFarmersThatTrainedOtherFarmersPercent) {
		this.trainedFarmersThatTrainedOtherFarmersPercent = trainedFarmersThatTrainedOtherFarmersPercent;
	}

	public void setTrainedFarmersRankings(Map<Integer, Integer> trainedFarmersRankings) {
		this.trainedFarmersRankings = trainedFarmersRankings;
	}

	public void setTrainedFarmersDistricts(Map<String, Integer> trainedFarmersDistricts) {
		this.trainedFarmersDistricts = trainedFarmersDistricts;
	}

	public void setTrainedGroupsDistricts(Map<String, Integer> trainedGroupsDistricts) {
		this.trainedGroupsDistricts = trainedGroupsDistricts;
	}
}
