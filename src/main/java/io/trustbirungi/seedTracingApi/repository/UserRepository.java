package io.trustbirungi.seedTracingApi.repository;

import io.trustbirungi.seedTracingApi.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
