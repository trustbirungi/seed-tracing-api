package io.trustbirungi.seedTracingApi.controller;

import java.util.List;

import io.trustbirungi.seedTracingApi.dto.BuyersAnalysisDto;
import io.trustbirungi.seedTracingApi.entity.Buyers;
import io.trustbirungi.seedTracingApi.service.BuyersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/buyers")
@CrossOrigin
public class BuyersController {
	private final BuyersService buyersService;

	public BuyersController(BuyersService buyersService) {
		this.buyersService = buyersService;
	}

	@GetMapping(produces = "application/json")
	public List<Buyers> getBuyers() {
		List<Buyers> buyersList = buyersService.getBuyers();

		return buyersList;
	}

	@GetMapping(value = "/analysis", produces = "application/json")
	public BuyersAnalysisDto getBuyersAnalysis() {
		BuyersAnalysisDto buyersAnalysisDto = new BuyersAnalysisDto();

		buyersAnalysisDto.setMaleBuyersPercent(buyersService.getMaleBuyersPercent());
		buyersAnalysisDto.setFemaleBuyersPercent(buyersService.getFemaleBuyersPercent());
		buyersAnalysisDto.setMaleBuyersAverageAge(buyersService.getMaleBuyersAverageAge());
		buyersAnalysisDto.setFemaleBuyersAverageAge(buyersService.getFemaleBuyersAverageAge());
		buyersAnalysisDto.setMaleBuyersMedianAge(buyersService.getMaleBuyersMedianAge());
		buyersAnalysisDto.setFemaleBuyersMedianAge(buyersService.getFemaleBuyersMedianAge());
		buyersAnalysisDto.setAgeCohorts(buyersService.getAgeCohorts());
		buyersAnalysisDto.setBuyersDistricts(buyersService.getBuyersDistricts());

		return buyersAnalysisDto;
	}
}
