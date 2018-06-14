package com.idomine.admin.domain.tarefa.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idomine.admin.domain.tarefa.model.Tarefa;

@Service
public class TarefaFacade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaService tarefaDAO;	
	
	@Transactional
	public void salvar(Tarefa tarefa) {
		if (tarefa.isIncluindo()) {
			tarefa.setCriacao(new Date());
		}
		
		if (tarefa.isEditando()) {
			tarefa.setEdicao(new Date());
		}
		
		tarefaDAO.salvar(tarefa);
	}

	@Transactional
	public void excluir(Tarefa tarefa) {
		tarefaDAO.excluir(tarefa);
	}
	
	
	public List<Tarefa> listAll() {
		return tarefaDAO.listAll();
	}
	
	public Tarefa porId(Long id) {
		return tarefaDAO.porId(id);
	}

}
