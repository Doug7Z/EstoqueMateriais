package com.EstoqueMateriais.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.EstoqueMateriais.Entity.Materiais;
import com.EstoqueMateriais.Repository.MaterialRepository;
import com.EstoqueMateriais.Service.CadastroService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	CadastroService cadastroService;
	
	@GetMapping(value = "/inicio/Estoque")
	public ModelAndView paginaInicial(@RequestParam(name = "filtro", required = false) String filtro) {
	    ModelAndView model  = new ModelAndView("paginaInicialEstoque");
	    List<Materiais> lista;

	    if (filtro != null && !filtro.isEmpty()) {
	        lista = cadastroService.filtrarMateriais(filtro);
	    } else {
	        lista = cadastroService.listarMateriais();
	    }

	    model.addObject("materiais", lista);
	    return model;
	}

	
	@GetMapping(value = "/MaterialCadastro")
	public ModelAndView cadastro() {
		ModelAndView model  = new ModelAndView("CadastroEstoque");
		return model;
		
	}
		
	@PostMapping(value = "/MaterialCadastro")
	public String cadastrarItens(@Valid Materiais materiais, RedirectAttributes atributo){		
		
		if(materiais.getCodigo().isBlank() || materiais.getCodigo().isEmpty()) {
			atributo.addFlashAttribute("msgErroCadastroMaterial", "Erro! Campo Código em branco!");
			return "redirect:/MaterialCadastro";
		}
		
		if(materiais.getItem().isBlank() || materiais.getItem().isEmpty()) {
			atributo.addFlashAttribute("msgErroCadastroMaterial", "Erro! Campo Item em branco!");
			return "redirect:/MaterialCadastro";
		}
		
		cadastroService.salvarItens(materiais);
		return "redirect:/MaterialCadastro";
	}
	
	
	@GetMapping(value ="/Estoque/material/alterar")
	public ModelAndView paginaAlterar(@RequestParam(name = "filtroAlterar", required = false) String filtroAlterar) {
		ModelAndView model = new ModelAndView("listaAlterar");
		
		List<Materiais> lista;

	    if (filtroAlterar != null && !filtroAlterar.isEmpty()) {
	        lista = cadastroService.filtrarMateriais(filtroAlterar);
	    } else {
	        lista = cadastroService.listarMateriais();
	    }
		
		model.addObject("listagem", lista);
		return model;
	}
	
	@GetMapping(value = "/Estoque/material/alterar/{codigo}")
	public ModelAndView alterarItem(@PathVariable String codigo) {
		ModelAndView model = new ModelAndView("AlterarCadastroItem");
		Materiais material = cadastroService.encontrarItemPorCodigo(codigo);
		model.addObject("material", material);
		return model;
	}
	
	
	@PutMapping(value = "/Estoque/material/alterar/{codigo}")
	public String alterarDadosItem(@PathVariable String codigo, @ModelAttribute Materiais novosMateriais) {
		cadastroService.atualizarMaterial(codigo, novosMateriais);
		return "redirect:/Estoque/material/alterar"; 
	}
	
	@DeleteMapping(value = "/Estoque/material/alterar/{codigo}")
	public String deletarItem(@PathVariable String codigo) {
		cadastroService.deletarMaterial(codigo);
		return "redirect:/Estoque/material/alterar"; 
	}
	
	
}
