package com.fear.athenea.authentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fear.athenea.entity.Municipio;
import com.fear.athenea.entity.MunicipioCensal;

public interface MunicipioCensalRepository extends JpaRepository<MunicipioCensal, Long> {
	
	@Query("select mc from MunicipioCensal mc where mc.municipio.id = :municipio.id and mc.distrito = :distrito and mc.seccion = :seccion and mc.mesa = ':mesa'")
	public Optional<MunicipioCensal> findByMunicipioAndDistritoAndSeccionAndMesa(@Param("municipio") Municipio municipio, 
			@Param("distrito") Integer distrito,
			@Param("seccion") Integer seccion,
			@Param("mesa") String mesa);

}
