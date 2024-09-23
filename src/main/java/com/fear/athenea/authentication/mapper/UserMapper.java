package com.fear.athenea.authentication.mapper;

import java.util.Optional;

import com.fear.athenea.authentication.dto.UserDto;
import com.fear.athenea.authentication.repository.MunicipioCensalRepository;
import com.fear.athenea.authentication.repository.MunicipioRepository;
import com.fear.athenea.authentication.repository.RolRepository;
import com.fear.athenea.authentication.repository.UserRepository;
import com.fear.athenea.entity.Municipio;
import com.fear.athenea.entity.MunicipioCensal;
import com.fear.athenea.entity.Rol;
import com.fear.athenea.entity.User;

public class UserMapper {
	
	private UserRepository userRepository;
	private RolRepository rolRepository;
	private MunicipioRepository municipioRepository;
	private MunicipioCensalRepository municipioCensalRepository;
	
	public UserMapper(UserRepository userRepository, RolRepository rolRepository, MunicipioRepository municipioRepository, MunicipioCensalRepository municipioCensalRepository) {
		this.userRepository = userRepository;
		this.rolRepository = rolRepository;
		this.municipioRepository = municipioRepository;
		this.municipioCensalRepository = municipioCensalRepository;
	}
	
	public User dtoToEntity(UserDto dto) {
		User user = null;
		
		if(dto != null) {
			try {
				user = userRepository.findByUsuarioAndPassword(dto.getUsuario(), dto.getPassword());
				if(user == null) {
					//no existe
					user = new User();
					user.setUsuario(dto.getUsuario());
					user.setPassword(dto.getPassword());
					Optional<Rol> rol = rolRepository.findById(Long.valueOf(dto.getRole()));
					user.setRol(rol.get());
					Optional<Municipio> municipio = municipioRepository.findById(Long.valueOf(dto.getMunicipio()));
					Optional<MunicipioCensal> municipioCensal = municipioCensalRepository.findByMunicipioAndDistritoAndSeccionAndMesa(municipio.get(), Integer.valueOf(dto.getDistrito()) , Integer.valueOf(dto.getSeccion()), dto.getMesa());
					user.setMunicipioCensal(municipioCensal.get());
				}
			} catch (Exception e) {
				
			}
		}
		
		return user;
	}
	
	public UserDto EntityToDto(User user) {
		
		UserDto userDto = new UserDto();
		userDto.setUsuario(user.getUsuario());
		userDto.setPassword(user.getPassword());
		userDto.setMunicipio(user.getMunicipioCensal().getMunicipio().getId().toString());
		userDto.setDistrito(user.getMunicipioCensal().getDistrito().toString());
		userDto.setSeccion(user.getMunicipioCensal().getSeccion().toString());
		userDto.setMesa(user.getMunicipioCensal().getMesa());
		userDto.setRole(user.getRol().getId().toString());
		
		return userDto;
		
	}

}
