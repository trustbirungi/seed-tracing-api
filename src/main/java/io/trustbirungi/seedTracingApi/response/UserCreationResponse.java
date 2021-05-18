package io.trustbirungi.seedTracingApi.response;

import io.trustbirungi.seedTracingApi.dto.UserDto;
import lombok.Data;

@Data
public class UserCreationResponse {
	private int status;
	private String message;
	private long timestamp;
	private UserDto userDto;

	public UserCreationResponse(int status, String message, long timestamp,
	                            UserDto userDto) {
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
		this.userDto = userDto;
	}
}
