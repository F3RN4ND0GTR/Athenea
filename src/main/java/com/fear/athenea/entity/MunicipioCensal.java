package com.fear.athenea.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MUNICIPIO_CENSAL")
@Getter
@Setter
@NoArgsConstructor
public class MunicipioCensal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ID_MUNICIPIO")
	@NotNull
	private Municipio municipio;
	@Column(name = "DISTRITO", nullable = false)
	@NotNull
	private Integer distrito;
	@Column(name = "SECCION", nullable = false)
	@NotNull
	private Integer seccion;
	@Column(name = "MESA", nullable = false)
	@NotNull
	@NotBlank
	private String mesa;
	@OneToMany(mappedBy = "municipioCensal")
	private List<User> userList;

}
