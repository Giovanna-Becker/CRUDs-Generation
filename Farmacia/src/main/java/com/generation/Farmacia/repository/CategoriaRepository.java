package com.generation.Farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.Farmacia.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

	public List<CategoriaModel> findAllByNomeCategoriaContainingIgnoreCase(@Param("nomeCategoria") String nomeCategoria );	
}
