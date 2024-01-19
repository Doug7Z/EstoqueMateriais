package com.EstoqueMateriais.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EstoqueMateriais.Entity.EstoqueMateriais;
import com.EstoqueMateriais.Entity.Materiais;

public interface EstoqueRepository extends JpaRepository<EstoqueMateriais , Long>{


	
}
