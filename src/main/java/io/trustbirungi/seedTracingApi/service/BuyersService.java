package io.trustbirungi.seedTracingApi.service;

import java.util.List;

import io.trustbirungi.seedTracingApi.entity.Buyers;

public interface BuyersService {

	/**
	 *
	 * @return a list of all buyers
	 */
	public List<Buyers> getBuyers();

}
