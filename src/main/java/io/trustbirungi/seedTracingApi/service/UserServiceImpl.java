package io.trustbirungi.seedTracingApi.service;

import java.util.List;

import io.trustbirungi.seedTracingApi.entity.User;
import io.trustbirungi.seedTracingApi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * Creates a new user.
	 */
	@Override
	public void createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	/**
	 * @return a list of all users
	 */
	@Override
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}
}
