package com.idomine.admin.domain.tarefa.model;

public enum Status {
	
	ANDAMENTO("Em Andamento"),
	FINALIZADO("Finalizado");
	
	private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
