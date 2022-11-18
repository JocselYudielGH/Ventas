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

import com.example.demo.model.Categoria;
import com.example.demo.services.CategoriaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@ApiOperation(value = "Crea todas las Categoria.", notes = "Devuelve un listado con todas las Categoria.")
	@PostMapping
	private ResponseEntity<Categoria>  guardar (@RequestBody Categoria categoria){
		Categoria temporal = categoriaService.create(categoria);
		
		try {
			return ResponseEntity.created(new URI("/api/categoria"+temporal.getIdCategoria())).body(temporal);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@ApiOperation(value = "Busca todas las Categoria.", notes = "Devuelve un listado con todas las Categoria.")
	@GetMapping
	private ResponseEntity<List<Categoria>> listarTodasLasCategoria(){
		
		return ResponseEntity.ok(categoriaService.getAllCategoria());
	}
	
	@ApiOperation(value = "Busca Categoria por id.", notes = "Devuelve un listado la Categoria.")
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Categoria>> listarCategorias (@PathVariable("id") Long id){
		
		return ResponseEntity.ok(categoriaService.findById(id));
	}
	
	@ApiOperation(value = "Elinina todas las Categoria por id.", notes = "Elinina las Categoria.")
	@DeleteMapping
	private ResponseEntity<Void> EliminarCategoria (@RequestBody Categoria categoria){
		categoriaService.delete(categoria);
		return ResponseEntity.ok().build();
	}
}
