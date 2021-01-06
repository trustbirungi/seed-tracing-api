package io.trustbirungi.seedTracingApi.controller;

import java.util.List;

import io.trustbirungi.seedTracingApi.dto.TechUptakeAnalysisDto;
import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import io.trustbirungi.seedTracingApi.service.TechUptakeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/techUptake")
public class TechUptakeController {
	TechUptakeService techUptakeService;

	public TechUptakeController(TechUptakeService techUptakeService) {
		this.techUptakeService = techUptakeService;
	}

	@GetMapping(produces = "application/json")
	public List<SeedMultipliers> getSeedMultipliers() {
		return techUptakeService.getSeedMultipliers();
	}

	@GetMapping(value = "/analysis", produces = "application/json")
	public TechUptakeAnalysisDto getTechUptakeAnalysis() {
		TechUptakeAnalysisDto techUptakeAnalysisDto =
				new TechUptakeAnalysisDto();

		techUptakeAnalysisDto.setPlantingMaterialsFrequency(techUptakeService.getPlantingMaterialsFrequency());
		techUptakeAnalysisDto.setPlantingVarietiesFrequency(techUptakeService.getPlantingVarietiesFrequency());
		techUptakeAnalysisDto.setBananaVarietiesFrequency(techUptakeService.getBananaVarietiesFrequency());
		techUptakeAnalysisDto.setPotatoVarietiesFrequency(techUptakeService.getPotatoVarietiesFrequency());
		techUptakeAnalysisDto.setPlantingTechFrequency(techUptakeService.getPlantingTechFrequency());
		techUptakeAnalysisDto.setAverageBananaPlantingMaterialsProduced(techUptakeService.getAverageBananaPlantingMaterialsProduced());
		techUptakeAnalysisDto.setMedianBananaPlantingMaterialsProduced(techUptakeService.getMedianBananaPlantingMaterialsProduced());
		techUptakeAnalysisDto.setAveragePotatoPlantingMaterialsProduced(techUptakeService.getAveragePotatoPlantingMaterialsProduced());
		techUptakeAnalysisDto.setMedianPotatoPlantingMaterialsProduced(techUptakeService.getMedianPotatoPlantingMaterialsProduced());
		techUptakeAnalysisDto.setAverageNumberOfProductionTimes(techUptakeService.getAverageNumberOfProductionTimes());
		techUptakeAnalysisDto.setMedianNumberOfProductionTimes(techUptakeService.getMedianNumberOfProductionTimes());
		techUptakeAnalysisDto.setAverageIndividualBuyersQuantityPerSeason(techUptakeService.getAverageIndividualBuyersQuantityPerSeason());
		techUptakeAnalysisDto.setMedianIndividualBuyersQuantityPerSeason(techUptakeService.getMedianIndividualBuyersQuantityPerSeason());
		techUptakeAnalysisDto.setFemaleBuyersAverageAge(techUptakeService.getFemaleBuyersAverageAge());
		techUptakeAnalysisDto.setFemaleBuyersMedianAge(techUptakeService.getFemaleBuyersMedianAge());
		techUptakeAnalysisDto.setMaleBuyersAverageAge(techUptakeService.getMaleBuyersAverageAge());
		techUptakeAnalysisDto.setMaleBuyersMedianAge(techUptakeService.getMaleBuyersMedianAge());
		techUptakeAnalysisDto.setSellingPointsFrequency(techUptakeService.getSellingPointsFrequency());
		techUptakeAnalysisDto.setAverageAnnualProductionCapacity(techUptakeService.getAverageAnnualProductionCapacity());
		techUptakeAnalysisDto.setMedianAnnualProductionCapacity(techUptakeService.getMedianAnnualProductionCapacity());
		techUptakeAnalysisDto.setAverageAnnualProductionSold(techUptakeService.getAverageAnnualProductionSold());
		techUptakeAnalysisDto.setMedianAnnualProductionSold(techUptakeService.getMedianAnnualProductionSold());
		techUptakeAnalysisDto.setAverageAnnualProductionGivenAway(techUptakeService.getAverageAnnualProductionGivenAway());
		techUptakeAnalysisDto.setMedianAnnualProductionGivenAway(techUptakeService.getMedianAnnualProductionGivenAway());
		techUptakeAnalysisDto.setAverageAnnualProductionLost(techUptakeService.getAverageAnnualProductionLost());
		techUptakeAnalysisDto.setMedianAnnualProductionLost(techUptakeService.getMedianAnnualProductionLost());
		techUptakeAnalysisDto.setAverageCurrentPlantingMaterialsStock(techUptakeService.getAverageCurrentPlantingMaterialsStock());
		techUptakeAnalysisDto.setMedianCurrentPlantingMaterialsStock(techUptakeService.getMedianCurrentPlantingMaterialsStock());

		return techUptakeAnalysisDto;
	}
}
