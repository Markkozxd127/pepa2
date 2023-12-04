package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Rol_OpcionesDto;
import com.example.demo.entity.Rol_Opciones;

public interface Rol_OpcionesService  <T>{
	
	Rol_Opciones guardarRol_Opciones(Rol_OpcionesDto rol_OpcionesDto);
	Rol_Opciones update(int id,Rol_OpcionesDto rol_OpcionesDto);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();

}	