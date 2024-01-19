package com.EstoqueMateriais.ServiceImplement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EstoqueMateriais.Entity.Materiais;
import com.EstoqueMateriais.Repository.MaterialRepository;
import com.EstoqueMateriais.Service.CadastroService;

@Service
public class CadastroServiceImplement implements CadastroService{
	
	@Autowired
	MaterialRepository materialRepository;
	
	
	public Materiais salvarItens(Materiais materiais) {
		return materialRepository.save(materiais);
	}
	
	public Materiais buscarId (Long id) {
		return materialRepository.findById(id).get();
	}
	
	public Materiais encontrarItemPorCodigo (String codigo) {
		return materialRepository.findByCodigo(codigo);
		
	}
	
	public void atualizarMaterial (String codigo, Materiais novosMateriais) {
		Materiais material = materialRepository.findByCodigo(codigo);
		if (material!=null) {
			material.setCodigo(novosMateriais.getCodigo());
			material.setItem(novosMateriais.getItem());
			material.setDescricao(novosMateriais.getDescricao());
			material.setUnidade(novosMateriais.getUnidade());
			material.setEstoque(novosMateriais.getEstoque());
			material.setCodNcm(novosMateriais.getCodNcm());
			material.setObservacao(novosMateriais.getObservacao());
		}
		materialRepository.save(material);
	}
	
	
	
	public void deletarMaterial(String codigo) {	
		Materiais material = materialRepository.findByCodigo(codigo);
		if(material != null) {
			Long id = material.getId();
			materialRepository.deleteById(id);
		}
		
	}
	
	public String nomeItemPorCodigo (String codigo) {
		String nome = materialRepository.findByCodigo(codigo).getItem();
		return nome;
	}
	
	public List<Materiais> listarMateriais(){
		return materialRepository.findAll();
	}
	
	
	public List<Materiais> filtrarMateriais(String filtro) {
	    List<Materiais> materiaisFiltro = new ArrayList<>();

	    if (filtro != null && !filtro.isEmpty()) {
	        List<Materiais> listaDeMateriais = materialRepository.findAll();
	        for (Materiais material : listaDeMateriais) {
	            String codigo = material.getCodigo() != null ? material.getCodigo().toLowerCase() : "";
	            String codNcm = material.getCodNcm() != null ? material.getCodNcm().toLowerCase() : "";
	            String item = material.getItem() != null ? material.getItem().toLowerCase() : "";
	            String descricao = material.getDescricao() != null ? material.getDescricao().toLowerCase() : "";

	            if (codigo.contains(filtro) || codNcm.contains(filtro) || item.contains(filtro) || descricao.contains(filtro)) {
	                materiaisFiltro.add(material);
	            }
	        }
	    } else {
	        materiaisFiltro.addAll(listarMateriais());
	    }
	    return materiaisFiltro;
	}
	
}
