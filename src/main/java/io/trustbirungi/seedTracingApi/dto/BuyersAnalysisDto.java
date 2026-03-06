package io.trustbirungi.seedTracingApi.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class BuyersAnalysisDto {
	double maleBuyersPercent;
	double femaleBuyersPercent;
	int maleBuyersAverageAge;
	int femaleBuyersAverageAge;
	int maleBuyersMedianAge;
	int femaleBuyersMedianAge;
	Map<String, Integer> ageCohorts;
	Map<String, Integer> buyersDistricts;

	public void setMaleBuyersPercent(double maleBuyersPercent) {
		this.maleBuyersPercent = maleBuyersPercent;
	}

	public void setFemaleBuyersPercent(double femaleBuyersPercent) {
		this.femaleBuyersPercent = femaleBuyersPercent;
	}

	public void setMaleBuyersAverageAge(int maleBuyersAverageAge) {
		this.maleBuyersAverageAge = maleBuyersAverageAge;
	}

	public void setFemaleBuyersAverageAge(int femaleBuyersAverageAge) {
		this.femaleBuyersAverageAge = femaleBuyersAverageAge;
	}

	public void setMaleBuyersMedianAge(int maleBuyersMedianAge) {
		this.maleBuyersMedianAge = maleBuyersMedianAge;
	}

	public void setFemaleBuyersMedianAge(int femaleBuyersMedianAge) {
		this.femaleBuyersMedianAge = femaleBuyersMedianAge;
	}

	public void setAgeCohorts(Map<String, Integer> ageCohorts) {
		this.ageCohorts = ageCohorts;
	}

	public void setBuyersDistricts(Map<String, Integer> buyersDistricts) {
		this.buyersDistricts = buyersDistricts;
	}
}
