package com.banregio.next.actividadback.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banregio.next.actividadback.app.domain.entity.Ejemplo;
import com.banregio.next.actividadback.app.service.RemotoProductoService;
import com.banregio.next.actividadback.remoto.dto.VentasDto;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/remoto-ventas")
public class RemotoProductoController {
	
	@Autowired
	private RemotoProductoService productoRemotoService;
	
	@ApiOperation(value = "Buscar todas las clasificaciones remotas", notes = "Devuelve un listado de todos los registros.")
	@GetMapping(value = "/")
	public List<VentasDto> findAllProducto() {
		return productoRemotoService.findProducto();
	}
	
}
