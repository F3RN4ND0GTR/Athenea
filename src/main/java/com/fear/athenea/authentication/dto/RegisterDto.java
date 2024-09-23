package com.fear.athenea.authentication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {

	@NotNull
	@NotBlank
	private String usuario;
	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@NotBlank
	private String role;
	@NotNull
	@NotBlank
	private String municipio;
	@NotNull
	@NotBlank
	private String distrito;
	@NotNull
	@NotBlank
	private String seccion;
	@Size(min = 1, max = 1)
	@NotNull
	@NotBlank
	private String mesa;

}
