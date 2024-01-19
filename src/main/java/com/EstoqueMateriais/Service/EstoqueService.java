package com.EstoqueMateriais.Service;

import java.util.List;

import com.EstoqueMateriais.Entity.EstoqueMateriais;

public interface EstoqueService {
	
	
	EstoqueMateriais salvarEstoqueNota (EstoqueMateriais nf);
	
	List<EstoqueMateriais> listarNF();
	
	List<EstoqueMateriais> filtrarDataEstoque(String filtro);
	
}
