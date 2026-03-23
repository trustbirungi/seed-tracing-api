package io.trustbirungi.seedTracingApi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import io.trustbirungi.seedTracingApi.dto.UserDto;
import io.trustbirungi.seedTracingApi.entity.User;
import io.trustbirungi.seedTracingApi.response.UserCreationResponse;
import io.trustbirungi.seedTracingApi.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserController Unit Tests")
class UserControllerTest {

	@Mock
	private UserService userService;

	private UserController userController;

	@BeforeEach
	void setUp() {
		userController = new UserController(userService);
	}

	@Nested
	@DisplayName("CreateUser Method Tests")
	class CreateUserTests {

		@Test
		@DisplayName("Should create user successfully with valid data")
		void testCreateUserSuccess() {
			// Arrange
			User inputUser = new User("john_doe", "password123", "ROLE_USER", "READ");
			inputUser.setId(5); // This should be overridden to 0
			inputUser.setActive(1);

			ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

			// Act
			UserCreationResponse result = userController.createUser(inputUser);

			// Assert
			assertNotNull(result, "Response should not be null");
			assertEquals(HttpStatus.CREATED.value(), result.getStatus(), "Status should be 201");
			assertEquals("User created successfully!", result.getMessage(), "Message should be correct");
			assertNotNull(result.getTimestamp(), "Timestamp should not be null");
			assertTrue(result.getTimestamp() > 0, "Timestamp should be positive");

			UserDto userDto = result.getUserDto();
			assertNotNull(userDto, "UserDto should not be null");
			assertEquals("john_doe", userDto.getUsername(), "Username should match");
			assertEquals("password123", userDto.getPassword(), "Password should match");
			assertEquals(1, userDto.getActive(), "Active should be 1");
			assertEquals("ROLE_USER", userDto.getRoles(), "Roles should match");
			assertEquals("READ", userDto.getPermissions(), "Permissions should match");

			// Verify service was called with user that has ID set to 0
			verify(userService, times(1)).createUser(userCaptor.capture());
			User capturedUser = userCaptor.getValue();
			assertEquals(0, capturedUser.getId(), "ID should be set to 0");
			assertEquals("john_doe", capturedUser.getUsername(), "Username should match");
			assertEquals("password123", capturedUser.getPassword(), "Password should match");
		}

		@Test
		@DisplayName("Should create user with multiple roles and permissions")
		void testCreateUserWithMultipleRolesAndPermissions() {
			// Arrange
			User inputUser = new User("admin_user", "securePass", "ROLE_ADMIN,ROLE_USER", "READ,WRITE,DELETE");

			// Act
			UserCreationResponse result = userController.createUser(inputUser);

			// Assert
			assertNotNull(result, "Response should not be null");
			assertEquals(HttpStatus.CREATED.value(), result.getStatus(), "Status should be 201");

			UserDto userDto = result.getUserDto();
			assertNotNull(userDto, "UserDto should not be null");
			assertEquals("admin_user", userDto.getUsername(), "Username should match");
			assertEquals("securePass", userDto.getPassword(), "Password should match");
			assertEquals("ROLE_ADMIN,ROLE_USER", userDto.getRoles(), "Roles should match");
			assertEquals("READ,WRITE,DELETE", userDto.getPermissions(), "Permissions should match");

			// Verify service was called
			ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
			verify(userService, times(1)).createUser(userCaptor.capture());
			User capturedUser = userCaptor.getValue();
			assertEquals(0, capturedUser.getId(), "ID should be set to 0");
		}

		@Test
		@DisplayName("Should create user with empty roles and permissions")
		void testCreateUserWithEmptyRolesAndPermissions() {
			// Arrange
			User inputUser = new User("basic_user", "password", "", "");

			// Act
			UserCreationResponse result = userController.createUser(inputUser);

			// Assert
			assertNotNull(result, "Response should not be null");
			assertEquals(HttpStatus.CREATED.value(), result.getStatus(), "Status should be 201");

			UserDto userDto = result.getUserDto();
			assertNotNull(userDto, "UserDto should not be null");
			assertEquals("basic_user", userDto.getUsername(), "Username should match");
			assertEquals("password", userDto.getPassword(), "Password should match");
			assertEquals("", userDto.getRoles(), "Roles should be empty");
			assertEquals("", userDto.getPermissions(), "Permissions should be empty");

			// Verify service was called
			verify(userService, times(1)).createUser(any(User.class));
		}

		@Test
		@DisplayName("Should create user with special characters in username")
		void testCreateUserWithSpecialCharacters() {
			// Arrange
			User inputUser = new User("user@test.com", "pass_word!", "ROLE_USER", "READ");

			// Act
			UserCreationResponse result = userController.createUser(inputUser);

			// Assert
			assertNotNull(result, "Response should not be null");
			assertEquals(HttpStatus.CREATED.value(), result.getStatus(), "Status should be 201");

			UserDto userDto = result.getUserDto();
			assertNotNull(userDto, "UserDto should not be null");
			assertEquals("user@test.com", userDto.getUsername(), "Username should match");
			assertEquals("pass_word!", userDto.getPassword(), "Password should match");

			// Verify service was called
			verify(userService, times(1)).createUser(any(User.class));
		}

