package com.EstoqueMateriais.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_materiais")
public class Materiais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo 'Código' não pode estar em branco.")
	private String codigo;
	
	@NotBlank(message = "O campo 'Item' não pode estar em branco.")
	private String item;
	
	private String descricao;
	
	private String unidade;
	
	private int estoque;
	
	private String observacao;
	
	private String codNcm;
	
//	@OneToOne(mappedBy = "EstoqueId")
//	private EstoqueMateriais codigoItemEstoque;
	
	@OneToMany(mappedBy = "EstoqueId")
    private List<EstoqueMateriais> codigoItemEstoque = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getCodNcm() {
		return codNcm;
	}

	public void setCodNcm(String codNcm) {
		this.codNcm = codNcm;
	}

	public List<EstoqueMateriais> getCodigoItemEstoque() {
		return codigoItemEstoque;
	}

	public void setCodigoItemEstoque(List<EstoqueMateriais> codigoItemEstoque) {
		this.codigoItemEstoque = codigoItemEstoque;
	}
	

	
	
	
	

	
	
	
	

	
	
	
	
	
}
