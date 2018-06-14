package com.idomine.admin.web.tarefa.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.idomine.admin.domain.tarefa.model.Tarefa;
import com.idomine.admin.domain.tarefa.service.TarefaFacade;
import com.idomine.admin.infrastructure.helper.FacesHelper;

@Named
@ViewScoped
public class ListaTarefaMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaFacade tarefaService;
	
	private List<Tarefa> tarefas = new ArrayList<>();
	
	private List<Tarefa> tarefaSelecionadas = new ArrayList<>();
	
		

	@PostConstruct
	public void inicializar() {
		tarefas = tarefaService.listAll();		
	}
	
	public void excluirSelecionados() {
		for (Tarefa tarefa : tarefaSelecionadas) {
			tarefaService.excluir(tarefa);
			tarefas.remove(tarefa);
		}
		
		FacesHelper.addInfoMessage("Tarefa(s) excluída(s) com sucesso!");
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Tarefa> getTarefaSelecionadas() {
		return tarefaSelecionadas;
	}

	public void setTarefaSelecionadas(List<Tarefa> tarefaSelecionadas) {
		this.tarefaSelecionadas = tarefaSelecionadas;
	}


}