		@Test
		@DisplayName("Should handle user creation with null fields")
		void testCreateUserWithNullFields() {
			// Arrange
			User inputUser = new User(null, null, null, null);

			// Act
			UserCreationResponse result = userController.createUser(inputUser);

			// Assert
			assertNotNull(result, "Response should not be null");
			assertEquals(HttpStatus.CREATED.value(), result.getStatus(), "Status should be 201");

			UserDto userDto = result.getUserDto();
			assertNotNull(userDto, "UserDto should not be null");
			assertNull(userDto.getUsername(), "Username should be null");
			assertNull(userDto.getPassword(), "Password should be null");
			assertNull(userDto.getRoles(), "Roles should be null");
			assertNull(userDto.getPermissions(), "Permissions should be null");

			// Verify service was called
			verify(userService, times(1)).createUser(any(User.class));
		}

		@Test
		@DisplayName("Should handle service exception during user creation")
		void testCreateUserServiceThrowsException() {
			// Arrange
			User inputUser = new User("test_user", "password", "ROLE_USER", "READ");
			doThrow(new RuntimeException("Database error")).when(userService).createUser(any(User.class));

			// Act & Assert
			assertThrows(RuntimeException.class, () -> userController.createUser(inputUser),
					"Should throw RuntimeException when service fails");
			verify(userService, times(1)).createUser(any(User.class));
		}

		@Test
		@DisplayName("Should create inactive user")
		void testCreateUserInactive() {
			// Arrange
			User inputUser = new User("inactive_user", "password", "ROLE_USER", "READ");
			inputUser.setActive(0);

			// Act
			UserCreationResponse result = userController.createUser(inputUser);

			// Assert
			assertNotNull(result, "Response should not be null");
			UserDto userDto = result.getUserDto();
			assertNotNull(userDto, "UserDto should not be null");
			assertEquals(0, userDto.getActive(), "Active should be 0");

			// Verify service was called
			verify(userService, times(1)).createUser(any(User.class));
		}

		@Test
		@DisplayName("Should override existing ID to 0")
		void testCreateUserOverridesExistingId() {
			// Arrange
			User inputUser = new User("test_user", "password", "ROLE_USER", "READ");
			inputUser.setId(999); // Set existing ID

			// Act
			userController.createUser(inputUser);

			// Assert - Verify that ID was set to 0 before calling service
			ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
			verify(userService, times(1)).createUser(userCaptor.capture());
			User capturedUser = userCaptor.getValue();
			assertEquals(0, capturedUser.getId(), "ID should be overridden to 0");
		}

	}

	@Nested
	@DisplayName("GetUsers Method Tests")
	class GetUsersTests {

		@Test
		@DisplayName("Should return list of users successfully")
		void testGetUsersSuccess() {
			// Arrange
			List<User> expectedUsers = new ArrayList<>();
			User user1 = new User("john_doe", "password123", "ROLE_USER", "READ");
			user1.setId(1);
			user1.setActive(1);
			expectedUsers.add(user1);

			User user2 = new User("jane_smith", "password456", "ROLE_ADMIN", "READ,WRITE");
			user2.setId(2);
			user2.setActive(1);
			expectedUsers.add(user2);

			when(userService.getUsers()).thenReturn(expectedUsers);

			// Act
			List<User> result = userController.getUsers();

			// Assert
			assertNotNull(result, "Users list should not be null");
			assertEquals(2, result.size(), "Should return 2 users");
			assertEquals("john_doe", result.get(0).getUsername(), "First user's username should be john_doe");
			assertEquals("jane_smith", result.get(1).getUsername(), "Second user's username should be jane_smith");
			assertEquals(1, result.get(0).getId(), "First user's ID should be 1");
			assertEquals(2, result.get(1).getId(), "Second user's ID should be 2");
			verify(userService, times(1)).getUsers();
		}

		@Test
		@DisplayName("Should return empty list when no users exist")
		void testGetUsersEmptyList() {
			// Arrange
			List<User> expectedUsers = new ArrayList<>();
			when(userService.getUsers()).thenReturn(expectedUsers);

			// Act
			List<User> result = userController.getUsers();

			// Assert
			assertNotNull(result, "Users list should not be null");
			assertTrue(result.isEmpty(), "Users list should be empty");
			assertEquals(0, result.size(), "Size should be 0");
			verify(userService, times(1)).getUsers();
		}

		@Test
		@DisplayName("Should return list with single user")
		void testGetUsersSingleUser() {
			// Arrange
			List<User> expectedUsers = new ArrayList<>();
			User user = new User("single_user", "password", "ROLE_USER", "READ");
			user.setId(1);
			expectedUsers.add(user);

			when(userService.getUsers()).thenReturn(expectedUsers);

			// Act
			List<User> result = userController.getUsers();

			// Assert
			assertNotNull(result, "Users list should not be null");
			assertEquals(1, result.size(), "Should return 1 user");
			assertEquals("single_user", result.get(0).getUsername());
			assertEquals(1, result.get(0).getId());
			verify(userService, times(1)).getUsers();
		}

