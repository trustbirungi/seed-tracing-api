package io.trustbirungi.seedTracingApi.controller;

import java.util.List;

import io.trustbirungi.seedTracingApi.dto.UserDto;
import io.trustbirungi.seedTracingApi.entity.User;
import io.trustbirungi.seedTracingApi.response.UserCreationResponse;
import io.trustbirungi.seedTracingApi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public UserCreationResponse createUser(@RequestBody User user) {
		user.setId(0);

		UserDto userDto = new UserDto();

		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setActive(user.getActive());
		userDto.setRoles(user.getRoles());
		userDto.setPermissions(user.getPermissions());

		userService.createUser(user);

		UserCreationResponse userCreationResponse =
				new UserCreationResponse(HttpStatus.CREATED.value(), "User "
						+ "created successfully!", System.currentTimeMillis()
						, userDto);

		return userCreationResponse;
	}

	@GetMapping(produces = "application/json")
	public List<User> getUsers() {
		return userService.getUsers();
	}
}
