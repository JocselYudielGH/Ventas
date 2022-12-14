package com.banregio.next.actividadback.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.actividadback.app.domain.entity.Ejemplo;
import com.banregio.next.actividadback.app.exception.TestEjemploException;
import com.banregio.next.actividadback.app.facade.EjemplosFacade;
import com.banregio.next.actividadback.remoto.dto.CorreoPersona;
import com.banregio.next.actividadback.remoto.dto.UsuarioSibamex;
import com.banregio.next.actividadback.remoto.service.SibamexSoporteService;
import com.banregio.next.postgre.service.PostgreService;

/**
 * Ejemplo de Servicio para un CRUD. 
 * @author ${user}
 * @since ${date}
 */
@Service
public class EjemplosService extends PostgreService<Ejemplo>{
	
	@Autowired
	private SibamexSoporteService usuariosService; 

	@Autowired
	public EjemplosService(EjemplosFacade facade) {
		super(facade);
	}
	
	@Override
	public List<Ejemplo> findAll() {
		return super.findAll();
		
	}
	
	@Override
	public Ejemplo findById(Long id) {
		usuariosService.consultaCorreos(new CorreoPersona());
		UsuarioSibamex us = usuariosService.usuarioById();
		return super.findById(id);
	}
	
	public Ejemplo findUsuario(Long id, String brm){
		Ejemplo ejemplo = super.findById(id);
		UsuarioSibamex user = usuariosService.findByBrm(brm);
		if(null!=user) {
			throw new TestEjemploException();
		}
		ejemplo.setUsuario(user);
		return ejemplo;
	}
}