package io.trustbirungi.seedTracingApi.service;

import java.util.List;

import io.trustbirungi.seedTracingApi.entity.Buyers;
import io.trustbirungi.seedTracingApi.repository.BuyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyersServiceImpl implements BuyersService {
	@Autowired
	private BuyersRepository buyersRepository;

	public List<Buyers> getBuyers() {
		return (List<Buyers>) buyersRepository.findAll();
	}

}
