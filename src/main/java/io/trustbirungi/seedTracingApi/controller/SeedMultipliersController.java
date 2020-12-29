package io.trustbirungi.seedTracingApi.controller;

import java.util.List;

import io.trustbirungi.seedTracingApi.dto.SeedMultipliersAnalysisDto;
import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import io.trustbirungi.seedTracingApi.service.SeedMultipliersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seedMultipliers")
public class SeedMultipliersController {
	private final SeedMultipliersService seedMultipliersService;

	public SeedMultipliersController(
			SeedMultipliersService seedMultipliersService) {
		this.seedMultipliersService = seedMultipliersService;
	}

	@GetMapping(produces = "application/json")
	public List<SeedMultipliers> getSeedMultipliers() {
		return seedMultipliersService.getSeedMultipliers();
	}

	@GetMapping(value = "/analysis", produces = "application/json")
	public SeedMultipliersAnalysisDto getSeedMultipliersAnalysis() {
		SeedMultipliersAnalysisDto analysisDto =
				new SeedMultipliersAnalysisDto();

		analysisDto.setMalePercent(seedMultipliersService.getMalePercent());
		analysisDto.setFemalePercent(seedMultipliersService.getFemalePercent());
		analysisDto.setMaleAverageAge(seedMultipliersService.getMaleAverageAge());
		analysisDto.setFemaleAverageAge(seedMultipliersService.getFemaleAverageAge());
		analysisDto.setMaleMedianAge(seedMultipliersService.getMaleMedianAge());
		analysisDto.setFemaleMedianAge(seedMultipliersService.getFemaleMedianAge());
		analysisDto.setMaleAgeCohorts(seedMultipliersService.getMaleAgeCohorts());
		analysisDto.setFemaleAgeCohorts(seedMultipliersService.getFemaleAgeCohorts());
		analysisDto.setIndividualMultipliersPercent(seedMultipliersService.getIndividualMultipliersPercent());
		analysisDto.setGroupMultipliersPercent(seedMultipliersService.getGroupMultipliersPercent());
		analysisDto.setAverageGroupSize(seedMultipliersService.getAverageGroupSize());
		analysisDto.setMedianGroupSize(seedMultipliersService.getMedianGroupSize());
		analysisDto.setAverageFemaleMembersPerGroup(seedMultipliersService.getAverageFemaleMembersPerGroup());
		analysisDto.setAverageMaleMembersPerGroup(seedMultipliersService.getAverageMaleMembersPerGroup());
		analysisDto.setMultipliersDistricts(seedMultipliersService.getMultipliersDistricts());
		analysisDto.setPlantingMaterialsFrequency(seedMultipliersService.getPlantingMaterialsFrequency());
		analysisDto.setPlantingMaterialsVarietiesFrequency(seedMultipliersService.getPlantingMaterialsVarietiesFrequency());
		analysisDto.setBananaPlantingVarietiesFrequency(seedMultipliersService.getBananaVarietiesFrequency());
		analysisDto.setPotatoPlantingVarietiesFrequency(seedMultipliersService.getPotatoVarietiesFrequency());
		analysisDto.setPlantingMethodsFrequency(seedMultipliersService.getPlantingMethodsFrequency());

		return analysisDto;
	}
}
