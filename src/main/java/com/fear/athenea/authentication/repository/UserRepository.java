package com.fear.athenea.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fear.athenea.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User where u.usuario = ':usuario' and u.password = ':password'")
	User findByUsuarioAndPassword(@Param("usuario") String usuario, @Param("password") String password);

}
