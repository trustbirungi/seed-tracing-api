package io.trustbirungi.seedTracingApi.repository;

import io.trustbirungi.seedTracingApi.entity.Buyers;
import org.springframework.data.repository.CrudRepository;

public interface BuyersRepository extends CrudRepository<Buyers, String> {
}
