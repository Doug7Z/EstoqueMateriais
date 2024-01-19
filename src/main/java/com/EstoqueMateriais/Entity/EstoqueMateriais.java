package com.EstoqueMateriais.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estoque")
public class EstoqueMateriais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@OneToOne
//	@JoinColumn(name = "IdItem")
//	private Materiais EstoqueId;
	
	@ManyToOne
	@JoinColumn(name = "IdItem")
	private Materiais EstoqueId;
	
	
	private int qtdEstoqueEntrada; 
	
	private String nomeComprador;
	
	private String dataAtual;

	private String numeroNotaFiscal;
	
	private String dataEmissaoNF;
	
	private String fornecedor;
	
	private String transportadora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Materiais getEstoqueId() {
		return EstoqueId;
	}

	public void setEstoqueId(Materiais estoqueId) {
		EstoqueId = estoqueId;
	}

	public int getQtdEstoqueEntrada() {
		return qtdEstoqueEntrada;
	}

	public void setQtdEstoqueEntrada(int qtdEstoqueEntrada) {
		this.qtdEstoqueEntrada = qtdEstoqueEntrada;
	}

	public String getNomeComprador() {
		return nomeComprador;
	}

	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}

	public String getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(String dataAtual) {
		this.dataAtual = dataAtual;
	}

	public String getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}

	public void setNumeroNotaFiscal(String numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}

	public String getDataEmissaoNF() {
		return dataEmissaoNF;
	}

	public void setDataEmissaoNF(String dataEmissaoNF) {
		this.dataEmissaoNF = dataEmissaoNF;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}
	
	

	
		

	
	
	
	

	
	
	
	
	
	
	
}
