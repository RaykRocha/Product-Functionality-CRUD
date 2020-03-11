package br.com.fiap.model;

public class ProdutoModel {

	private long id;
	private String nome;
	private String Sku;
	private String Descricao;
	private Double preco;
	private String caracteristicas;

	public ProdutoModel(long id, String nome, String sku, String descricao, Double preco, String caracteristicas) {
		super();
		this.id = id;
		this.nome = nome;
		Sku = sku;
		Descricao = descricao;
		this.preco = preco;
		this.caracteristicas = caracteristicas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSku() {
		return Sku;
	}

	public void setSku(String sku) {
		Sku = sku;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
}
