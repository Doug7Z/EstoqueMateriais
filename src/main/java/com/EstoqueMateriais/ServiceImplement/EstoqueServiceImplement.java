package com.EstoqueMateriais.ServiceImplement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EstoqueMateriais.Entity.EstoqueMateriais;
import com.EstoqueMateriais.Repository.EstoqueRepository;
import com.EstoqueMateriais.Service.EstoqueService;

@Service
public class EstoqueServiceImplement implements EstoqueService {

	@Autowired
	EstoqueRepository estoqueRepository;
	
	public EstoqueMateriais salvarEstoqueNota (EstoqueMateriais nf) {
		return estoqueRepository.save(nf);
	}
	
	public List<EstoqueMateriais> listarNF(){
		return estoqueRepository.findAll();
	}
	
	public List<EstoqueMateriais> filtrarDataEstoque(String filtro){
		List<EstoqueMateriais> lista = new ArrayList<>();
		
		if(filtro !=null && !filtro.isEmpty()) {
			List<EstoqueMateriais> listaTudo = estoqueRepository.findAll();
			for(EstoqueMateriais listagem : listaTudo ) {
					if(listagem.getDataAtual().contains(filtro)) {
						lista.add(listagem);
					}
			}
		}else {
			lista.addAll(listarNF());
		}
			return lista;
		}
	
	
}
