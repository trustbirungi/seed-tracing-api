package io.trustbirungi.seedTracingApi.controller;

import java.util.List;

import io.trustbirungi.seedTracingApi.entity.Buyers;
import io.trustbirungi.seedTracingApi.service.BuyersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BuyersController {
	@Autowired
	private BuyersService buyersService;

	@GetMapping(value = "/buyers", produces = "application/json")
	public List<Buyers> getBuyers() {
		List<Buyers> buyersList = buyersService.getBuyers();

		return buyersList;
	}
}
