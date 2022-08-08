package com.generation.Farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.Farmacia.model.CategoriaModel;
import com.generation.Farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll (){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/nomecategoria/{nomeCategoria}")
	public ResponseEntity<List<CategoriaModel>> GetByName(@PathVariable String nomeCategoria){
		return ResponseEntity.ok(categoriaRepository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> GetById(@PathVariable Long id){
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> post(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> put(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}
	
}
