package com.idomine.admin.web.tarefa.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.idomine.admin.domain.tarefa.model.Tarefa;
import com.idomine.admin.domain.tarefa.service.TarefaFacade;

@Named
@ViewScoped
public class CadastroTarefaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Tarefa tarefa = new Tarefa();
	
	private Long idTarefa;
	
	@Inject
	private TarefaFacade tarefaService;
	
	
	public void inicializar() {
		if (idTarefa != null) {
			tarefa = tarefaService.porId(idTarefa);
		}
	}
	
	
	public String salvar() {
		tarefaService.salvar(tarefa);
		return "lista-tarefa.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		tarefaService.excluir(tarefa);
		return "lista-tarefa.xhtml?faces-redirect=true";
	}


	public Tarefa getTarefa() {
		return tarefa;
	}


	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}


	public Long getIdTarefa() {
		return idTarefa;
	}


	public void setIdTarefa(Long idTarefa) {
		this.idTarefa = idTarefa;
	}

}
