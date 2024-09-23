package com.fear.athenea.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MUNICIPIO")
@NoArgsConstructor
@Getter
@Setter
public class Municipio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NAME")
	@NotNull
	@NotBlank
	private String name;
	@Column(name = "NAME_ALT")
	private String nameAlt;
	@Column(name = "CP")
	@NotNull
	@NotBlank
	private Long cp;
	@OneToMany(mappedBy = "municipio")
	private List<MunicipioCensal> municipioCensalList;
}
