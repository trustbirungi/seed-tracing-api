package io.trustbirungi.seedTracingApi.service;

import java.util.List;

import io.trustbirungi.seedTracingApi.entity.User;

public interface UserService {

	/**
	 * Creates a new user.
	 */
	void createUser(User user);

	/**
	 *
	 * @return a list of all users
	 */
	List<User> getUsers();
}
