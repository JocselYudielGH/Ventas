package com.example.demo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.services.ProductoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@ApiOperation(value = "Crea todas las Producto.", notes = "Devuelve un listado con todas las Producto.")
	@PostMapping
	private ResponseEntity<Producto>  guardar (@RequestBody Producto producto){
		Producto temporal = productoService.create(producto);
		
		try {
			return ResponseEntity.created(new URI("/api/producto"+temporal.getIdProducto())).body(temporal);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@ApiOperation(value = "Busca todas las Producto.", notes = "Devuelve un listado con todas las Producto.")
	@GetMapping
	private ResponseEntity<List<Producto>> listarTodasLasProducto(){
		
		return ResponseEntity.ok(productoService.getAllProducto());
	}
	
	@ApiOperation(value = "Busca Producto por id.", notes = "Devuelve un listado la Producto.")
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Producto>> listarCategorias (@PathVariable("id") Long id){
		
		return ResponseEntity.ok(productoService.findById(id));
	}
	
	@ApiOperation(value = "Elinina todas las Producto por id.", notes = "Elinina las Producto.")
	@DeleteMapping
	private ResponseEntity<Void> ElininarProducto (@RequestBody Producto producto){
		productoService.delete(producto);
		return ResponseEntity.ok().build();
	}
}
