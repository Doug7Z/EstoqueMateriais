package com.EstoqueMateriais.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EstoqueMateriais.Entity.Materiais;

public interface MaterialRepository extends JpaRepository<Materiais, Long>{
	
	Materiais findByCodigo (String codigo);

}
