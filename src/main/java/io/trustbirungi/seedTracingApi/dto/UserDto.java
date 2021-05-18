package io.trustbirungi.seedTracingApi.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class UserDto {
	private String username;
	private String password;
	private int active;
	private String roles;
	private String permissions;
}