		@Test
		@DisplayName("Should return large list of users")
		void testGetUsersLargeList() {
			// Arrange
			List<User> expectedUsers = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				User user = new User("user" + i, "password" + i, "ROLE_USER", "READ");
				user.setId(i + 1);
				expectedUsers.add(user);
			}
			when(userService.getUsers()).thenReturn(expectedUsers);

			// Act
			List<User> result = userController.getUsers();

			// Assert
			assertNotNull(result, "Users list should not be null");
			assertEquals(1000, result.size(), "Should return 1000 users");
			assertEquals("user0", result.get(0).getUsername());
			assertEquals("user999", result.get(999).getUsername());
			verify(userService, times(1)).getUsers();
		}

		@Test
		@DisplayName("Should handle users with null fields")
		void testGetUsersWithNullFields() {
			// Arrange
			List<User> expectedUsers = new ArrayList<>();
			User user = new User(null, null, null, null);
			user.setId(1);
			expectedUsers.add(user);

			when(userService.getUsers()).thenReturn(expectedUsers);

			// Act
			List<User> result = userController.getUsers();

			// Assert
			assertNotNull(result, "Users list should not be null");
			assertEquals(1, result.size(), "Should return 1 user");
			assertNull(result.get(0).getUsername(), "Username should be null");
			assertNull(result.get(0).getPassword(), "Password should be null");
			assertNull(result.get(0).getRoles(), "Roles should be null");
			assertNull(result.get(0).getPermissions(), "Permissions should be null");
			verify(userService, times(1)).getUsers();
		}

		@Test
		@DisplayName("Should return users with special characters in usernames")
		void testGetUsersWithSpecialCharacters() {
			// Arrange
			List<User> expectedUsers = new ArrayList<>();
			User user = new User("user@test.com", "pass_word!", "ROLE_USER,ROLE_ADMIN", "READ,WRITE");
			user.setId(1);
			expectedUsers.add(user);

			when(userService.getUsers()).thenReturn(expectedUsers);

			// Act
			List<User> result = userController.getUsers();

			// Assert
			assertNotNull(result, "Users list should not be null");
			assertEquals(1, result.size(), "Should return 1 user");
			assertEquals("user@test.com", result.get(0).getUsername());
			assertEquals("pass_word!", result.get(0).getPassword());
			assertEquals("ROLE_USER,ROLE_ADMIN", result.get(0).getRoles());
			assertEquals("READ,WRITE", result.get(0).getPermissions());
			verify(userService, times(1)).getUsers();
		}

		@Test
		@DisplayName("Should handle service exception gracefully")
		void testGetUsersServiceThrowsException() {
			// Arrange
			when(userService.getUsers()).thenThrow(new RuntimeException("Database connection failed"));

			// Act & Assert
			assertThrows(RuntimeException.class, () -> userController.getUsers(),
					"Should throw RuntimeException when service fails");
			verify(userService, times(1)).getUsers();
		}

		@Test
		@DisplayName("Should return users with different active statuses")
		void testGetUsersWithDifferentActiveStatuses() {
			// Arrange
			List<User> expectedUsers = new ArrayList<>();
			User activeUser = new User("active_user", "password", "ROLE_USER", "READ");
			activeUser.setId(1);
			activeUser.setActive(1);
			expectedUsers.add(activeUser);

			User inactiveUser = new User("inactive_user", "password", "ROLE_USER", "READ");
			inactiveUser.setId(2);
			inactiveUser.setActive(0);
			expectedUsers.add(inactiveUser);

			when(userService.getUsers()).thenReturn(expectedUsers);

			// Act
			List<User> result = userController.getUsers();

			// Assert
			assertNotNull(result, "Users list should not be null");
			assertEquals(2, result.size(), "Should return 2 users");
			assertEquals(1, result.get(0).getActive(), "First user should be active");
			assertEquals(0, result.get(1).getActive(), "Second user should be inactive");
			verify(userService, times(1)).getUsers();
		}

	}

	@Nested
	@DisplayName("Controller Initialization Tests")
	class ControllerInitializationTests {

		@Test
		@DisplayName("Should initialize controller with non-null service")
		void testControllerInitialization() {
			// Assert
			assertNotNull(userController, "Controller should not be null");
			assertNotNull(userService, "Service mock should not be null");
		}

		@Test
		@DisplayName("Should handle multiple calls sequentially")
		void testMultipleSequentialCalls() {
			// Arrange
			when(userService.getUsers()).thenReturn(new ArrayList<>());

			// Act
			List<User> result1 = userController.getUsers();
			List<User> result2 = userController.getUsers();
			List<User> result3 = userController.getUsers();

			// Assert
			assertNotNull(result1);
			assertNotNull(result2);
			assertNotNull(result3);
			verify(userService, times(3)).getUsers();
		}

	}

}

