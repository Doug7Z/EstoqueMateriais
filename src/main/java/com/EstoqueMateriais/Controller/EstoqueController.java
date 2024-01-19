package com.EstoqueMateriais.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.EstoqueMateriais.Entity.EstoqueMateriais;
import com.EstoqueMateriais.Entity.Materiais;
import com.EstoqueMateriais.Service.CadastroService;
import com.EstoqueMateriais.Service.EstoqueService;

@Controller
public class EstoqueController {

	@Autowired
	EstoqueService estoqueService;
	
	@Autowired
	CadastroService cadastroService;
	
	@GetMapping(value = "/estoqueEntrada")
	public ModelAndView paginaEstoque(@RequestParam(name = "filtroAlterar", required = false ) String filtroAlterar) {
		ModelAndView model = new ModelAndView("EstoqueEntrada");	
		List<Materiais> material;
		if(filtroAlterar !=null && !filtroAlterar.isEmpty()) {
			material = cadastroService.filtrarMateriais(filtroAlterar);
		}else {
			material = cadastroService.listarMateriais();
		}
		model.addObject("listaMateriais", material);
		return model;
	}
	
	@GetMapping(value = "/lista/Entrada/EstoqueNF")
	public ModelAndView listarNotas(@RequestParam(name = "filtroData", required = false)String filtroData) {
		ModelAndView model = new ModelAndView("listaNF");
		List<EstoqueMateriais> nfs;
		
		if(filtroData !=null && !filtroData.isEmpty()) {
			nfs = estoqueService.filtrarDataEstoque(filtroData);
		} else {
			nfs = estoqueService.listarNF();
		}
		
		model.addObject("listaNF", nfs);
		return model;
	}
	
	@GetMapping(value = "/estoqueEntrada/NF/Estoque/{codigo}")
	public ModelAndView cadastrarNFEstoque(@PathVariable String codigo) {
		ModelAndView model = new ModelAndView("NfCadastro");
		Materiais material = cadastroService.encontrarItemPorCodigo(codigo);
		model.addObject("material",material);
		return model;
	
	}
	
	@PostMapping(value = "/estoqueEntrada/NF/Estoque/{codigo}")
	public String salvarNF(@PathVariable String codigo , 
			@ModelAttribute EstoqueMateriais estoqueMateriais) {
		
		Materiais material = cadastroService.encontrarItemPorCodigo(codigo);
		
		int estoqueExistente = material.getEstoque();		
		int entradaEstoque = estoqueMateriais.getQtdEstoqueEntrada();
		int novoEstoque = estoqueExistente + entradaEstoque;
		material.setEstoque(novoEstoque);
				
		cadastroService.salvarItens(material);
		
		estoqueService.salvarEstoqueNota(estoqueMateriais);
		return "redirect:/estoqueEntrada";
	}
	
	@GetMapping(value = "/Estoque/NF/Estoque/alterar/")
	public ModelAndView InicialAlterarEstoque(@RequestParam(name = "filtroAlterar", required = false)String filtroAlterar) {
		ModelAndView model = new ModelAndView("EstoqueAlterar");
		List<Materiais> lista;
		
		if(filtroAlterar !=null && !filtroAlterar.isEmpty()) {
			lista = cadastroService.filtrarMateriais(filtroAlterar);
		}else {
			lista = cadastroService.listarMateriais();
		}
		
		
		model.addObject("materialAlterar", lista);
		return model;
	}
	
	@GetMapping(value = "/estoqueEntrada/NF/Estoque/alterar/{codigo}")
	public ModelAndView corrigirEstoque(@PathVariable String codigo) {
		ModelAndView model = new ModelAndView("alterarEstoque");
		Materiais material = cadastroService.encontrarItemPorCodigo(codigo);
		model.addObject("materialAlterar", material);
		return model;
	}
	
	
	@PutMapping(value = "/estoqueEntrada/NF/Estoque/alterar/{codigo}")
	public String alterarEstoque(@PathVariable String codigo , 
			@ModelAttribute Materiais novosMateriais) {
		cadastroService.atualizarMaterial(codigo, novosMateriais);
		return "redirect:/Estoque/NF/Estoque/alterar/";
	}
	
	
}
