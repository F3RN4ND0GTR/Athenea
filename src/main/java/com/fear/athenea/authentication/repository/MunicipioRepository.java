package com.fear.athenea.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fear.athenea.entity.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

}
