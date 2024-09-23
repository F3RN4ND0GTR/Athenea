package com.fear.athenea.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fear.athenea.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
