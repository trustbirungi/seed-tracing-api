package io.trustbirungi.seedTracingApi.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import io.trustbirungi.seedTracingApi.repository.TechDiffusionRepository;
import org.springframework.stereotype.Service;

@Service
public class TechDiffusionServiceImpl implements TechDiffusionService {
	TechDiffusionRepository techDiffusionRepository;

	public TechDiffusionServiceImpl(
			TechDiffusionRepository techDiffusionRepository) {
		this.techDiffusionRepository = techDiffusionRepository;
	}

	@Override
	public List<SeedMultipliers> getSeedMultipliers() {
		return (List<SeedMultipliers>) techDiffusionRepository.findAll();
	}

	@Override
	public Map<String, Integer> getTrainingOrgTraineesCount() {
		List<String> trainingOrgs = techDiffusionRepository.getTrainingOrgs();
		trainingOrgs.addAll(techDiffusionRepository.getOtherTrainingOrgs());

		Map<String, Integer> trainingOrgsFrequencyMap = new TreeMap<>();

		for(String trainingOrg : trainingOrgs) {
			trainingOrg = trainingOrg.toLowerCase();

			if(trainingOrgsFrequencyMap.containsKey(trainingOrg)) {
				trainingOrgsFrequencyMap.put(trainingOrg,
						trainingOrgsFrequencyMap.get(trainingOrg) + 1);
			} else {
				trainingOrgsFrequencyMap.put(trainingOrg, 1);
			}
		}

		return trainingOrgsFrequencyMap;
	}

	@Override
	public double getFarmersWhoTrainedOthersPercent() {
		return ((double)techDiffusionRepository.getFarmersWhoTrainedOthersCount() / (double)techDiffusionRepository.getTotalFarmersCount()) * 100;
	}

	@Override
	public double getFarmersWhoTrainedOtherGroupsPercent() {
		return ((double)techDiffusionRepository.getFarmersWhoTrainedOtherGroupsCount() / (double)techDiffusionRepository.getTotalFarmersCount()) * 100;
	}

	/**
	 *
	 * @return the percent of the farmers who are female that trained by the
	 * original seed multipliers.
	 */
	@Override
	public double getFemaleTrainedFarmersPercent() {
		return ((double)techDiffusionRepository.getTrainedFarmersWhoAreFemaleCount()
				/ (double)techDiffusionRepository.getTrainedFarmersTotalCount()) * 100;
	}

	/**
	 *
	 * @return the percent of the farmers who are male that trained by the
	 * original seed multipliers.
	 */
	@Override
	public double getMaleTrainedFarmersPercent() {
		return ((double)techDiffusionRepository.getTrainedFarmersWhoAreMaleCount()
				/ (double)techDiffusionRepository.getTrainedFarmersTotalCount()) * 100;
	}

	@Override
	public double getTrainedFarmersThatTrainedOtherFarmersPercent() {
		return ((double)techDiffusionRepository.getFarmersThatTrainedOtherFarmersCount() / (double)techDiffusionRepository.getTotalFarmersCount()) * 100;
	}

	@Override
	public Map<Integer, Integer> getTrainedFarmersRankings() {
		List<Integer> trainedFarmersRankings = techDiffusionRepository.getTrainedFarmersRankings();

		Map<Integer, Integer> trainedFarmersRankingsMap = new TreeMap<>();

		for(Integer trainingRanking : trainedFarmersRankings) {
			if(trainedFarmersRankingsMap.containsKey(trainingRanking)) {
				trainedFarmersRankingsMap.put(trainingRanking,
						trainedFarmersRankingsMap.get(trainingRanking) + 1);
			} else {
				trainedFarmersRankingsMap.put(trainingRanking, 1);
			}
		}

		return trainedFarmersRankingsMap;
	}

	@Override
	public Map<String, Integer> getTrainedFarmersDistricts() {
		List<String> trainedFarmersDistricts = techDiffusionRepository.getTraineeDistricts();

		Map<String, Integer> trainedFarmersDistrictsMap = new TreeMap<>();

		for(String district : trainedFarmersDistricts) {
			district = district.toLowerCase();

			if(trainedFarmersDistrictsMap.containsKey(district)) {
				trainedFarmersDistrictsMap.put(district,
						trainedFarmersDistrictsMap.get(district) + 1);
			} else {
				trainedFarmersDistrictsMap.put(district, 1);
			}
		}

		return trainedFarmersDistrictsMap;
	}

	@Override
	public Map<String, Integer> getTrainedGroupsDistricts() {
		List<String> trainedGroupsDistricts =
				techDiffusionRepository.getTraineeGroupsDistricts();

		Map<String, Integer> trainedGroupsDistrictsMap = new TreeMap<>();

		for(String district : trainedGroupsDistricts) {
			district = district.toLowerCase();

			if(trainedGroupsDistrictsMap.containsKey(district)) {
				trainedGroupsDistrictsMap.put(district,
						trainedGroupsDistrictsMap.get(district) + 1);
			} else {
				trainedGroupsDistrictsMap.put(district, 1);
			}
		}

		return trainedGroupsDistrictsMap;
	}
}
