package com.fear.athenea.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(unique = true)
	private String usuario;
	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ID_ROL")
	private Rol rol;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ID_MUNICIPIO_CENSAL")
	@NotNull
	private MunicipioCensal municipioCensal;

}
