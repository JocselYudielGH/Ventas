package com.banregio.next.actividadback.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.actividadback.remoto.dto.VentasDto;
import com.banregio.next.actividadback.remoto.service.ProductoRemotoService;

@Service
public class RemotoProductoService {
	@Autowired
	private ProductoRemotoService productoRemotoService;
	
	public List<VentasDto> findProducto(){
		
		return productoRemotoService.findProducto();
		
	}
}
