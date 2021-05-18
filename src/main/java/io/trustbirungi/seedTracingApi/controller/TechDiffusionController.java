package io.trustbirungi.seedTracingApi.controller;

import java.util.List;

import io.trustbirungi.seedTracingApi.dto.TechDiffusionAnalysisDto;
import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import io.trustbirungi.seedTracingApi.service.TechDiffusionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/techDiffusion")
@CrossOrigin
public class TechDiffusionController {
	TechDiffusionService techDiffusionService;

	public TechDiffusionController(TechDiffusionService techDiffusionService) {
		this.techDiffusionService = techDiffusionService;
	}

	@GetMapping(value = "/seedMultipliers", produces = "application/json")
	public List<SeedMultipliers> getAll(){
		return techDiffusionService.getSeedMultipliers();
	}

	@GetMapping(value = "/analysis", produces = "application/json")
	public TechDiffusionAnalysisDto getTechDiffusionAnalysis() {
		TechDiffusionAnalysisDto techDiffusionAnalysisDto =
				new TechDiffusionAnalysisDto();

		techDiffusionAnalysisDto.setTrainingOrgTraineesCount(techDiffusionService.getTrainingOrgTraineesCount());
		techDiffusionAnalysisDto.setFarmersWhoTrainedOthersPercent(techDiffusionService.getFarmersWhoTrainedOthersPercent());
		techDiffusionAnalysisDto.setFarmersWhoTrainedOtherGroupsPercent(techDiffusionService.getFarmersWhoTrainedOtherGroupsPercent());
		techDiffusionAnalysisDto.setFemaleTrainedFarmersPercent(techDiffusionService.getFemaleTrainedFarmersPercent());
		techDiffusionAnalysisDto.setMaleTrainedFarmersPercent(techDiffusionService.getMaleTrainedFarmersPercent());
		techDiffusionAnalysisDto.setTrainedFarmersThatTrainedOtherFarmersPercent(techDiffusionService.getTrainedFarmersThatTrainedOtherFarmersPercent());
		techDiffusionAnalysisDto.setTrainedFarmersRankings(techDiffusionService.getTrainedFarmersRankings());
		techDiffusionAnalysisDto.setTrainedFarmersDistricts(techDiffusionService.getTrainedFarmersDistricts());
		techDiffusionAnalysisDto.setTrainedGroupsDistricts(techDiffusionService.getTrainedGroupsDistricts());

		return techDiffusionAnalysisDto;
	}

}
