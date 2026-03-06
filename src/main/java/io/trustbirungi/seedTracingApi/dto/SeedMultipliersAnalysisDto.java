package io.trustbirungi.seedTracingApi.dto;

import java.util.Map;

import lombok.Data;

@Data
public class SeedMultipliersAnalysisDto {
	double malePercent;
	double femalePercent;
	int maleAverageAge;
	int femaleAverageAge;
	int maleMedianAge;
	int femaleMedianAge;
	Map<String, Integer> maleAgeCohorts;
	Map<String, Integer> femaleAgeCohorts;
	double individualMultipliersPercent;
	double groupMultipliersPercent;
	int averageGroupSize;
	int medianGroupSize;
	int averageFemaleMembersPerGroup;
	int averageMaleMembersPerGroup;
	Map<String, Integer> multipliersDistricts;
	Map<String, Integer> plantingMaterialsFrequency;
	Map<String, Integer> plantingMaterialsVarietiesFrequency;
	Map<String, Integer> bananaPlantingVarietiesFrequency;
	Map<String, Integer> potatoPlantingVarietiesFrequency;
	Map<String, Integer> plantingMethodsFrequency;

	public void setMalePercent(double malePercent) {
		this.malePercent = malePercent;
	}

	public void setFemalePercent(double femalePercent) {
		this.femalePercent = femalePercent;
	}

	public void setMaleAverageAge(int maleAverageAge) {
		this.maleAverageAge = maleAverageAge;
	}

	public void setFemaleAverageAge(int femaleAverageAge) {
		this.femaleAverageAge = femaleAverageAge;
	}

	public void setMaleMedianAge(int maleMedianAge) {
		this.maleMedianAge = maleMedianAge;
	}

	public void setFemaleMedianAge(int femaleMedianAge) {
		this.femaleMedianAge = femaleMedianAge;
	}

	public void setMaleAgeCohorts(Map<String, Integer> maleAgeCohorts) {
		this.maleAgeCohorts = maleAgeCohorts;
	}

	public void setFemaleAgeCohorts(Map<String, Integer> femaleAgeCohorts) {
		this.femaleAgeCohorts = femaleAgeCohorts;
	}

	public void setIndividualMultipliersPercent(double individualMultipliersPercent) {
		this.individualMultipliersPercent = individualMultipliersPercent;
	}

	public void setGroupMultipliersPercent(double groupMultipliersPercent) {
		this.groupMultipliersPercent = groupMultipliersPercent;
	}

	public void setAverageGroupSize(int averageGroupSize) {
		this.averageGroupSize = averageGroupSize;
	}

	public void setMedianGroupSize(int medianGroupSize) {
		this.medianGroupSize = medianGroupSize;
	}

	public void setAverageFemaleMembersPerGroup(int averageFemaleMembersPerGroup) {
		this.averageFemaleMembersPerGroup = averageFemaleMembersPerGroup;
	}

	public void setAverageMaleMembersPerGroup(int averageMaleMembersPerGroup) {
		this.averageMaleMembersPerGroup = averageMaleMembersPerGroup;
	}

	public void setMultipliersDistricts(Map<String, Integer> multipliersDistricts) {
		this.multipliersDistricts = multipliersDistricts;
	}

	public void setPlantingMaterialsFrequency(Map<String, Integer> plantingMaterialsFrequency) {
		this.plantingMaterialsFrequency = plantingMaterialsFrequency;
	}

	public void setPlantingMaterialsVarietiesFrequency(Map<String, Integer> plantingMaterialsVarietiesFrequency) {
		this.plantingMaterialsVarietiesFrequency = plantingMaterialsVarietiesFrequency;
	}

	public void setBananaPlantingVarietiesFrequency(Map<String, Integer> bananaPlantingVarietiesFrequency) {
		this.bananaPlantingVarietiesFrequency = bananaPlantingVarietiesFrequency;
	}

	public void setPotatoPlantingVarietiesFrequency(Map<String, Integer> potatoPlantingVarietiesFrequency) {
		this.potatoPlantingVarietiesFrequency = potatoPlantingVarietiesFrequency;
	}

	public void setPlantingMethodsFrequency(Map<String, Integer> plantingMethodsFrequency) {
		this.plantingMethodsFrequency = plantingMethodsFrequency;
	}
}
