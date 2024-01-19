package com.EstoqueMateriais.Service;

import java.util.List;

import com.EstoqueMateriais.Entity.Materiais;

public interface CadastroService {

	Materiais salvarItens (Materiais materiais);
	Materiais buscarId (Long id);
	Materiais encontrarItemPorCodigo (String codigo);
	void atualizarMaterial (String codigo, Materiais novosMateriais);
	void deletarMaterial(String codigo);
	List<Materiais> listarMateriais();
	String nomeItemPorCodigo (String codigo);
	List<Materiais> filtrarMateriais(String filtro);
	
}
