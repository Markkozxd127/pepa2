package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Rol_OpcionesDto;
import com.example.demo.entity.Opciones;
import com.example.demo.entity.Rol;
import com.example.demo.entity.Rol_Opciones;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RolRepository;
import com.example.demo.repository.OpcionesRepository;

import com.example.demo.repository.Rol_OpcionesRepository;
import com.example.demo.service.Rol_OpcionesService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Rol_OpcionesServiceImpl implements Rol_OpcionesService<Rol_Opciones>{
	
	@Autowired
	private Rol_OpcionesRepository rol_OpcionesRepository;

	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private OpcionesRepository opcionesRepository;
	
	


	@Override
	public Rol_Opciones update(int id, Rol_OpcionesDto rol_OpcionesDto ) {
	    Optional<Rol_Opciones> optionalRol_Opciones = rol_OpcionesRepository.findById(id);

	    if (optionalRol_Opciones.isPresent()) {
	    	Rol_Opciones rol_Opciones = optionalRol_Opciones.get();
	    	rol_Opciones.setRol(rolRepository.findById(rol_OpcionesDto.getRol()).orElse(null));
	    	rol_Opciones.setOpciones(opcionesRepository.findById(rol_OpcionesDto.getOpciones()).orElse(null));
	        return rol_OpcionesRepository.save(rol_Opciones);
	    } else {
	        throw new ResourceNotFoundException("rol_Opciones no encontrado con ID: " + id);
	    }
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		rol_OpcionesRepository.deleteById(id);
	}

	@Override
	public Optional<Rol_Opciones> read(int id) {
		// TODO Auto-generated method stub
		return rol_OpcionesRepository.findById(id);
	}

	@Override
	public List<Rol_Opciones> readAll() {
		// TODO Auto-generated method stub
		return rol_OpcionesRepository.findAll();
	}

	@Override
	public Rol_Opciones guardarRol_Opciones(Rol_OpcionesDto rol_OpcionesDto) {

	    Rol rol = rolRepository.findById(rol_OpcionesDto.getRol())
	            .orElseThrow(() -> new EntityNotFoundException("Rol not found"));
	    Opciones opciones = opcionesRepository.findById(rol_OpcionesDto.getOpciones())
	            .orElseThrow(() -> new EntityNotFoundException("Opcione not found"));
	    Rol_Opciones rol_Opciones = new Rol_Opciones();
	
	    //fora	
	    rol_Opciones.setRol(rol);
	    //fora	
	    rol_Opciones.setOpciones(opciones);
	    
	    return rol_OpcionesRepository.save(rol_Opciones);
	}
	
}