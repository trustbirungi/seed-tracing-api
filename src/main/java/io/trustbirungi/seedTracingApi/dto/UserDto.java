package io.trustbirungi.seedTracingApi.dto;

//import javax.persistence.Column;

import lombok.Data;

@Data
public class UserDto {
	private String username;
	private String password;
	private int active;
	private String roles;
	private String permissions;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
}
